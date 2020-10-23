package com.test.java.algorithm.offer;

/**
 * Created by Micheal on 2020/10/23.
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 例如输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 限制：
 * 0 <= 节点个数 <= 1000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 */
public class Offer27 {
    public static void main(String[] args) {
        Offer27 offer27 = new Offer27();

        TreeNode treeNode = TreeNodeUtil.initTreeNode();
        offer27.mirrorTree(treeNode);
        TreeNodeUtil.printfByLevel(treeNode);
    }

    public TreeNode mirrorTree(TreeNode root) {
        reverse(root);
        return root;
    }

    public void reverse(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node != null) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        reverse(node.left);
        reverse(node.right);
    }
}
