package com.example.exercises;

import java.util.*;

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        if(p1.score == p2.score) {
            return p1.name.compareTo(p2.name);
        }
        return p2.score - p1.score;
    }
}

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class ComparatorExample {

    public static void main(String[] args) {

        int n = 18;
        String[] names = {"bcaab",
                "bc",
                "acbb",
                "b",
                "bcbc",
                "cc",
                "caba",
                "bcbbb",
                "bbac",
                "bb",
                "bb",
                "aabca",
                "ba",
                "bcba",
                "bbbb",
                "cacab",
                "bccac",
                "a"};
        int[] scores = {7, 6, 0, 10, 6, 5, 7, 3, 8, 11, 7, 10, 10, 11, 10, 10, 6, 4};


        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(names[i], scores[i]);
        }

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
