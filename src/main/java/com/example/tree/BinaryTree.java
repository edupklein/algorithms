package com.example.tree;

import java.util.LinkedList;
import java.util.List;


public class BinaryTree {
    
    enum Order {
        INORDER,
        PREORDER,
        POSTORDER
    }
   
    private Node root;

    public BinaryTree() {}
    
    public BinaryTree(int data) {
        this.root = new Node(data);
    }

    public void insert(int data) {
        this.root = insertDataRec(this.root, data);
    }

    private Node insertDataRec(Node node, int data) {
        if(node == null) {
            node = new Node(data);
        }else if(data < node.data) {
            node.left = insertDataRec(node.left, data);
        }else if(data > node.data) {
            node.right = insertDataRec(node.right, data);
        }

        return node;
    }

    public void printTree(Order order) {
        List<Node> nodes;
        
        switch(order) {
            case INORDER:
                nodes = getInOrderNodesRec(this.root, null);
                break;
            case POSTORDER:
                nodes = getPostOrderNodesRec(this.root, null);
                break;
            case PREORDER:
                nodes = getPreOrderNodesRec(this.root, null);
                break;
            default:
                nodes = getInOrderNodesRec(this.root, null);
        }
        
        StringBuilder sb = new StringBuilder();

        for (Node node : nodes) {
            sb.append(node.toString() + ", ");
        }
        System.out.println(sb.toString());
    }

    private List<Node> getInOrderNodesRec(Node node, List<Node> list) {
        if(list == null) {
            list = new LinkedList<Node>();
        }
        if(node != null) {
            getInOrderNodesRec(node.left, list);
            list.add(node);
            getInOrderNodesRec(node.right, list);
        }

        return list;
    }

    private List<Node> getPreOrderNodesRec(Node node, List<Node> list) {
        if(list == null) {
            list = new LinkedList<Node>();
        }
        if(node != null) {
            list.add(node);
            getInOrderNodesRec(node.left, list);
            getInOrderNodesRec(node.right, list);
        }

        return list;
    }

    private List<Node> getPostOrderNodesRec(Node node, List<Node> list) {
        if(list == null) {
            list = new LinkedList<Node>();
        }
        if(node != null) {
            getInOrderNodesRec(node.left, list);
            getInOrderNodesRec(node.right, list);
            list.add(node);
        }

        return list;
    }
}
