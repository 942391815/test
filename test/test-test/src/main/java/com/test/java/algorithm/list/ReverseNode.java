package com.test.java.algorithm.list;

/**
 * Created by micheal on 2020/1/7.
 * 单链表反转
 */
public class ReverseNode {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);

        one.next = two;
        two.next = three;
//        printNode(one);
//        Node newNode = reverseNode(one);
//        printNode(newNode);
        Node node = reverseNodeWithRecrive(one);
        printNode(node);
    }

    public static Node reverseNodeWithRecrive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head.next;
        Node newHead = reverseNodeWithRecrive(temp);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    /***
     * 循环方法
     * @param node
     * @return
     */
    public static Node reverseNode(Node node) {
        Node pre = null;
        Node next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public static void printNode(Node node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}
