package com.test.java.algorithm.code.tree;

import com.alibaba.druid.support.json.JSONUtils;
import com.test.java.algorithm.offer.TreeNode;
import com.test.java.algorithm.offer.TreeNodeUtil;

import java.util.*;

/**
 * Created by Micheal on 2020/11/9.
 */
public class TreeTestV2 {
    public static void main(String[] args) {
        TreeTestV2 treeTest = new TreeTestV2();
        TreeNode treeNode = TreeNodeUtil.initTreeNode();
        TreeNode second = TreeNodeUtil.initTreeNodeSecond();
        //二叉树递归先序遍历
//        treeTest.recursionPre(treeNode);
        //二叉树递归中序遍历
        //treeTest.recursionMiddle(treeNode);
        //treeTest.recursionAfter(treeNode);
        //二叉树先序遍历
//        treeTest.pre(treeNode);
        //二叉树中序遍历
//        treeTest.middle(treeNode);
        //二叉树后序遍历
//        treeTest.after(treeNode);
//        treeTest.levelPrint(treeNode);
        //二叉树显示行号遍历
//        List<List<TreeNode>> lists = treeTest.levelPrintWithLevel(treeNode);
//        System.out.println(JSONUtils.toJSONString(lists));
        //二叉树蛇形遍历
//        treeTest.snakePrint(treeNode);
        //二叉树最大高度
//        System.out.println(treeTest.maxLevel(treeNode));
        //二叉树最小高度
//        int level = treeTest.minLevel(treeNode);
//        System.out.println(level);
        //二叉树最小高度递归
//        System.out.println(treeTest.recursionMinLevel(treeNode));
        //是否为对称二叉树
//        System.out.println(treeTest.isSymmetricTree(treeNode));
        //是否为二叉树的一部分
//        System.out.println(treeTest.isPartOfTree(treeNode, second));
        //二叉树的某一路径和
//        List<List<Integer>> lists = treeTest.pathSum(treeNode, 11);
//        System.out.println(JSONUtils.toJSONString(lists));
        //二叉树镜像
//        treeTest.mirroTree(treeNode);
        //todo 二叉树节点间最大的距离
        //二叉树的公共祖先
        TreeNode treeNode1 = treeTest.lowestCommonAncestor(treeNode, new TreeNode(2), new TreeNode(4));
        System.out.println(treeNode1.val);
        //二叉树的最大距离
//        System.out.println(treeTest.maxDistance(treeNode));
        //判断是否是平衡二叉树
//        System.out.println(treeTest.isBalanceTree(treeNode));
    }

    private TreeNode lowestCommonAncestor(TreeNode treeNode, TreeNode one, TreeNode two) {
        if (treeNode == null || treeNode.val == one.val || treeNode.val == two.val) {
            return treeNode;
        }
        TreeNode left = lowestCommonAncestor(treeNode.left, one, two);
        TreeNode right = lowestCommonAncestor(treeNode.right, one, two);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return treeNode;
    }

    List<List<Integer>> resultList = new ArrayList<>();

    private List<List<Integer>> pathSum(TreeNode treeNode, int k) {
        if (treeNode == null) {
            return resultList;
        }
        pathSum(treeNode, new ArrayList<>(), k);
        return resultList;
    }

    private void pathSum(TreeNode treeNode, List<Integer> list, int sum) {
        if (treeNode == null) {
            return;
        }
        list.add(treeNode.val);
        sum = sum - treeNode.val;
        if (treeNode.left == null && treeNode.right == null && sum == 0) {
            resultList.add(new ArrayList<>(list));
        } else {
            pathSum(treeNode.left, list, sum);
            pathSum(treeNode.right, list, sum);
            list.remove(list.size() - 1);
        }
    }

    private void after(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> one = new Stack<>();
        Stack<TreeNode> two = new Stack<>();
        one.add(treeNode);
        while (!one.isEmpty()) {
            TreeNode pop = one.pop();
            two.add(pop);
            if (pop.left != null) {
                one.add(pop.left);
            }
            if (pop.right != null) {
                one.add(pop.right);
            }
        }
        while (!two.isEmpty()) {
            System.out.print(two.pop().val + "\t");
        }
    }

    private void middle(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || treeNode != null) {
            while (treeNode != null) {
                stack.add(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                System.out.print(pop.val + " \t");
                treeNode = pop.right;
            }
        }
    }

    private void pre(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || treeNode != null) {
            while (treeNode != null) {
                stack.add(treeNode);
                System.out.print(treeNode.val + " \t");
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                treeNode = pop.right;
            }
        }
    }
}
