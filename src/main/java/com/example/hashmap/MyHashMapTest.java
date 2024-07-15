package com.example.hashmap;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, String> hm = new MyHashMap<>();
        
        hm.put("teste 1", "1");

        hm.put("teste 2", "2");

        hm.put("teste 3", "3");

        hm.put("teste 4", "4");
    
        System.out.println(hm.toString());

        hm.remove("teste 4");

        System.out.println(hm.toString());

        hm.put("teste 3", "novo valor teste 3");

        System.out.println(hm.toString());
    }
}