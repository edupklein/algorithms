package com.example.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Islands {

    public int[][] matrix;
    public Map<String, List<Cell>> graph;
    public Integer numIslands;

    public Islands(int[][] matrix) {
        this.matrix = matrix;
    }

    public static void main(String args[]) {
        int[][] matrix = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        
        Islands map = new Islands(matrix);

        map.countIslands();

        System.out.println(String.valueOf(map.numIslands));
    }

    public void countIslands() {

        this.graph = buildGraph();
        this.numIslands = 0;

        //Tracks the current cell being tested, starts in 0,0
        Cell currentCell = new Cell(0, 0);
        // List to keep track of the already visited cells
        Map<String, Cell> alreadyVisited = new HashMap<>();

        // Adds the current 0,0 cell to the Lists
        alreadyVisited.put(currentCell.hashKey(), currentCell);

        // While not in destination
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {

                if(matrix[row][col] == 1) {

                    Cell curCell = new Cell(row, col);
    
                    if(!alreadyVisited.containsKey(curCell.hashKey())) {
                        findIsland(curCell, alreadyVisited);
                    }
                }
            }
        }
    }

    private Map<String, List<Cell>> buildGraph() {

        Map<String, List<Cell>> graph = new HashMap<>();

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {

                if(matrix[row][col] == 1) {

                    Cell currentCell = new Cell(row, col);
                    String cellHashKey = currentCell.hashKey();

                    if(graph.get(cellHashKey) == null) {
                        graph.put(cellHashKey, new ArrayList<>());
                    }

                    List<Cell> adjacentNodes = graph.get(cellHashKey);

                    if(row - 1 >= 0) {
                        if(matrix[row - 1][col] != 0) {
                            adjacentNodes.add(new Cell(row - 1, col));
                        }
                    }

                    if(col - 1 >= 0) {
                        if(matrix[row][col - 1] != 0) {
                            adjacentNodes.add(new Cell(row, col - 1));
                        }
                    }

                    if(row + 1 < matrix.length) {
                        if(matrix[row + 1][col] != 0) {
                            adjacentNodes.add(new Cell(row + 1, col));
                        }
                    }

                    if(col + 1 < matrix[0].length) {
                        if(matrix[row][col + 1] != 0) {
                            adjacentNodes.add(new Cell(row, col + 1));
                        }
                    }
                }
            }
        }

        return graph;
    }

    private void findIsland(Cell currentCell, Map<String, Cell> alreadyVisited) {

        Cell nextCellToMove;

        // If it gets here, it means we are stuck and have to go back
        while(currentCell != null) {

            nextCellToMove = findNextAccessibleCell(currentCell, alreadyVisited);

            if(nextCellToMove == null) {
                numIslands++;
                break;                    
            }else{
                alreadyVisited.put(nextCellToMove.hashKey(), nextCellToMove);
                currentCell = nextCellToMove;
            }
        }
    }

    private Cell findNextAccessibleCell(Cell currentCell, Map<String, Cell> alreadyVisited) {

        List<String> pile = new ArrayList<>();

        List<String> pileVisited = new ArrayList<>();
        
        for(Cell adjacentNode: this.graph.get(currentCell.hashKey())) {
            if(!alreadyVisited.containsKey(adjacentNode.hashKey())) {
                return adjacentNode;
            }else{
                pile.add(adjacentNode.hashKey());
            }
        }
        while(pile.size() > 0) {

            String key = pile.get(pile.size() - 1);
            pile.remove(key);

            for(Cell adjacentNode: this.graph.get(key)) {
                if(!alreadyVisited.containsKey(adjacentNode.hashKey())) {
                    return adjacentNode;
                }else{
                    if(!pileVisited.contains(adjacentNode.hashKey())) {
                        pile.add(adjacentNode.hashKey());
                        pileVisited.add(adjacentNode.hashKey());
                    }
                }
            }

        }

        return null;
    }

}
