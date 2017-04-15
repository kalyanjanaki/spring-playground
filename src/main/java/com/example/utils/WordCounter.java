package com.example.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by trainer20 on 4/14/17.
 */
public class WordCounter {

    public Map<String,Integer> getCounts(String input){

        Map<String,Integer> wordsMap = new HashMap<String,Integer>();

        if(input != null){
            for(String s : input.split(" ")){
                if(wordsMap.containsKey(s)){
                    wordsMap.put(s,wordsMap.get(s) + 1);
                }else{
                    wordsMap.put(s,1);
                }
            }
        }
        return wordsMap;
    }

}
