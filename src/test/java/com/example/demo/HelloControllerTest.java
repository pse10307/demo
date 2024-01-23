package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
//SpringBootTest와 junit사이에 연결자.
@WebMvcTest
//Spring annotation 중 web에 집중됨.
public class HelloControllerTest {

    @Autowired
    // spring이 관리하는 bean을 주입 받음
    private MockMvc mvc;
    // 웹 api 테스트에 사용되며, 스프링 MVC테스트의 시작점
    @Test
    public void hello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                // MockMvc를 통해 /hello 주소로 http get 요청, 아래와 같은 검증 기능을 수행할 수 있음.
                .andExpect(status().isOk())
                // http의 상태 검증, 여기서는 OK(200)인지 검증
                .andExpect(content().string(hello));
                // 응답 본문의 내용 검증 return 값이 hello 값인지 검증
    }

    @Test
    public void helloDto_return() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto").param("name", name)
                                            .param("amount", String.valueOf(amount))) // (1)
                                            .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));  // (2)
    }
    /*
    (1) "/hello/dto"로 get 요청을 보내면서 name, amount 파라미터를 함께 보냄.
    (2) "$.name" : JSON 객체에서 "name" 필드를 선택하라는 의미
        is(name) : 필드 값이 name(hello)과 같아야 함.

        * JSON : 'key - value'의 쌍(필드)으로 이루어진 데이터 객체를 문자열로 표현
     */
}
