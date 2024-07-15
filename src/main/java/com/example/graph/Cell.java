package com.example.graph;

public class Cell {
    
    public int row;
    public int column;

    public Cell (int row, int column) {
        this.row = row;
        this.column = column;
    }

    public String hashKey() {
        return String.valueOf(row) + String.valueOf(column);
    }

    @Override
    public String toString() {
        return String.valueOf(row) + String.valueOf(column);
    }
    /*
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        
        if(o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if(row != cell.row) return false;

        return column == cell.column;
    }*/
}
