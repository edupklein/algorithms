package com.example.tree;

import com.example.tree.BinaryTree.Order;

public class BinaryTreeTest {

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree(15);
        bt.insert(9);
        bt.insert(16);
        bt.insert(20);
        bt.insert(99);
        bt.insert(1);
        bt.insert(5);
        bt.insert(2);
        bt.insert(3);
        bt.insert(8);
        bt.insert(75);
        bt.insert(78);
        bt.insert(150);
        bt.insert(66);

        bt.printTree(Order.INORDER);

        bt.printTree(Order.POSTORDER);

        bt.printTree(Order.PREORDER);
    }
}