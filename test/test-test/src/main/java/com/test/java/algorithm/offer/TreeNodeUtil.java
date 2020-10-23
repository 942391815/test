package com.test.java.algorithm.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Micheal on 2020/10/23.
 */
public class TreeNodeUtil {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtil.initTreeNode();
        printfByLevel(treeNode);
    }

    public static TreeNode initTreeNode() {
        // 4,2,7,1,3,6,9
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);

        four.left = two;
        four.right = seven;

        two.left = one;
        two.right = three;

        seven.left = six;
        seven.right = nine;
        return four;
    }

    /**
     * 二叉树的分层级打印
     *
     * @param root
     */
    public static void printfByLevel(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode peek = queue.poll();
            System.out.print("\t" + peek.val + "\t");
            if (peek.left != null) {
                queue.offer(peek.left);
            }
            if (peek.right != null) {
                queue.offer(peek.right);
            }
        }
    }
}
