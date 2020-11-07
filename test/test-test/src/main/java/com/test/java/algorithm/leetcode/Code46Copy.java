package com.test.java.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Micheal on 2020/11/7.
 */
public class Code46Copy {
    public static void main(String[] args) {
        Code46Copy code46Copy = new Code46Copy();
        int array[] = {1, 2, 3};
        System.out.println(code46Copy.permute(array));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;
    }

    public void backtrack(List<List<Integer>> res, int[] nums, List<Integer> temp, int visited[]) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            temp.add(nums[i]);
            backtrack(res, nums, temp, visited);
            visited[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }
}
