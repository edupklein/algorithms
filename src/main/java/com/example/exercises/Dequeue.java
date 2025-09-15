package com.example.exercises;

import java.util.*;

public class Dequeue {

    public static void main(String[] args) {
        int []ints = {5, 3, 5, 2, 3, 2, 7, 8, 3, 5, 4, 6, 8};
        Deque deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();

        int n = 13;
        int m = 5;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int num = ints[i];

            deque.add(num);
            set.add(num);
            if (deque.size() == m) {
                if (set.size() > max)
                    max = set.size();
                int first = (int) deque.remove();
                if (!deque.contains(first))
                    set.remove(first);
            }
        }
    }
}
