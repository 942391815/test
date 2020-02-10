package com.test.java.algorithm.list;

/**
 * Created by micheal on 2020/1/7.
 */
public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public static void main(String[] args) {

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
