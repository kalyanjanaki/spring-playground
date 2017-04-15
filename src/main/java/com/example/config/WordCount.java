package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by trainer20 on 4/15/17.
 */
@Component
@ConfigurationProperties("wordCount")
public class WordCount {
    private boolean caseSensitve;
    private List<String > words;

    public boolean isCaseSensitve() {
        return caseSensitve;
    }

    public void setCaseSensitve(boolean caseSensitve) {
        this.caseSensitve = caseSensitve;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
}
