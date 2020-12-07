package com.test.java.algorithm.code.tree;

import com.google.common.collect.Lists;
import com.test.java.algorithm.offer.TreeNode;
import com.test.java.algorithm.offer.TreeNodeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Micheal on 2020/12/7.
 */
public class TreeTestV1 {
    List<List<Integer>> list = Lists.newArrayList();

    public static void main(String[] args) {
        TreeTestV1 treeTest = new TreeTestV1();
        TreeNode treeNode = TreeNodeUtil.initTreeNode();
        TreeNode second = TreeNodeUtil.initTreeNodeSecond();
//        treeTest.pre(treeNode);
//        System.out.println();
//        treeTest.preRecrive(treeNode);
        //中序遍历
//        treeTest.middleRecrive(treeNode);
//        System.out.println();
//        treeTest.middle(treeNode);
//        treeTest.last(treeNode);
//        System.out.println("");
//        treeTest.recriveLast(treeNode);
//        treeTest.levelPrint(treeNode);
//        System.out.println(treeTest.maxHeight(treeNode));
//        treeTest.sum(treeNode, 14);
//        System.out.println(treeTest.isPart(treeNode, second));
//        TreeNode result = treeTest.lowTreeNode(treeNode, new TreeNode(5), new TreeNode(2));
//        System.out.println(result.val);
        int preOrder[] = {3, 9, 20, 15, 7};
        int rightOrder[] = {9, 3, 15, 20, 7};
        TreeNode treeNode1 = treeTest.buildTree(preOrder, rightOrder);
        treeTest.levelPrint(treeNode1);
    }

    public TreeNode buildTree(int preOrder[], int middleOrder[]) {
        int length = preOrder.length;
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return new TreeNode(preOrder[0]);
        }
        TreeNode root = new TreeNode(preOrder[0]);
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (middleOrder[i] == preOrder[0]) {
                index = i;
            }
        }
        //左子树前序遍历
        int[] leftProOrder = Arrays.copyOfRange(preOrder, 1, index + 1);
        int[] leftInOrder = Arrays.copyOfRange(middleOrder, 0, index);
        root.left = buildTree(leftProOrder, leftInOrder);

        int[] rightPreOrder = Arrays.copyOfRange(preOrder, index + 1, length);
        int[] rightInOrder = Arrays.copyOfRange(middleOrder, index + 1, length);
        root.right = buildTree(rightPreOrder, rightInOrder);
        return root;
    }


    public TreeNode lowTreeNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowTreeNode(root.left, p, q);
        TreeNode right = lowTreeNode(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (!isBalance(root.left)) {
            return false;
        }
        if (!isBalance(root.right)) {
            return false;
        }
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        int abs = Math.abs(leftH - rightH);
        if (abs > 1) {
            return false;
        }
        return true;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public boolean isPart(TreeNode one, TreeNode two) {
        if (one == null) {
            return two == null;
        }
        if (one.val == two.val) {
            return partEqual(one, two);
        } else {
            boolean result = isPart(one, two.left);
            if (!result) {
                result = isPart(one, two.right);
                return result;
            }
        }
        return false;
    }

    public boolean partEqual(TreeNode one, TreeNode two) {
        if (one == null) {
            return false;
        }
        if (two == null) {
            return true;
        }
        if (one.val == two.val) {
            return partEqual(one.left, two.left) && partEqual(one.right, two.right);
        }
        return false;
    }

    public void sum(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        List<Integer> tempList = new ArrayList<>();
        sum(root, tempList, sum);
        System.out.println(list);

    }

    public void sum(TreeNode root, List<Integer> tempList, int sum) {
        if (root == null) {
            return;
        }
        sum = sum - root.val;
        tempList.add(root.val);
        if (sum == 0 && root.left == null && root.right == null) {
            list.add(new ArrayList(tempList));
        } else {
            sum(root.left, tempList, sum);
            sum(root.right, tempList, sum);
        }
        tempList.remove(tempList.size() - 1);
    }

    public int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }

    public void levelPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        levelPrint(stack, 0);
    }

    public void levelPrint(Stack<TreeNode> stack, int level) {
        if (stack.isEmpty()) {
            return;
        }
        Stack<TreeNode> temp = new Stack<>();
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.val + " \t");
            if (level % 2 == 0) {
                if (pop.left != null) {
                    temp.push(pop.left);
                }
                if (pop.right != null) {
                    temp.push(pop.right);
                }
            } else {
                if (pop.right != null) {
                    temp.push(pop.right);
                }
                if (pop.left != null) {
                    temp.push(pop.left);
                }
            }
        }
        level++;
        levelPrint(temp, level);
    }

    public void last(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> one = new Stack<>();
        Stack<TreeNode> two = new Stack<>();
        one.push(root);
        while (!one.isEmpty()) {
            TreeNode pop = one.pop();
            two.push(pop);
            if (pop.left != null) {
                one.push(pop.left);
            }
            if (pop.right != null) {
                one.push(pop.right);
            }
        }
        while (!two.isEmpty()) {
            System.out.print(two.pop().val + "\t");
        }
    }

    public void recriveLast(TreeNode root) {
        if (root == null) {
            return;
        }
        recriveLast(root.left);
        recriveLast(root.right);
        System.out.print(root.val + " \t");
    }

    public void middle(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
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

    //中序遍历
    public void middleRecrive(TreeNode root) {
        if (root == null) {
            return;
        }
        middleRecrive(root.left);
        System.out.print(root.val + " \t");
        middleRecrive(root.right);
    }

    //先序非递归遍历
    public void pre(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                System.out.print(root.val + " \t");
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    //先序递归遍历
    public void preRecrive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " \t");
        preRecrive(root.left);
        preRecrive(root.right);
    }
}
