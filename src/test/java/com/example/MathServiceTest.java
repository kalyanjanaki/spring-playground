package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by trainer20 on 3/30/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MathService.class)
public class MathServiceTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testMathOperation() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?x=4&y=2");

        this.mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("6"));
    }

    @Test
    public void testMatSum() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.post("/math/sum?n=2&n=2&n=2");

        this.mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("6"));
    }
}
