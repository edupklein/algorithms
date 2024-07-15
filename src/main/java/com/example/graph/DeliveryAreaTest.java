package com.example.graph;

import java.util.List;

public class DeliveryAreaTest {

    public static void main(String[] args) {
        
        int[][] matrix = {{1, 1, 0, 0}, {0, 1, 0, 1}, {0, 1, 1, 1}, {0, 0, 2, 1}};
        DeliveryArea area = new DeliveryArea(matrix);

        List<Cell> path = area.findRoute();

        System.out.println(path.toString());
        
    }
}