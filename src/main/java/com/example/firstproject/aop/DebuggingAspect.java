package com.example.firstproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class DebuggingAspect {
    //select target method: CommentService#create()
    @Pointcut("execution(* com.example.firstproject.service.CommentService.*(..))")
    private void cut() {
    }

    @Before("cut()") //select execution timing: before execute cut()
    public void loggingArgs(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        //get class name
        String className = joinPoint.getTarget()
                .getClass()
                .getSimpleName();

        //get method name
        String methodName = joinPoint.getSignature()
                .getName();

        for (Object obj : args) {
            log.info("{}#{} input value => {}", className, methodName, obj);
        }
    }

    //select execution timing: after cut() is executed success
    @AfterReturning(value = "cut()", returning = "returnObj")
    public void loggingReturnValue(JoinPoint joinPoint, Object returnObj) {
        //get class name
        String className = joinPoint.getTarget()
                .getClass()
                .getSimpleName();

        //get method name
        String methodName = joinPoint.getSignature()
                .getName();
        log.info("{}#{} return value => {}", className, methodName, returnObj);
    }
}
