package com.test.java.algorithm.list;

/**
 * Created by micheal on 2020/1/7.
 */
public class Node {
    public int value;
    public Node next;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        one.next = two;
        two.next = three;
        printReverse(one);

    }

    public static void printReverse(Node node) {
        if (node != null) {
            Node next = node.next;
            if (next != null) {
                printReverse(next);
            }
            System.out.println(node.value);
        }
        return;
    }

    public static Node reverse(Node node) {
        Node pre = null;
        while (node != null) {
            Node next = node.next;
            node.next = pre;
            pre = node;
            node = next;

//            next = node.next;
//            node.next = pre;
//            pre = node;
//            node = next;
        }
        return node;
    }
}
