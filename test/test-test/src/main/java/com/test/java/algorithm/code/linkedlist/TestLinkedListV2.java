package com.test.java.algorithm.code.linkedlist;


import com.test.java.algorithm.offer.ListNode;
import com.test.java.algorithm.offer.ListNodeUtil;
import com.test.java.algorithm.offer.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Micheal on 2020/11/16.
 * 链表操作
 */
public class TestLinkedListV2 {
    List<List<Integer>> resultList = new ArrayList<>();

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.initListNodeOne();
        ListNode listNodeTwo = ListNodeUtil.initListNodeTwo();
        TestLinkedListV2 test = new TestLinkedListV2();
        //删除节点
//        ListNode listNode1 = test.deleteNode(listNode, 3);
        //反转单链表
//        ListNode listNode1 = test.reverseNode(listNode);
//        ListNodeUtil.printListNode(listNode1);
//        ListNode listNode1 = ListNodeUtil.initListCycleNode();
//        System.out.println(test.hasCycle(listNode1));
//        System.out.println(test.getCycleNode(listNode1).val);
        //
//        System.out.println(test.isOverlapping(listNode, listNodeTwo));
//        ListNode listNode1 = test.joinNode(listNode, listNodeTwo);
//        ListNodeUtil.printListNode(listNode1);
//        System.out.println(test.lastK(listNode, 10));
        //单链表排序
//        test.sortListNode(listNode);
        ListNode result = test.reverseBetweenV1(listNode, 2, 4);
        ListNodeUtil.printListNode(result);
        //删除重复节点
//        ListNode repeatNode = ListNodeUtil.initRepeadNode();
//        repeatNode = test.deleteRepeatNode(repeatNode);
//        ListNodeUtil.printListNode(repeatNode);
        //判断是否是回文
//        System.out.println(test.symmetric(repeatNode));
//        test.getMiddle(listNode);
//        System.out.println(test.findNthDigitV1(11));
//        System.out.println(test.getCount(2));
//        System.out.println(test.translateNum(12258));


    }

    ListNode reverseBetweenV1(ListNode node, int start, int end) {
        if (node == null) {
            return null;
        }
        ListNode p = null;
        ListNode q = node;
        for (int i = 0; i < start - 1; i++) {
            if (node != null) {
                p = q;
                q = q.next;
            } else {
                return node;
            }
        }
        for (int i = 0; i < end - start; i++) {
            ListNode remove = q.next;
            q.next = q.next.next;
            remove.next = p.next;
            p.next = remove;
        }
        return node;
    }

    ListNode deleteRepeatNode(ListNode node) {
        if (node == null) {
            return null;
        }
        Set<Integer> temp = new HashSet<>();
        ListNode seq = node;
        temp.add(seq.val);
        while (seq.next != null) {
            ListNode tempNode = seq.next;
            int val = seq.next.getVal();
            if (temp.contains(val)) {
                while (tempNode != null && tempNode.val == val) {
                    tempNode = tempNode.next;
                }
                seq.next = tempNode;
            } else {
                temp.add(val);
                seq = seq.next;
            }
        }
        return node;
    }

    private ListNode joinNode(ListNode one, ListNode two) {
        if (one == null) {
            return two;
        }
        if (two == null) {
            return one;
        }
        ListNode temp = new ListNode(-1);
        ListNode pre = temp;
        while (one != null && two != null) {
            if (one.val > two.val) {
                temp.next = two;
                two = two.next;
            } else {
                temp.next = one;
                one = one.next;
            }
            temp = temp.next;
        }
        temp.next = one == null ? two : one;
        return pre.next;
    }

    private boolean isOverlapping(ListNode one, ListNode two) {
        if (one == null || two == null) {
            return false;
        }
        ListNode oneLen = one;
        ListNode twoLen = two;
        int len1 = 0;
        int len2 = 0;
        while (oneLen != null) {
            len1++;
            oneLen = oneLen.next;
        }
        while (twoLen != null) {
            len2++;
            twoLen = twoLen.next;
        }
        int diff = Math.abs(len1 - len2);
        if (len1 > len2) {
            for (int i = 0; i < diff; i++) {
                one = one.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                two = two.next;
            }
        }
        while (one != null && two != null) {
            if (one.val == two.val) {
                return true;
            } else {
                one = one.next;
                two = two.next;
            }
        }
        return false;
    }

    private ListNode getCycleNode(ListNode listNode) {
        ListNode cycleNode = hasCycle(listNode);
        if (cycleNode == null) {
            return null;
        }
        ListNode temp = cycleNode.next;
        int count = 1;
        while (temp.val != cycleNode.val) {
            temp = temp.next;
            count++;
        }
        ListNode p1 = listNode;
        for (int i = 0; i < count; i++) {
            p1 = p1.next;
        }
        ListNode p2 = listNode;
        while (p1.val != p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    //链表是否有环
    private ListNode hasCycle(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        ListNode slow = listNode;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            if (slow.val == fast.val) {
                return slow;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return null;
    }

    private ListNode reverseNode(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        ListNode pre = null;
        while (listNode != null) {
            ListNode temp = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = temp;
        }
        return pre;

    }

    private ListNode deleteNode(ListNode listNode, int num) {
        if (listNode == null) {
            return null;
        }
        if (Objects.equals(listNode.getVal(), num)) {
            return listNode.next;
        }
        ListNode temp = listNode;
        while (temp.next != null && temp.next.val != num) {
            temp = temp.next;
        }
        ListNode next = temp.next;
        if (next != null) {
            temp.next = temp.next.next;
        }
        return listNode;
    }
}
