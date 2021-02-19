package com.test.java.algorithm.sort;

public class LinkedListInsertSort {
    public static void main(String[] args) {
        ListNode one = new ListNode(0);
        ListNode two = new ListNode(-1);
        ListNode three = new ListNode(-2);
        ListNode four = new ListNode(10);
        one.next = two;
        two.next = three;
        three.next = four;

        LinkedListInsertSort test = new LinkedListInsertSort();
        test.insertionSortList(one);
    }

    public ListNode insertionSortList(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode temp = new ListNode(-1);
        while (node != null) {
            ListNode eachNode = node;
            node = node.next;
            eachNode.next = null;
            temp = insertNode(temp, eachNode);
        }
        return temp.next;
    }

    public ListNode insertNode(ListNode org, ListNode node) {
        if (org.next == null) {
            org.next = node;
            return org;
        }
        ListNode head = org;
        while (org.next != null && org.next.val <= node.val) {
            org = org.next;
        }
        ListNode next = org.next;
        org.next = node;
        node.next = next;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "\t");
            head = head.next;
        }
    }
}
