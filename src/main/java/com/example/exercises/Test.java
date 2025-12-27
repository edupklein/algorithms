package com.example.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("test");
        list.add("test2");
        list.add("  ");
        filterOutEmptyStrings(list);
    }


    public static List<String> filterOutEmptyStrings(List<String> input) {
        // Java 11 introduces new type of Predicate - please use it here


        Predicate<String> predicate = s -> !s.isBlank();
        return input.stream()
                .filter(s -> predicate.test(s))
                .collect(Collectors.toList());

        /*
        return input.stream()
                .filter(s -> !"".equals(s))
                .collect(Collectors.toList());
          */
    }
}
