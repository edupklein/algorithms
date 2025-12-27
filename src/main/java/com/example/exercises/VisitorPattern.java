package com.example.exercises;

import java.awt.*;
import java.util.ArrayList;

abstract class Tree {
    private int value;
    private Color color;
    private int depth;
    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }
    public int getValue() {
        return value;
    }
    public Color getColor() {
        return color;
    }
    public int getDepth() {
        return depth;
    }
    public abstract void accept(TreeVis visitor);
}
class TreeNode extends Tree {
    private ArrayList<Tree> children = new ArrayList<>();
    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }
    public void accept(TreeVis visitor) {
        visitor.visitNode(this);
        for (Tree child : children) {
            child.accept(visitor);
        }
    }
    public void addChild(Tree child) {
        children.add(child);
    }
}
class TreeLeaf extends Tree {
    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }
    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}
abstract class TreeVis {
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);
}

public class VisitorPattern {


    
}
