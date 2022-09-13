package com.ll.exam.app10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class AppTests {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("메인화면에서는 안녕이 나와야한다.")
    void t1() throws Exception {
        //when
        //get
        ResultActions resultActions = mvc.perform(get("/"))
                .andDo(print());
        //then
        // 안녕
        resultActions
                .andExpect(status().is2xxSuccessful())
                .andExpect(handler().methodName("main"))
                .andExpect(content().string(containsString("안녕")));
    }
}
