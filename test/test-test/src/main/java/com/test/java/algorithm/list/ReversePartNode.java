package com.test.java.algorithm.list;

/**
 * Created by micheal on 2020/1/7.
 * 反转部分单链表
 */
public class ReversePartNode {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        //1->2->3->4->5
        //1->4->3->2->5
        reverseNode(one, 2, 4);
        printNode(one);
    }

    /***
     * 循环方法
     * @param head
     * @return
     */
    public static Node reverseNode(Node head, int m, int n) {
        if (head == null) {
            return null;
        }
        Node preHead = new Node(-1);
        preHead.next = head;
        Node preStart = preHead;
        Node start = head;
        for (int i = 1; i < m; i++) {
            preStart = start;
            start = start.next;
        }
        //find M
        for (int i = 0; i < n - m; i++) {
            Node temp = start.next;
            start.next = temp.next;
            temp.next = preStart.next;
            preStart.next = temp;
        }
        return preHead.next;
    }

    public static void printNode(Node node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}
