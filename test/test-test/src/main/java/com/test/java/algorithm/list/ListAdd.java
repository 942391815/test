package com.test.java.algorithm.list;

/**
 * Created by Micheal on 2020/3/14.
 */
public class ListAdd {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode next = new ListNode(8);
        l1.next = next;
        ListNode l2 = new ListNode(0);
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            return null;
        }
        if(l1==null || l2==null){
            return l1==null?l2:l1;
        }

        ListNode head = new ListNode(-1);
        ListNode tempNode = head;
        int temp = 0;
        while(l1!=null && l2!=null){
            int val = l1.val+l2.val+temp;
            if(val>=10){
                val = val-10;
                temp = 1;
            }else{
                temp = 0;
            }
            ListNode node = new ListNode(val);
            tempNode.next = node;
            tempNode = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remain = l1!=null ?l1:l2;
        while(remain!=null){
            int tempVal = remain.val+temp;
            if(tempVal>=10){
                tempVal = tempVal-10;
                temp = 1;
            }else{
                tempVal=0;
            }
            ListNode node = new ListNode(tempVal);
            tempNode.next = node;
            tempNode = node;
            remain = remain.next;
        }
        if(temp!=0){
            ListNode node = new ListNode(1);
            tempNode.next = node;
        }

        return head.next;
    }
}
