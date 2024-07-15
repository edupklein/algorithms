package com.example.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DeliveryArea {
 
    public int[][] matrix;

    public DeliveryArea(int[][] matrix) {
        this.matrix = matrix;
    }

    public Map<String, List<Cell>> buildGraph() {
        Map<String, List<Cell>> graph = new HashMap<>();

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {

                // For each cell that has a possible path
                if(matrix[row][col] == 1) {
                    // Instanciate a new Cell Object
                    Cell currentCell = new Cell(row, col);
                    String cellHashKey = currentCell.hashKey();
                    
                    // Checks to see if the grapgh already has the key associated with the cell, if not, create a new List
                    if(graph.get(cellHashKey) == null) {
                        graph.put(cellHashKey, new ArrayList<>());
                    }
                    // Gets the reference of the list of adjacent nodes
                    List<Cell> adjacentNodes = graph.get(cellHashKey);

                    // From here, it checks the neighbour cells to see if any of them has a possible route
                    // Checks to see if the above neighbour is acessible
                    if(row - 1 >= 0) {
                        // If it is, adds it to the list of adjacent nodes
                        if(matrix[row - 1][col] != 0) {
                            adjacentNodes.add(new Cell(row - 1, col));
                        }
                    }
                    // Checks to see if the left neighbour is acessible
                    if(col - 1 >= 0) {
                        // If it is, adds it to the list of adjacent nodes
                        if(matrix[row][col - 1] != 0) {
                            adjacentNodes.add(new Cell(row, col - 1));
                        }
                    }
                    // Checks to see if the below neighbour is acessible
                    if(row + 1 < matrix.length) {
                        // If it is, adds it to the list of adjacent nodes
                        if(matrix[row + 1][col] != 0) {
                            adjacentNodes.add(new Cell(row + 1, col));
                        }
                    }
                    // Checks to see if the right neighbour is acessible
                    if(col + 1 < matrix[0].length) {
                        // If it is, adds it to the list of adjacent nodes
                        if(matrix[row][col + 1] != 0) {
                            adjacentNodes.add(new Cell(row, col + 1));
                        }
                    }
                }
            }
        }
        return graph;
    }

    public List<Cell> findRoute() {
        // Builds the graph with the nodes and adjacent nodes with possible paths
        Map<String, List<Cell>> graph = buildGraph();
        
        //Tracks the current cell being tested, starts in 0,0
        Cell currentCell = new Cell(0, 0);
        // List to keep track of the already visited cells
        List<Cell> alreadyVisited = new LinkedList<>();
        // List to keep track of the final path being constructed. Acts as a pile
        List<Cell> finalPath = new LinkedList<>();

        // Adds the current 0,0 cell to the Lists
        alreadyVisited.add(currentCell);
        finalPath.add(currentCell);

        // While not in destination
        while(matrix[currentCell.row][currentCell.column] != 2) {
            
            Cell nextCellToMove = findNextAccessibleCell(graph, currentCell, alreadyVisited);

            // If it gets here, it means we are stuck and have to go back
            if(nextCellToMove == null) {
                // Sets the current cell to an already visited before the one right now being tested
                currentCell = alreadyVisited.get(alreadyVisited.size() - 2);
                // Remove the last cell from final path
                finalPath.remove(finalPath.size() - 1);
            }else{
                // If we have a path to a next cell, it gets added to the already visited and the final path
                alreadyVisited.add(nextCellToMove);
                finalPath.add(nextCellToMove);
                currentCell = nextCellToMove;
            }
        }

        return finalPath;
    }

    private Cell findNextAccessibleCell(Map<String, List<Cell>> graph, Cell currentCell, List<Cell> alreadyVisited) {

        for(Cell adjacentNode: graph.get(currentCell.hashKey())) {
            if(!alreadyVisited.contains(adjacentNode)) {
                return adjacentNode;
            }
        }
        return null;
    }
}
