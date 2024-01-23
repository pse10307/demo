package com.example.demo.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@Getter
/*
@Getter
public class SampleClass {
    private String normalField;
}
로 정의되어 있으면 아래와 같이 get 메소드를 생성함.

public String getNormalField() {
    return this.normalField;
}
*/
@RequiredArgsConstructor
/*
@RequiredArgsConstructor
public class SampleClass {
    private final int importantField;
    private String normalField;
}
위와 같이 클래스가 정의되어 있으면 final 변수에 대해 생성자를 자동으로 추가함.

public SampleClass(int importantField) {
    this.importantField = importantField;
}

 */
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
