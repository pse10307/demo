package com.example.demo.dto;

import com.example.demo.web.dto.HelloResponseDto;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void lombok_test() {
        //given
        String name = "test";
        int amount=1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}

// main의 HelloResponseDto에서 @Getter와 @RequiredArgsConstructor가 실행되는 지 확인하는 test
// 변수 값을 지정하여 HeResponseDto()를 선언하여 생성자를 통해 정의된 값과 매개변수로 넘겨준 값이 같은 지 확인.
