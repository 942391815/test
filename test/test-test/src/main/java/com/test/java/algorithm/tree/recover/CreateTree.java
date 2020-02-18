package com.test.java.algorithm.tree.recover;

/**
 * Created by Micheal on 2020/2/17.
 */
public class CreateTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = createTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }


    private TreeNode createTree(int[] pre, int startPre, int endPre, int[] middle, int startMiddle, int endMiddle) {
        if (startPre > endPre || startMiddle > endMiddle) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);//树的根
        for (int i = startMiddle; i <= endMiddle; i++) {
            if (pre[startPre] == middle[i]) {
                root.left = createTree(pre, startPre + 1, startPre + i, middle, startMiddle, i - 1);//去除掉已经确定的根节点
                root.right = createTree(pre, i - startMiddle + startPre + 1, endPre, middle, i + 1, endMiddle);
            }
        }
        return root;
    }
}