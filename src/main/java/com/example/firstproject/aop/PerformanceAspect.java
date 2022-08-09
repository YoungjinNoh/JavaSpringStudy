package com.example.firstproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class PerformanceAspect {
    //target specific annotation
    @Pointcut("@annotation(com.example.firstproject.annotation.RunningTime)")
    private void enableRunningTime(){
    }

    //target all method in basic package
    @Pointcut("execution(* com.example.firstproject..*.*(..))")
    private void cut() {
    }

    //select execution timing: both before and after in method that ok all condition
    @Around("cut() && enableRunningTime()")
    public void loggingRunningTime(ProceedingJoinPoint joinPoint) throws Throwable{
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();

        Object returningObj=joinPoint.proceed();

        stopWatch.stop();

        String methodName = joinPoint.getSignature()
                .getName();

        log.info("{} running time => {} sec",methodName,stopWatch.getTotalTimeSeconds());
    }
}
