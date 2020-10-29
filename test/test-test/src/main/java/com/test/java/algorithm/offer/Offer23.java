package com.test.java.algorithm.offer;

/**
 * Created by Micheal on 2020/10/29.
 * 环形链表，求链表中的环，环的位置
 */
public class Offer23 {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        //1.判断是否有环
        //2.如果有环，求出环中的元素个数
        //3.求环的入口位置
        return null;
    }

    public ListNode detectCycleOne(ListNode head) {
        ListNode meetingNode = meetingNode(head);
        if (meetingNode == null) {
            return null;
        }
        int nodeInLoop = 1;
        ListNode node = meetingNode;
        while (node.next != meetingNode) {
            node = node.next;
            nodeInLoop++;
        }
        ListNode one = head;
        for (int i = 0; i < nodeInLoop; i++) {
            one = one.next;
        }
        ListNode two = head;
        while (one != two) {
            one = one.next;
            two = two.next;
        }
        return one;
    }

    public ListNode meetingNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head.next;
        if (slow == null) {
            return null;
        }
        ListNode fast = slow.next;
        if (fast == null) {
            return null;
        }
        while (fast != null && slow != null) {
            if (fast == slow) {
                return fast;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }
}
