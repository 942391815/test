package com.test.java.refreence;

/**
 * Created by Micheal on 2019/7/11.
 */
public class YueSeFuHuan {
    static final int nums = 41;// 总共多少人
    static final int killMan = 3;// 数到3则被杀

    public static void main(String[] args) {
        jufehus(2);
    }

    public static void jufehus(int alive) {
        int[] man = new int[nums];// 未被杀的都被标记为0
        int pos = -1;// 数组角标
        int i = 0;
        int count = 1;// 杀到第几个记录值
        while (count <= nums) {
            do {
                pos = (pos + 1) % nums;// 循环标记
                if (man[pos] == 0)
                    i++;
                if (i == killMan) {
                    i = 0; // 重置
                    break;// 找到了被杀的位置，跳出循环，进行标记
                }
            } while (true);
            man[pos] = count;
            count++;
        }
        // 显示不被杀的位置
        alive = count - alive;
        for (int j = 0; j < man.length; j++) {
            System.out.println(man[j]);
            if (man[j] >= alive)
                System.out.println("不被杀的位置是->" + (j + 1));
        }
    }
}