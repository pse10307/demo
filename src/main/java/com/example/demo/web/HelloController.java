package com.example.demo.web;

import com.example.demo.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto") // (1)
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) { // (2)
        return new HelloResponseDto(name, amount);  // (3)
    }
    /* (1) 사용자가 /hello/dto url에 접근하면 해당 url의 리소스를 가져오기 위해 서버에 get 요청을 함.
            그 요청을 해당 매소드 ( helloDto(~~) )가 요청을 수행.

       (2) @RequestParam은 각 매개 변수 앞에 붙는 annotation 이는 http 요청의 파라미터
            클라이언트가 요청을 보낼 때 URL에 "?name=값&amount=값"과 같은 형식으로 파라미터를 전달하면, 이 메소드는 그 값을 받아서 사용합니다.

       (3) get 요청과 함께 보내지는 파라미터를 받아 HelloResponseDto 객체를 생성하과 반환함.
    */

}
