package com.test.java.algorithm.code.linkedlist;


import com.test.java.algorithm.offer.ListNode;
import com.test.java.algorithm.offer.ListNodeUtil;

/**
 * Created by Micheal on 2020/11/16.
 * 链表操作
 */
public class TestLinkedListV2 {
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.initDisorderNode();
        ListNode listNodeTwo = ListNodeUtil.initListNodeTwo();
        TestLinkedListV2 test = new TestLinkedListV2();
//        ListNode listNode1 = test.deleteNode(listNode, 4);
//        ListNode listNode1 = test.joinListNode(listNode, listNodeTwo);
        ListNode sortNode = test.insertNode(listNode);
        ListNodeUtil.printListNode(sortNode);
    }

    public ListNode insertNode(ListNode node) {
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

    public ListNode sortNode(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode middle = getMiddleNode(node);
        return null;
    }

    public ListNode getMiddleNode(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode slow = node;
        ListNode fast = slow.next;

        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public ListNode joinListNode(ListNode one, ListNode two) {
        if (one == null || two == null) {
            return one == null ? two : one;
        }
        ListNode pre = new ListNode(-1);
        ListNode head = pre;
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

    public ListNode reverseNode(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public ListNode deleteNode(ListNode node, int val) {
        if (node == null) {
            return null;
        }
        ListNode temp = node;
        if (temp.val == val) {
            temp = node.next;
            node = null;
            return temp;
        }
        ListNode pre = temp;
        while (temp.next != null) {
            ListNode next = temp.next;
            if (next.val == val) {
                pre.next = next.next;
                next = null;
                break;
            }
            temp = next;
            pre = temp;

        }
        return node;
    }
}
