package com.company;

public class Node {

    // also called "value" in a binary tree
    // also called "key" in a binary search tree
    int data;

    Node left;
    Node right;
    Node parent; // used in SimpleBinaryTree + red-black tree

    int height; // used in AVL tree
    boolean color; // used in red-black tree

    /**
     * Constructs a new node with the given data.
     *
     * @param data the data to store in the node
     */
    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}