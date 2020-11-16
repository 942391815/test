package com.test.java.algorithm.code.linkedlist;

import com.test.java.algorithm.offer.ListNode;
import com.test.java.algorithm.offer.ListNodeUtil;

import java.util.Objects;

/**
 * Created by Micheal on 2020/11/16.
 * 链表操作
 */
public class TestLinkedList {
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.initListNodeOne();
        TestLinkedList test = new TestLinkedList();
        //删除节点
//        ListNode listNode1 = test.deleteNode(listNode, 4);
        //反转单链表
//        ListNode listNode1 = test.reverseNode(listNode);
//        ListNodeUtil.printListNode(listNode1);
        ListNode listNode1 = ListNodeUtil.initListCycleNode();
//        System.out.println(test.hasCycle(listNode1));
        System.out.println(test.getCycleNode(listNode1).val);

    }
    //判断是否有环
    public ListNode getCycleNode(ListNode head) {
        ListNode listNode = hasCycle(head);
        if (listNode == null) {
            return null;
        }
        ListNode temp = listNode;
        int nodes = 0;
        while (listNode != null) {
            listNode = listNode.next;
            nodes++;
            if (listNode.val == temp.val) {
                break;
            }
        }
        ListNode fast = head;
        for (int i = 0; i < nodes; i++) {
            fast = fast.next;
        }
        while (head.val != fast.val) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }

    public ListNode hasCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = slow.next;
        while (slow != null && fast.next != null) {
            if (slow.val != fast.val) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                return slow;
            }
        }
        return null;
    }

    public ListNode reverseNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode deleteNode(ListNode head, int value) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        if (Objects.equals(temp.val, value)) {
            head = head.next;
            return head;
        }
        while (temp.next != null && !Objects.equals(temp.next.val, value)) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }
}
