package com.example.firstproject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //일반컨트롤러는 뷰템플릿페이지를 반환하는 반면 rest컨트롤러는 json을 반환
public class FirstApiController {
    @GetMapping("/api/hello")
    public String hello(){
        return "hello world!";
    }
}
