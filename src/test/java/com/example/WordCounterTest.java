package com.example;

import com.example.config.WordCount;
import com.example.utils.WordCounter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer20 on 4/14/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(WordCountController.class)
public class WordCounterTest {

    @MockBean
    WordCounter counter;

    @Autowired
    private MockMvc mvc;

    @Test
    public void testPlainWordCount(){
        WordCount config = new WordCount();
        config.setCaseSensitve(false);
        config.setWords(new ArrayList<String>());
        WordCounter internalCounter = new WordCounter(config);
        Long answer = internalCounter.getCounts("how now get").get("now").longValue();
        assertEquals(new Long(answer),new Long(1));
    }

    @Test
    public void testWordCounts() throws Exception
    {
        RequestBuilder request = MockMvcRequestBuilders.post("/words/count").contentType(MediaType.TEXT_PLAIN)
                .content("how now get");
        this.mvc.perform(request).andExpect(status().isOk());
    }



}
