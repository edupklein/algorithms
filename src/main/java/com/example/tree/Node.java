package com.example.tree;

public class Node {
    
    public int data;
    public Node left;
    public Node right;

    public Node (int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
