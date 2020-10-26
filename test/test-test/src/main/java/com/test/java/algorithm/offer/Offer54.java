package com.test.java.algorithm.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Micheal on 2020/10/26.
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 */
public class Offer54 {
    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);

        three.left = one;
        three.right = four;
        one.right = two;

        Offer54 offer54 = new Offer54();
        int result = offer54.kthLargest(three, 1);
        System.out.println(result);
    }

    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = middlePrint(root);
        return list.get(list.size() - k);
    }

    public List middlePrint(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
}
