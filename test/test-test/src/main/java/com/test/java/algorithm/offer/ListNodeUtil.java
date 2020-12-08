package com.test.java.algorithm.offer;

/**
 * Created by Micheal on 2020/10/20.
 */
public class ListNodeUtil {
    public static ListNode initListNodeOne() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        return one;
    }

    public static ListNode initListNodeThree() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;
        return one;
    }

    public static ListNode initRepeadNode() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(1);
        one.next = two;
        two.next = three;
        three.next = four;
        return one;
    }

    public static ListNode initListNodeTwo() {
        ListNode one = new ListNode(0);
        ListNode two = new ListNode(4);
//        ListNode three = new ListNode(10);
        one.next = two;
//        two.next = three;
        return one;
    }

    public static ListNode initDisorderNode() {
        ListNode one = new ListNode(0);
        ListNode two = new ListNode(100);
        ListNode three = new ListNode(10);
        ListNode four = new ListNode(50);
        one.next = two;
        two.next = three;
        three.next = four;
        return one;
    }


    public static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " \t");
            listNode = listNode.next;
        }
    }

    public static ListNode initListCycleNode() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = three;
        return one;
    }
}
