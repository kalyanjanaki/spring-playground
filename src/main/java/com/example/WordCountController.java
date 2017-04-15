package com.example;

import com.example.utils.WordCounter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by trainer20 on 4/14/17.
 */
@RestController
public class WordCountController {

    private final WordCounter counter;

    public WordCountController(WordCounter counter) {
        this.counter = counter;
    }

    @PostMapping("/words/count")
    public Map<String,Integer> getWorCounts(@RequestBody String input){
        return counter.getCounts(input);
    }
}
