package com.test.java.algorithm.matrix;

import com.test.java.algorithm.offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        int matrix[][] = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
        Test test = new Test();
//        TreeNode treeNode = initTree();
//        test.pathSum(treeNode, 22);
        //        test.rotate(matrix);
        System.out.println(test.waysToChange(10));
//        System.out.println(test.waysToChangeV1(10));

    }

    public static int[] makeNo(int size) {
        if (size == 1) {
            return new int[]{1};
        }
        int halfSize = (size + 1) / 2;
        //加工出种子
        int base[] = makeNo(halfSize);
        int ans[] = new int[size];
        int index = 0;
        for (; index < halfSize; index++) {
            ans[index] = base[index] * 2 + 1;
        }

        for (int i = 0; i < size; i++, index++) {
            ans[index] = base[i] * 2 + 2;
        }
        return ans;

    }

    public TreeNode getNode(int array[]) {
        if (array == null || array.length == 0) {
            return null;
        }
        return getNode(array, 0, array.length - 1);
    }

    public TreeNode getNode(int array[], int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(array[end]);
        if (start == end) {
            return root;
        }
        int index = start - 1;
        for (int i = end - 1; i >= start; i--) {
            if (array[start] < array[end]) {
                index = i;
                break;
            }
        }
        root.left = getNode(array, start, index - 1);
        root.right = getNode(array, index + 1, end - 1);
        return root;
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length <= 0) {
            return null;
        }
        return createMinimalTree(nums, 0, nums.length - 1);
    }

    private TreeNode createMinimalTree(int[] nums, int left, int right) {
        // 处理数组越界异常和外结点
        if (left < 0 || right >= nums.length || left > right) {
            return null;
        }
        // 插入中间值作为父结点，插入左右子树
        int mid = (left + right) / 2;
        TreeNode n = new TreeNode(nums[mid]);
        n.left = createMinimalTree(nums, left, mid - 1);
        n.right = createMinimalTree(nums, mid + 1, right);
        return n;
    }

    public int waysToChangeV1(int n) {
        if (n <= 0) {
            return 0;
        }
        int coins[] = {1, 5, 10, 25};
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }

    public int waysToChange(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }

        return dp[n];
    }

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int dp[][] = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        //dp[i][0]表示第天不持股的最大收益，dp[i][1]表示第i天持股的最大收益
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[len - 1][0];
    }

    List<List<Integer>> resultList = new ArrayList();

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        pathSum(root, sum, new ArrayList<>());
        return resultList.size();
    }

    public void pathSum(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        sum = sum - root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            resultList.add(new ArrayList<>(list));
        } else {
            pathSum(root.left, sum, list);
            pathSum(root.right, sum, list);
        }
        list.remove(list.size() - 1);
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        //矩阵先水平翻转，再对角线翻转
        for (int i = 0; i <= row / 2 - 1; i++) {
            for (int j = 0; j < column; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row - i - 1][j];
                matrix[row - i - 1][j] = temp;
            }
        }
        //对角线旋转
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println(matrix);
    }

    //右边对角线翻转
    public void revert(int array[][]) {
        int row = array.length;
        int column = array[0].length;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int temp = array[i][j];
                array[i][j] = array[row - j - 1][column - i - 1];
                array[row - j - 1][column - i - 1] = temp;
            }
        }
        System.out.println(array);
    }

    static TreeNode initTree() {
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode eight = new TreeNode(8);
        TreeNode eleven = new TreeNode(11);
        TreeNode third = new TreeNode(13);
        TreeNode fourSec = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode second = new TreeNode(2);
        TreeNode fiveSec = new TreeNode(5);
        TreeNode one = new TreeNode(1);

        five.left = four;
        five.right = eight;
        four.left = eleven;
        eight.left = third;
        eight.right = fourSec;
        eleven.left = seven;
        eleven.right = second;
        fourSec.left = fiveSec;
        fourSec.right = one;
        return five;
    }
}
