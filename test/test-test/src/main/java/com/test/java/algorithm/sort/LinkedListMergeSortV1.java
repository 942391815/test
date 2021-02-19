package com.test.java.algorithm.sort;

/**
 * Created by Micheal on 2020/2/6.
 */
public class LinkedListMergeSortV1 {
    public static void main(String[] args) {
        Node one = new Node(0);
        Node two = new Node(-1);
        Node three = new Node(-2);
        Node four = new Node(10);
        one.next = two;
        two.next = three;
        three.next = four;
        Node sort = sort(one);
        print(sort);
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node rightHead = middle.next;
        middle.next = null;

        Node left = sort(head);
        Node right = sort(rightHead);
        return mergeNode(left, right);
    }

    //获取中间节点
    public static Node getMiddle(Node head) {
        Node slow = head;
        Node fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node mergeNode(Node one, Node two) {
        Node pre = new Node(-1);
        Node head = pre;
        while (one != null && two != null) {
            if (one.val < two.val) {
                head.next = one;
                one = one.next;
            } else {
                head.next = two;
                two = two.next;
            }
            head = head.next;
        }
        head.next = one == null ? two : one;
        return pre.next;
    }

    static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }
}
