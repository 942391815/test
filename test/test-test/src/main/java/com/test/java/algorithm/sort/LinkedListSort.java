package com.test.java.algorithm.sort;

/**
 * Created by Micheal on 2020/2/6.
 */
public class LinkedListSort {
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

        Node pre = head;
        //当前待排序的节点
        Node cur = head.next;
        //辅助节点，永远指向头结点
        Node aux = new Node(0);
        aux.next = head;
        while (cur != null) {
            if (cur.val < pre.val) {
                //先把cur节点从当前链表中删除，然后再把cur节点插入到合适位置
                pre.next = cur.next;
                //从前往后找到node2.val>cur.val,然后把cur节点插入到node1和node2之间
                Node node1 = aux;
                Node node2 = aux.next;
                while (cur.val > node2.val) {
                    node1 = node2;
                    node2 = node2.next;
                }
                //把cur节点插入到node1和node2之间
                node1.next = cur;
                cur.next = node2;
                //cur节点向后移动一位
                cur = pre.next;

            } else {
                //向后移动
                pre = cur;
                cur = cur.next;
            }
        }
        return aux.next;
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
