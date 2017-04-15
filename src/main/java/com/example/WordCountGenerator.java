package com.example;

import com.example.utils.WordCounter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by trainer20 on 4/14/17.
 */
@Configuration
public class WordCountGenerator {

    @Bean
    public WordCounter getWordCounter(){
        return new WordCounter();
    }
}
