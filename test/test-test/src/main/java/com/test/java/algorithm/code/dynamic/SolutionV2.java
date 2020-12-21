package com.test.java.algorithm.code.dynamic;

import com.test.java.algorithm.offer.TreeNode;
import com.test.java.algorithm.offer.TreeNodeUtil;
import sun.reflect.generics.tree.Tree;

/**
 * Created by qiaogu on 2020/12/18.
 */
public class SolutionV2 {
    TreeNode pre, head;

    public static void main(String[] args) {
        SolutionV2 solutionV1 = new SolutionV2();
//        TreeNode treeNode = TreeNodeUtil.initMiddelNode();
//        TreeNode treeNode1 = solutionV1.treeToDoublyList(treeNode);
        System.out.println(solutionV1.nthUglyNumber(5));
        System.out.println(solutionV1.nthUglyNumberV1(5));
//        System.out.println(treeNode1);
        int array[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        solutionV1.maxSubArray(array);
    }

    /**
     * 正则表达式匹配
     *
     * @param s 字符串
     * @param p 正则表达式
     * @return
     */
    public boolean isMatch(String s, String p) {
        if(p==null){
            return s==null;
        }
        if(p.charAt(1)=='*'){

        }else{

        }
        return false;
    }

    public boolean isComPair(String s, String p) {
        return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(dp[i], result);
        }
        return result;
    }

    public int nthUglyNumberV1(int num) {
        if (num == 1) {
            return 1;
        }
        int dp[] = new int[num];
        dp[0] = 1;
        int twoIndex = 0;
        int threeIndex = 0;
        int fiveIndex = 0;
        for (int i = 1; i < num; i++) {
            int n2 = dp[twoIndex] * 2;
            int n3 = dp[threeIndex] * 3;
            int n5 = dp[fiveIndex] * 5;
            dp[i] = Math.min(n2, Math.min(n3, n5));
            if (dp[i] == n2) {
                twoIndex++;
            }
            if (dp[i] == n3) {
                threeIndex++;
            }
            if (dp[i] == n5) {
                fiveIndex++;
            }
        }
        return dp[num - 1];
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

    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

    public int nthUglyNumber(int num) {
        int two = 0, three = 0, five = 0;
        int dp[] = new int[num];
        dp[0] = 1;
        for (int i = 1; i < num; i++) {
            int n2 = dp[two] * 2;
            int n3 = dp[three] * 3;
            int n5 = dp[five] * 5;
            dp[i] = Math.min(n2, Math.min(n3, n5));
            if (dp[i] == n2) two++;
            if (dp[i] == n3) three++;
            if (dp[i] == n5) five++;
        }
        return dp[num - 1];
    }

}
