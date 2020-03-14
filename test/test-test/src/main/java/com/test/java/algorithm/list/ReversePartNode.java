package com.test.java.algorithm.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by micheal on 2020/1/7.
 * 反转部分单链表
 */
public class ReversePartNode {
    public static void main(String[] args) {
//        Node one = new Node(1);
//        Node two = new Node(2);
//        Node three = new Node(3);
//        Node four = new Node(4);
//        Node five = new Node(5);
//
//        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;
//        //1->2->3->4->5
//        //1->4->3->2->5
//        reverseNode(one, 2, 4);
//        printNode(one);
//        int array[] = {9,9};
////        removeElement(array,3);
////        maxProduct(array);
//        int[] ints = plusOneV1(array);
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println(ints[i]);
//        }
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int[] nums2 = {2, 5, 6};
//        int n = 3;
//        merge(nums1, m, nums2, n);
//        System.out.println(nums1);
        int num[] = {12,22,1,9,20};
        System.out.println(largestNumber(num));
    }

    public static String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        List<String> collect = Arrays.stream(nums)
                .boxed()
                .map(Object::toString)
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(Collectors.toList());
        for (String s :collect) {
            sb.append(s);
        }

        String result = sb.toString();

        return result.startsWith("0") ? "0" : result;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        int i = 0;
        while (i < nums2.length) {
            if (nums2[i] > nums1[index] && index < m) {
                index++;
            } else {
                //移动nums1里面的数据  index后面的数据往后移动
                for (int j = m - 1; j >= index; j--) {
                    nums1[j + 1] = nums1[j];
                }
                nums1[index] = nums2[i];
                i++;
                m++;
            }
        }
    }

    /***
     * 循环方法
     * @param head
     * @return
     */
    public static Node reverseNode(Node head, int m, int n) {
        if (head == null) {
            return null;
        }
        Node preHead = new Node(-1);
        preHead.next = head;

        Node preStart = preHead;
        Node start = head;
        for (int i = 1; i < m; i++) {
            preStart = start;
            start = start.next;
        }
        //find M
        for (int i = 0; i < n - m; i++) {
            Node temp = start.next;
            start.next = temp.next;
            temp.next = preStart.next;
            preStart.next = temp;
        }
        return preHead.next;
    }

    public static void printNode(Node node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static int maxProduct(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] * nums[i], dp[i - 1]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static int removeElement(int[] nums, int val) {
        int count = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                if (i + 1 < nums.length) {
                    nums[i] = nums[i + 1];
                    count--;
                }
            }
        }
        return count;
    }

    //99
    //45
    public static int[] plusOneV1(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
                if (i == 0) {
                    int result[] = new int[digits.length + 1];
                    result[0] = 1;
                    copy(digits, result);
                    return result;
                }
//                else {
//                    digits[i - 1] = 0;
//                }
            }
            i--;
        }
        return null;
    }

    public static void copy(int source[], int[] target) {
        for (int i = 0; i < source.length; i++) {
            target[i + 1] = source[i];
        }
    }


    public static int[] plusOne(int[] digits) {
        digits = plus(digits, digits.length - 1);
        return digits;
    }

    public static int[] plus(int[] digits, int i) {
        if (digits[i] != 9) {
            digits[i]++;
            return digits;
        } else {
            digits[i] = 0;
            if (i == 0) {
                int[] newd = new int[digits.length + 1];
                newd[0] = 1;
                for (int j = 1; j < newd.length; j++) {
                    newd[j] = digits[j - 1];
                }
                return newd;
            }
            return plus(digits, i - 1);
        }
    }
}
