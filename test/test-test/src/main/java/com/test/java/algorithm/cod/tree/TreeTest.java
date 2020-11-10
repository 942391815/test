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
        TreeNode second = TreeNodeUtil.initTreeNodeSecond();
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
    }

    public boolean isPartOfTree(TreeNode treeNode, TreeNode part) {
        boolean result = false;
        if (treeNode != null && part != null) {
            if (treeNode.val == part.val) {
                result = isPart(treeNode, part);
            } else {
                if (!result) {
                    result = isPartOfTree(treeNode.left, part);
                }
                if (!result) {
                    result = isPartOfTree(treeNode.right, part);
                }
            }
        }
        return result;
    }

    public boolean isPart(TreeNode treeNode, TreeNode part) {
        if (part == null) {
            return true;
        }
        if (treeNode == null) {
            return false;
        }
        if (Objects.equals(treeNode.val, part.val)) {
            return isPart(treeNode.left, part.left) && isPart(treeNode.right, part.right);
        }
        return false;
    }


    /**
     * 是否为对称二叉树
     *
     * @param root
     * @return
     */
    public boolean isSymmetricTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricTree(root.left, root.right);
    }

    public boolean isSymmetricTree(TreeNode one, TreeNode two) {
        if (one == null || two == null) {
            return false;
        }
        if (Objects.equals(one.val, two.val)) {
            return isSymmetricTree(one.left, two.right) && isSymmetricTree(one.right, two.left);
        } else {
            return false;
        }
    }

    public int recursionMinLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.min(recursionMinLevel(root.left), recursionMinLevel(root.right)) + 1;
    }

    public int minLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            level++;
            Queue<TreeNode> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left == null || treeNode.right == null) {
                    return level;
                }
                next.add(treeNode.left);
                next.add(treeNode.right);
            }
            queue = next;
        }
        return level;
    }

    public int maxLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxLevel(root.left), maxLevel(root.right)) + 1;
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
