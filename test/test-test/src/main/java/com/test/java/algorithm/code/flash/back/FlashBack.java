package com.test.java.algorithm.code.flash.back;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Micheal on 2020/11/22.
 */
public class FlashBack {
    public static void main(String[] args) {
        int num[] = {1, 2, 3};
        FlashBack flashBack = new FlashBack();
        List<List<Integer>> permute = flashBack.permute(num);
        System.out.println(permute);
    }

    //
    public int maxAreaOfIsland(int grid[][]) {
        int row = grid.length;
        int column = grid[0].length;
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }

    public int dfs(int grid[][], int i, int j) {
        if (i < 0 || j < 0 || i > grid.length || j > grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int num = 1;
        grid[i][j] = 0;
        num = num + dfs(grid, i - 1, j);
        num = num + dfs(grid, i + 1, j);
        num = num + dfs(grid, i, j + 1);
        num = num + dfs(grid, i, j - 1);
        return num;
    }


    //全排列
    public List<List<Integer>> permute(int nums[]) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backTrack(res, nums, new ArrayList<>(), visited);
        return res;
    }

    public void backTrack(List<List<Integer>> res, int[] nums, List<Integer> temp, int visited[]) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            temp.add(nums[i]);
            backTrack(res, nums, temp, visited);
            visited[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }
}
