package com.test.java.algorithm.code.dynamic;

/**
 * Created by qiaogu on 2020/12/17.
 */
public class Solution {
    public static void main(String[] args) {
        int nums[] = {7, 5, 6, 4};
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(nums));
    }

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        return digui(nums, 0, len - 1);
    }

    public int digui(int[] nums, int left, int right) {
        if (left >= right)
            return 0;
        int mid = (right + left) >> 1;
        int l = digui(nums, left, mid);//记录左边的结果
        int r = digui(nums, mid + 1, right);//记录右边的结果
        return (l + r + mergesort(nums, left, mid, right));//左+右+当前

    }

    public int mergesort(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];//left和right都可以取到，所以需要加1
        int ans = 0;
        int cur1 = mid;
        int cur2 = right;
        int cur3 = right - left;
        while (cur1 >= left && cur2 >= mid + 1) {
            if (nums[cur1] <= nums[cur2]) {
                temp[cur3--] = nums[cur2--];
            } else {
                temp[cur3--] = nums[cur1--];
                ans += (cur2 - mid);//比当前cur2里面的元素都大
            }
        }
        while (cur1 >= left) {
            temp[cur3--] = nums[cur1--];
        }
        while (cur2 >= mid + 1) {
            temp[cur3--] = nums[cur2--];
        }
        int x = 0;
        while (left <= right) {
            nums[left++] = temp[x++];
        }
        return ans;
    }
}