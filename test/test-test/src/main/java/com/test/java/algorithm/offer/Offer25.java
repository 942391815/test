package com.test.java.algorithm.offer;

/**
 * Created by Micheal on 2020/10/22.
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * 0 <= 链表长度 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer25 {

    public static void main(String[] args) {
        ListNode one = ListNodeUtil.initListNodeOne();
        ListNode two = ListNodeUtil.initListNodeTwo();
        Offer25 offer25 = new Offer25();
        ListNode listNode = offer25.mergeTwoLists(one, two);
        ListNodeUtil.printListNode(listNode);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(-1);
        ListNode cur = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return listNode.next;
    }
}
