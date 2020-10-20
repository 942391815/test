package com.test.java.algorithm.offer;

/**
 * Created by Micheal on 2020/10/20.
 */
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int result[] = new int[count];
        int start = result.length - 1;
        for (int i = start; i >= 0; i--) {
            result[i] = head.val;
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode one = ListNodeUtil.initListNode();
        Offer06 offer06 = new Offer06();
        int[] result = offer06.reversePrint(one);
        System.out.println(result);
    }
}
