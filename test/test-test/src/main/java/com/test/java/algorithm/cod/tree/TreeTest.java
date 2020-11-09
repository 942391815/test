package com.test.java.algorithm.cod.tree;

import com.test.java.algorithm.offer.TreeNode;
import com.test.java.algorithm.offer.TreeNodeUtil;

import java.util.*;

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
        //treeTest.after(treeNode);
//        treeTest.levelPrint(treeNode);
        //二叉树显示行号遍历
//        List<List<TreeNode>> lists = treeTest.levelPrintWithLevel(treeNode);
//        System.out.println(JSONUtils.toJSONString(lists));
        //二叉树蛇形遍历
        treeTest.snakePrint(treeNode);
    }

    public void snakePrint(TreeNode root) {
        if (root == null) {
            return;
        }
        int level = 0;
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        snakePrint(level, stack);
    }

    public void snakePrint(int level, Stack<TreeNode> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Stack<TreeNode> newStack = new Stack<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " \t");
            if (node != null) {
                if (level % 2 == 0) {
                    if (node.left != null) {
                        newStack.push(node.left);
                    }
                    if (node.right != null) {
                        newStack.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        newStack.push(node.right);
                    }
                    if (node.left != null) {
                        newStack.push(node.left);
                    }

                }
            }
        }
        System.out.println("");
        level++;
        snakePrint(level, newStack);
    }

    public List<List<Integer>> levelOrderV1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (list.size() > 0) {
            List<Integer> cur = new ArrayList<>();
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode each : list) {
                cur.add(each.val);
                if (each.left != null) {
                    next.add(each.left);
                }
                if (each.right != null) {
                    next.add(each.right);
                }
            }
            list = next;
            result.add(cur);
        }
        return result;
    }

    public List<List<TreeNode>> levelPrintWithLevel(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<TreeNode>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> treeNodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                if (treeNode != null) {
                    if (treeNode.left != null) {
                        treeNodes.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        treeNodes.add(treeNode.right);
                    }
                }
            }
            if (treeNodes.size() > 0) {
                list.add(treeNodes);
                queue = new LinkedList<>(treeNodes);
            }
        }
        return list;
    }

    public void levelPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode != null) {
                System.out.print(treeNode.val + "\t");
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
    }

    /**
     * 二叉树后序遍历
     *
     * @param root
     */
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
