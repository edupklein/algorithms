// # Binary Tree Maximum Path Sum
// #
// # A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
// # A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
// # The path sum of a path is the sum of the node's values in the path.
// # Given the root of a binary tree, return the maximum path sum of any non-empty path.
// #
// # Input: root = [-10,9,20,null,null,15,7]
// # Output: 42
// # Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

package com.example.tree;

class BynaryTreeRoute {
	public static void main (String[] args) {
        BynaryTreeRoute btr = new BynaryTreeRoute();
        
        BinaryTreePath bt = btr.new BinaryTreePath();
        bt.insert(-10);
        bt.insert(9);
        bt.insert(20);
        bt.insert(null);
        bt.insert(null);
        bt.insert(15);
        bt.insert(7);
        bt.insert(12);
        bt.insert(1);

        bt.insert(25);
        bt.insert(30);

        bt.insert(55);
        bt.insert(60);

        bt.insert(70);
        bt.insert(75);

        //bt.insert(100);

        System.out.println(String.valueOf(bt.printNumber()));
        System.out.println(bt.printTree());
    }

  private class BinaryTreePath {
    
    private Node root;
    
    private int maxSum;

//    public BynaryTreePath new() {
  //      return new BynaryTreePath();
    //}

    public BinaryTreePath() {}
  
    public void insert(Integer data) {
        if(data != null) {
            this.root = insertNode(this.root, data.intValue());
        }else{
            this.root = insertNode(this.root, 0);
        }
    }
    
    public Node insertNode(Node node, int data) {
        if(node == null) {
            return new Node(data);
        }
        
        if (node.left == null) {
            node.left = insertNode(node.left, data);
            return node;

        }else if (node.right == null) {
            node.right = insertNode(node.right, data);
            return node;

        }

        int leftLevel = getChildLevel(node.left, 0);
                
        int rightLevel = getChildLevel(node.right, 0);
        
        if(leftLevel <= rightLevel) {
            node.left = insertNode(node.left, data);
        }else{
            node.right = insertNode(node.right, data);
        }
              
        return node;      
    }

    private int getChildLevel(Node node, int level) {
        if(node == null) {
            return level;
        }
        
        if(node.right != null) {
            level++;
        }

        if(node.right != null) {
            return getChildLevel(node.right, level);    
        }
        
        return level;
    }
    
    public int printNumber() {
        maxSum = 0;
        getBestPath(this.root);
        return maxSum;
    }
    
    public int getBestPath(Node node) {
        if(node == null) {
            return 0;
        }

        int leftSum = Math.max(0, getBestPath(node.left));
        int rightSum = Math.max(0, getBestPath(node.right));

        
        
        
        System.out.println("MaxSum atual: " + String.valueOf(maxSum));
        System.out.println("leftSum: " + String.valueOf(leftSum));
        System.out.println("rightSum: " + String.valueOf(rightSum));
        System.out.println("Atual: " + String.valueOf(node.data));




        System.out.println("Soma: " + String.valueOf(leftSum + rightSum + node.data));
        
        maxSum = Math.max(maxSum, leftSum + rightSum + node.data);

        System.out.println("MaxSum novo:  " + String.valueOf(maxSum));
        System.out.println();

        
        
        
        return Math.max(leftSum, rightSum) + node.data;
    }

    public String printTree() {
        StringBuilder sb = new StringBuilder();
        sb = runPrintTree(sb, root);
        return sb.toString();
    }

    private StringBuilder runPrintTree(StringBuilder sb, Node node) {
        if(node != null) {
            runPrintTree(sb, node.left);
            sb.append(String.valueOf(node.data));
            sb.append(" ");
            runPrintTree(sb, node.right);
        }
        return sb;
    }
  }
  
  private class Node {
    
    public int data;
    public Node left;
    public Node right;
    
    public Node(int data) {
      this.data = data;
    }
  }
}

