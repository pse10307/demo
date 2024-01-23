package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication   // 내장 WAS에서 실행
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
// 프로젝트의 main class
// @SpringBootApplication 부터 코드를 읽기 때문에 위 코드는 프로젝트의 최상단에 위치해야 함.