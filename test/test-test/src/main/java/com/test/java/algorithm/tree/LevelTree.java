package com.test.java.algorithm.tree;

import java.util.Stack;

/**
 * Created by Micheal on 2020/2/18.
 */
public class LevelTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node one = new Node(2);
        Node two = new Node(3);
        Node three = new Node(4);
        Node four = new Node(5);
        Node five = new Node(6);
        Node six = new Node(7);

        root.left = one;
        root.right = two;
        one.left = three;
        one.right = four;
        two.left = five;
        two.right = six;

        printTree(root);
    }

    public static void printTree(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        int level = 1;
        stack.push(node);
        print(level, stack);
    }

    public static void print(int level, Stack<Node> stack) {
        if (stack.isEmpty()) {
            return;
        }
        System.out.print(level);
        Stack<Node> child = new Stack<>();
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node != null) {
                System.out.print(node.value);
                if (level % 2 != 0) {
                    if (node.left != null) {
                        child.push(node.left);
                    }
                    if (node.right != null) {
                        child.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        child.push(node.right);
                    }
                    if (node.left != null) {
                        child.push(node.left);
                    }
                }
            }
        }
        System.out.println();
        level++;
        print(level, child);
    }
}
