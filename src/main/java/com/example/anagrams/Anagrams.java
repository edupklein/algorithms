package com.example.anagrams;

import java.lang.reflect.Array;
import java.util.*;

public class Anagrams {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        words.add("eat");
        words.add("tea");
        words.add("tan");
        words.add("ate");
        words.add("bat");
        words.add("nat");
        words.add("abc");
        words.add("aad");
        words.add("word");
        words.add("drow");
        words.add("rowd");
        words.add("tab");
        words.add("ada");
        words.add("mouse");
        words.add("seumo");
        
        Anagrams anagrams = new Anagrams();
        

        List<ArrayList<String>> result = anagrams.result(words);
        
        System.out.println(result.toString());
    }

    private List<ArrayList<String>> result(List<String> words) {

        HashMap<String, ArrayList<String>> anagramsMap = new HashMap<String, ArrayList<String>>();
        String key;

        List<ArrayList<String>> arrSaida = new ArrayList<ArrayList<String>>();

        for(String word : words) {
            
            char tempArray[] = word.toCharArray();
            Arrays.sort(tempArray);
            key = new String(tempArray);

            if(anagramsMap.get(key) == null) {
                anagramsMap.put(key, new ArrayList<String>());
            }
            anagramsMap.get(key).add(word);
        }

        for(ArrayList<String> listAnagrams : anagramsMap.values()){
            arrSaida.add(listAnagrams);
        }
        return arrSaida;

    }

}
