package com.test.java.algorithm.code.dynamic;

import com.test.java.algorithm.offer.TreeNode;

import java.util.List;
import java.util.Stack;

/**
 * Created by qiaogu on 2020/12/18.
 */
public class SolutionV1 {
    TreeNode pre, head;

    public static void main(String[] args) {
        SolutionV1 solutionV1 = new SolutionV1();
//        TreeNode treeNode = TreeNodeUtil.initMiddelNode();
//        TreeNode treeNode1 = solutionV1.treeToDoublyList(treeNode);
//        System.out.println(treeNode1);
        System.out.println(solutionV1.fib(5));
    }

    public int numWays(int n) {
        /**
         * 1           1
         * 2            2
         * 3            3
         * 4           5
         */
        if (n == 1) return 1;
        if (n == 2) return 2;
        int lastOne = 1;
        int lastTwo = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = (lastOne + lastTwo) % 1000000007;
            lastOne = lastTwo;
            lastTwo = result;
        }
        return result;
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }


    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int lastOne = 0;
        int lastTwo = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = lastOne + lastTwo;
            lastOne = lastTwo;
            lastTwo = result;
        }
        return result;
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
