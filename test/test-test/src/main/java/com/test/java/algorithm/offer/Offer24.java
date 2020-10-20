package com.test.java.algorithm.offer;

/**
 * Created by Micheal on 2020/10/20.
 */
public class Offer24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode one = ListNodeUtil.initListNode();
        Offer24 offer24 = new Offer24();
        ListNodeUtil.printListNode(offer24.reverseList(one));
    }
}
