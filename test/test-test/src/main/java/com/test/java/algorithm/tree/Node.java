package com.test.java.algorithm.tree;

import java.util.*;

/**
 * Created by Micheal on 2020/1/12.
 */
public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public static void main(String[] args) {
        Node tree = getTree();
//        middleRec(tree);
//        firstRec(tree);
//        lastRec(tree);
        first(tree);
//        middle(tree);
//        preOrder(tree);
//        midOrder(tree);
//        afterOrder(tree);
        levelOrder(tree);
    }

    public static void levelOrder(Node root) {
        if (Objects.isNull(root)) {
            return;
        }
        Node cur = root;
        Queue<Node> nodeList = new LinkedList<>();
        nodeList.offer(cur);
        while (!nodeList.isEmpty()) {
            Node poll = nodeList.poll();
            System.out.println(poll.value);
            if (poll.left != null) {
                nodeList.offer(poll.left);
            }
            if (poll.right != null) {
                nodeList.offer(poll.right);
            }
        }
    }

    public static void level(Node node) {

    }

    public static void afterOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        Node curNode;
        while (!s1.isEmpty()) {
            curNode = s1.pop();
            s2.push(curNode);
            if (curNode.left != null) {
                s1.push(curNode.left);
            }
            if (curNode.right != null) {
                s1.push(curNode.right);
            }

        }
        while (!s2.isEmpty()) {
            System.out.println(s2.pop().value);
        }
    }

    public static void midOrder(Node node) {
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.value);
                node = node.right;
            }
        }
    }


    public static void preOrder(Node node) {
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.println(node.value);
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }


    public static void middle(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.println(root.value);
                root = root.right;
            }
        }
    }

    public static void first(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.println(root.value);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public static void lastRec(Node node) {
        if (node == null) {
            return;
        }
        lastRec(node.left);
        lastRec(node.right);
        System.out.println(node.value);
    }

    public static void firstRec(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        firstRec(node.left);
        firstRec(node.right);
    }

    public static void middleRec(Node node) {
        if (node == null) {
            return;
        }
        middleRec(node.left);
        System.out.println(node.value);
        middleRec(node.right);
    }

    public static Node getTree() {
        Node one = new Node();
        Node two = new Node();
        Node three = new Node();
        Node four = new Node();
        Node five = new Node();
        one.value = 1;
        two.value = 2;
        three.value = 3;
        four.value = 4;
        five.value = 5;

        two.left = one;
        two.right = three;
        three.left = four;
        three.right = five;
        return two;
    }
}
