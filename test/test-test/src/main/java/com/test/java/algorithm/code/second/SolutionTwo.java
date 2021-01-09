package com.test.java.algorithm.code.second;

import com.test.java.algorithm.offer.ArrayUtil;
import com.test.java.algorithm.offer.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qiaogu on 2020/12/27.
 */
public class SolutionTwo {
    public static void main(String[] args) {
        SolutionTwo solutionTwo = new SolutionTwo();
//        int coin[] = {2, 5};
//        System.out.println(solutionTwo.coinChange(coin, 3));
        int array[] = {1, -1, 1, 1};
//        int[] ints = solutionTwo.maxSlidingWindow(array, 1);
//        ArrayUtil.printArray(ints);
        System.out.println(solutionTwo.singleNumberV1(array));
    }

    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSum(root, new ArrayList<Integer>(), sum);
        return resultList;
    }

    public void pathSum(TreeNode root, List<Integer> list, int sum) {
        if(root==null){
            return;
        }
        list.add(root.val);
        sum = sum-root.val;
        if(sum==0 && root.left==null && root.right==null){
            resultList.add(new ArrayList<>(list));
        }else{
            pathSum(root.left,list,sum);
            pathSum(root.right,list,sum);
        }
        list.remove(list.size()-1);
    }


    public int singleNumberV1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            int index = 1 << i;
            for (int j = 0; j < nums.length; j++) {
                if ((index & nums[j]) != 0) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                result = result | index;
            }
        }
        return result;
    }


    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            int index = 1 << i;
            for (int j : nums) {
                if ((index & j) != 0) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                result = result | index;
            }
        }
        return result;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.getFirst();
        for (int i = k, j = 1; i < nums.length; i++, j++) {
            if (!deque.isEmpty() && deque.getFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[j] = deque.getFirst();
        }
        return res;
    }

    public int[] maxSlidingWindowV1(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if (i > 0 && deque.peekFirst() == nums[i - 1]) {
                deque.removeFirst(); // 删除 deque 中对应的 nums[i-1]
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast(); // 保持 deque 递减
            }
            deque.addLast(nums[j]);
            if (i >= 0) {
                res[i] = deque.peekFirst();  // 记录窗口最大值
            }
        }
        return res;
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }
        int dp[] = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] < min) {
                    min = dp[i - coins[j]] + 1;
                }
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public int maxProfit(int array[]) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int min = array[0];
        int max = min;
        for (int i = 1; i < array.length; i++) {
            min = Math.min(min, array[i]);
            max = Math.max(max, array[i] - min);
        }
        return max;
    }

    /**
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp[] = new int[nums.length];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; i++) {
                if (dp[i] > dp[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public double power(double num, int n) {
        if (num == 0) {
            return 0;
        }
        double res = 1.0;
        if (n < 0) {
            num = 1 / num;
            n = -n;
        }
        while (n != 0) {
            if ((n & 1) != 0) {
                res = res * num;
            }

            n = n >> 1;
            num = num * num;
        }
        return res;
    }

    //岛屿最大面积
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1 || grid[i][j] == 0) {
            return 0;
        }
        int result = 1;
        grid[i][j] = 0;
        result = result + dfs(grid, i - 1, j);
        result = result + dfs(grid, i + 1, j);
        result = result + dfs(grid, i, j - 1);
        result = result + dfs(grid, i, j + 1);
        return result;
    }
}
