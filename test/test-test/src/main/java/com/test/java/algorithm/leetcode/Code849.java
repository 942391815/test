package com.test.java.algorithm.leetcode;

/**
 * Created by Micheal on 2020/11/7.
 * 示例 1：
 * <p>
 * 输入：[1,0,0,0,1,0,1]
 * 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * 示例 2：
 * <p>
 * 输入：[1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 * 链接：https://leetcode-cn.com/problems/maximize-distance-to-closest-person
 */
public class Code849 {

    public static void main(String[] args) {
        int num[] = {1, 0, 0, 0, 1, 0, 1};
//        int num[] = {0, 1};
        Code849 code849 = new Code849();
        int len = code849.maxDistToClosestV1(num);
        System.out.println(len);
    }


    public int maxDistToClosestV1(int[] seats) {
        int N = seats.length;
        int prev = -1, future = 0;
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) {
                prev = i;
            } else {
                while (future < N && seats[future] == 0 || future < i)
                    future++;

                int left = prev == -1 ? N : i - prev;
                int right = future == N ? N : future - i;
                ans = Math.max(ans, Math.min(left, right));
            }
        }

        return ans;
    }

    public int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length == 0) {
            return 0;
        }
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                if (start == 0) {
                    start = i;
                } else {
                    end = i;
                }
            } else {
                int len = end - start;
                if (len > 0) {
                    max = Math.max(max, len / 2 + 1);
                    start = 0;
                    end = 0;
                }
            }
        }
        if (start != 0 && end != 0) {
            max = Math.max(max, (end - start) + 1);
        }
        return max;
    }
}