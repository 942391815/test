package com.test.java.algorithm.cod.tree;

import com.test.java.algorithm.offer.TreeNode;
import com.test.java.algorithm.offer.TreeNodeUtil;

import java.util.Stack;

/**
 * Created by Micheal on 2020/11/9.
 */
public class TreeTest {
    public static void main(String[] args) {
        TreeTest treeTest = new TreeTest();
        TreeNode treeNode = TreeNodeUtil.initTreeNode();
        //二叉树递归先序遍历
        //treeTest.recursionPre(treeNode);
        //二叉树递归中序遍历
        //treeTest.recursionMiddle(treeNode);
        //treeTest.recursionAfter(treeNode);
        //二叉树先序遍历
        //treeTest.pre(treeNode);
        //二叉树中序遍历
        //treeTest.middle(treeNode);
        //二叉树后序遍历
//        treeTest.after(treeNode);

    }

    public void after(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> one = new Stack<>();
        Stack<TreeNode> two = new Stack<>();
        one.push(root);
        while (!one.isEmpty()) {
            root = one.pop();
            two.push(root);
            if (root.left != null) {
                one.push(root.left);
            }
            if (root.right != null) {
                one.push(root.right);
            }
        }
        while (!two.isEmpty()) {
            TreeNode pop = two.pop();
            System.out.print(pop.val + " \t");
        }
    }

    public void middle(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.val + " \t");
                root = root.right;
            }
        }
    }

    //二叉树先序遍历
    public void pre(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.print(root.val + "\t");
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public void recursionAfter(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        recursionAfter(treeNode.left);
        recursionAfter(treeNode.right);
        System.out.print(treeNode.val + "\t");
    }

    /**
     * 二叉树中序遍历
     *
     * @param treeNode
     */
    public void recursionMiddle(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        recursionMiddle(treeNode.left);
        System.out.print(treeNode.val + "\t");
        recursionMiddle(treeNode.right);
    }

    /**
     * 先序递归遍历
     *
     * @param treeNode
     */
    public void recursionPre(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val + " \t");
        recursionPre(treeNode.left);
        recursionPre(treeNode.right);
    }
}
