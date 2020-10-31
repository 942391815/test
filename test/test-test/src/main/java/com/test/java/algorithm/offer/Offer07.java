package com.test.java.algorithm.offer;

/**
 * Created by Micheal on 2020/10/31.
 * 根据先序和中序重建二叉树
 */
public class Offer07 {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] mid = {4, 7, 2, 1, 5, 3, 8, 6};
        Offer07 offer07 = new Offer07();
        TreeNode tree = offer07.createTree(pre, mid);
        TreeNodeUtil.printfByLevel(tree);
    }

    public TreeNode createTree(int[] pre, int middle[]) {
        return createTree(pre, 0, pre.length - 1, middle, 0, middle.length - 1);
    }

    public TreeNode createTree(int[] pre, int startPre, int endPre, int[] middle, int startMid, int endMid) {
        if (startPre > endPre || startMid > endMid) {
            return null;
        }
        TreeNode node = new TreeNode(pre[startPre]);
        for (int i = startMid; i <= endMid; i++) {
            if (pre[startPre] == middle[i]) {
                node.left = createTree(pre, startPre + 1, startPre + i, middle, startMid, i - 1);
                node.right = createTree(pre, i - startMid + startPre + 1, endPre, middle, i + 1, endMid);
            }
        }
        return node;
    }
}
