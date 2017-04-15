package com.example;

import com.example.config.WordCount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;

/**
 * Created by trainer20 on 4/15/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {
        "wordCount.caseSensitive=false",
        "wordCount.words.skip[0]=the",
        "wordCount.words.skip[1]=an",
        "wordCount.words.skip[2]=a",
})
public class WordCountConfigTest {
    @Autowired
    private WordCount count;

    @Test
    public void testPropertiesAreMappedCorrectly() {
        assertFalse(count.isCaseSensitve());
    }
}
