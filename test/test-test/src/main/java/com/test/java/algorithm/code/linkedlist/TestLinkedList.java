package com.test.java.algorithm.code.linkedlist;

import com.test.java.algorithm.offer.ListNode;
import com.test.java.algorithm.offer.ListNodeUtil;
import com.test.java.algorithm.offer.TreeNode;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Micheal on 2020/11/16.
 * 链表操作
 */
public class TestLinkedList {
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.initListNodeOne();
        ListNode listNodeTwo = ListNodeUtil.initListNodeTwo();
        TestLinkedList test = new TestLinkedList();
        //删除节点
//        ListNode listNode1 = test.deleteNode(listNode, 4);
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
//        test.reverseBetweenV1(listNode, 2, 4);
        //删除重复节点
//        ListNode repeatNode = ListNodeUtil.initRepeadNode();
//        test.deleteRepeatNode(repeatNode);
//        ListNodeUtil.printListNode(repeatNode);
        //判断是否是回文
//        System.out.println(test.symmetric(repeatNode));
//        test.getMiddle(listNode);
//        System.out.println(test.findNthDigitV1(11));
//        System.out.println(test.getCount(2));
//        System.out.println(test.translateNum(12258));


    }

    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        levelOrder(stack, 0, list);
        return resultList;
    }

    public void levelOrder(Stack<TreeNode> stack, int level, List<TreeNode> list) {
        if(stack==null || stack.isEmpty() || list==null || list.size()==0){
            return;
        }
        resultList.add(list.stream().map(e->e.val).collect(Collectors.toList()));
        Stack<TreeNode> newStack = new Stack<>();
        Stack<TreeNode> tempList = new Stack<>();
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (level % 2 == 0) {
                if(treeNode.left !=null){
                    newStack.add(treeNode.left);
                    tempList.add(treeNode.left);
                }
                if(treeNode.right !=null){
                    newStack.add(treeNode.right);
                    tempList.add(treeNode.right);
                }
            } else {
                if(treeNode.right !=null){
                    newStack.add(treeNode.right);
                    tempList.add(treeNode.right);
                }
                if(treeNode.left !=null){
                    newStack.add(treeNode.left);
                    tempList.add(treeNode.left);
                }
            }
        }
        level++;
        levelOrder(newStack, level,tempList);
    }

    public int translateNum(int num) {
        String s = String.valueOf(num);
        int dp[] = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = dp[i - 1];
            int temp = 10 * (s.charAt(i - 1) - '0') + s.charAt(i) - '0';
            if (temp >= 10 && temp <= 25) {
                if (i < 2) {
                    dp[i]++;
                } else {
                    dp[i] = dp[i] + dp[i - 2];
                }
            }
        }
        return dp[s.length() - 1];
    }

    public int findNthDigitV1(int nums) {
        if (nums < 10) {
            return nums;
        }
        int base = 1;
        while (true) {
            int count = getCount(base);
            if (count > nums) {
                break;
            }
            nums = nums - count;
            base++;
        }
        int result = nums / base + (int) Math.pow(10, base - 1);
        return String.valueOf(result).charAt(nums % base) - '0';
    }

    public int getCount(int base) {
        if (base == 1) {
            return 10;
        }
        return (int) Math.pow(10, base - 1) * 9 * base;
    }


    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int base = 1;
        long count = 0;  //计算有多少位,测试的时候发现有个1e9的用例，这个用例会导致count越界
        while (true) {
            count = helper(base);
            if (n < count) break;
            n -= count;
            base++;
        }
        //得到新的n和count了，算出第n位对应什么数字
        int num = (int) (n / base + Math.pow(10, base - 1));
        return String.valueOf(num).charAt(n % base) - '0';
    }

    // 计算当前有多少位 1位数10种，10位；2位数 90个数字 180位；3位数 900个 2700位
    private long helper(int base) {
        if (base == 1) {
            return 10;
        }
        return (long) (Math.pow(10, base - 1) * 9 * base);
    }

    public ListNode reverseBetweenV1(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode p = temp;
        ListNode q = temp.next;
        for (int i = 0; i < m - 1; i++) {
            if (q != null) {
                p = p.next;
                q = q.next;
            }
        }
        for (int i = 0; i < (n - m); i++) {
            ListNode remove = q.next;
            q.next = q.next.next;
            remove.next = p.next;
            p.next = remove;
        }
        return temp.next;
    }

    //单链表部分反转
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode g = temp;
        ListNode p = temp.next;
        int step = 0;
        while (step < m - 1) {
            g = g.next;
            p = p.next;
            step++;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode remove = p.next;
            p.next = p.next.next;

            remove.next = g.next;
            g.next = remove;
        }
        return temp.next;
    }

    //链表是否回文（对称）
    public boolean symmetric(ListNode node) {
        if (node == null || node.next == null) {
            return true;
        }
        ListNode temp = node;
        List<Integer> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int i = 0;
        while (node != null) {
            if (node.val == list.get(list.size() - i - 1)) {
                node = node.next;
                i++;
            } else {
                return false;
            }
        }
        return true;
    }

    //删除链表中重复出现的节点
    public void deleteRepeatNode(ListNode node) {
        if (node == null) {
            return;
        }
        Set<Integer> set = new HashSet<>();
        ListNode pre = node;
        ListNode cur = pre.next;
        set.add(node.val);
        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                set.add(cur.val);
                pre = pre.next;
                cur = cur.next;
            }
        }

    }

    public ListNode sortListNode(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode middle = getMiddle(node);
        ListNode rightHead = middle.next;
        middle.next = null;
        ListNode left = sortListNode(node);
        ListNode right = sortListNode(rightHead);
        return joinNode(left, right);
    }


    public ListNode getMiddle(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode slow = node;
        ListNode fast = node.next;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public ListNode lastK(ListNode node, int k) {
        if (k <= 0) {
            return null;
        }
        ListNode first = node;
        ListNode result = node;
        for (int i = 0; i < k; i++) {
            if (first != null) {
                first = first.next;
            } else {
                return null;
            }
        }
        while (first != null) {
            first = first.next;
            result = result.next;
        }
        return result;
    }

    //合并两个有序链表
    public ListNode joinNode(ListNode one, ListNode two) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (one != null && two != null) {
            if (one.val < two.val) {
                temp.next = one;
                temp = one;
                one = one.next;
            } else {
                temp.next = two;
                temp = two;
                two = two.next;
            }
        }
        temp.next = one == null ? two : one;
        return head.next;
    }

    //链表是否交叉
    public boolean isOverlapping(ListNode one, ListNode two) {
        if (one == null || two == null) {
            return false;
        }
        ListNode oneTemp = one;
        int oneLen = 0;
        while (oneTemp != null) {
            oneLen++;
            oneTemp = oneTemp.next;
        }
        ListNode twoTemp = two;
        int twoLen = 0;
        while (twoTemp != null) {
            twoLen++;
            twoTemp = twoTemp.next;
        }
        int step = Math.abs((oneLen - twoLen));
        if (oneLen > twoLen) {
            for (int i = 0; i < step; i++) {
                one = one.next;
            }
        } else if (oneLen < twoLen) {
            for (int i = 0; i < step; i++) {
                two = two.next;
            }
        }
        while (one != null && two != null) {
            if (Objects.equals(one.getVal(), two.getVal())) {
                return true;
            } else {
                one = one.next;
                two = two.next;
            }
        }
        return false;
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
