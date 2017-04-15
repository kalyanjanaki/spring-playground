package com.example.utils;

import com.example.config.WordCount;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by trainer20 on 4/14/17.
 */
@Service
public class WordCounter {

    private final WordCount config;

    public WordCounter(WordCount config) {
        this.config = config;
    }

    public Map<String,Integer> getCounts(String input) {

        Map<String, Integer> wordsMap = new HashMap<String, Integer>();

        if (input != null) {
            if (config.isCaseSensitve()) {
                for (String s : input.split(" ")) {
                    if(!config.getWords().contains(s)){

                        if (wordsMap.containsKey(s)) {
                            wordsMap.put(s, wordsMap.get(s) + 1);
                        } else {
                            wordsMap.put(s, 1);
                        }
                    }
                }

            } else {
                for (String s : input.split(" ")) {
                    if(!config.getWords().contains(s)){

                        if (wordsMap.containsKey(s.toLowerCase())) {
                            wordsMap.put(s.toLowerCase(), wordsMap.get(s) + 1);
                        } else {
                            wordsMap.put(s.toLowerCase(), 1);
                        }
                    }
                }
            }
        }
        return wordsMap;
    }

}
