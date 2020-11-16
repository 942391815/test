package com.test.java.algorithm.code.tree;

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
        //二叉树的某一路径和
//        List<List<Integer>> lists = treeTest.pathSum(treeNode, 11);
//        System.out.println(JSONUtils.toJSONString(lists));
        //二叉树镜像
//        treeTest.mirroTree(treeNode);
        //todo 二叉树节点间最大的距离
        //二叉树的公共祖先
//        TreeNode treeNode1 = treeTest.lowestCommonAncestor(treeNode, new TreeNode(2), new TreeNode(4));
//        System.out.println(treeNode1.val);
        //二叉树的最大距离
//        System.out.println(treeTest.maxDistance(treeNode));
        //判断是否是平衡二叉树
        System.out.println(treeTest.isBalanceTree(treeNode));
    }

    public boolean isBalanceTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isBalanceTree(root.left)) {
            return false;
        }
        if (!isBalanceTree(root.right)) {
            return false;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return true;
    }

    public int getHeight(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int left = getHeight(head.left) + 1;
        int right = getHeight(head.right) + 1;
        return left > right ? left : right;
    }

    public int maxDistance(TreeNode head) {
        int[] record = new int[1];
        return posOrder(head, record);
    }

    private int posOrder(TreeNode head, int[] record) {
        if (head == null) {
            record[0] = 0;
            return 0;
        }
        int lMax = posOrder(head.left, record);
        int maxFromLeft = record[0];
        int rMax = posOrder(head.right, record);
        int maxFromRight = record[0];
        int curNodeMax = maxFromLeft + maxFromRight;
        record[0] = Math.max(maxFromLeft, maxFromRight) + 1;
        return Math.max(Math.max(lMax, rMax), curNodeMax);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == q.val || root.val == p.val) {
            return root;
        }
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null; // 如果树为空，直接返回null
        if (root == p || root == q) return root; // 如果 p和q中有等于 root的，那么它们的最近公共祖先即为root（一个节点也可以是它自己的祖先）
        TreeNode left = lowestCommonAncestorV1(root.left, p, q); // 递归遍历左子树，只要在左子树中找到了p或q，则先找到谁就返回谁
        TreeNode right = lowestCommonAncestorV1(root.right, p, q); // 递归遍历右子树，只要在右子树中找到了p或q，则先找到谁就返回谁
        if (left == null) return right; // 如果在左子树中 p和 q都找不到，则 p和 q一定都在右子树中，右子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else if (right == null)
            return left; // 否则，如果 left不为空，在左子树中有找到节点（p或q），这时候要再判断一下右子树中的情况，如果在右子树中，p和q都找不到，则 p和q一定都在左子树中，左子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else return root; //否则，当 left和 right均不为空时，说明 p、q节点分别在 root异侧, 最近公共祖先即为 root
    }

    public int publicNode(TreeNode treeNode) {
        return 0;
    }

    public int maxPath(TreeNode treeNode, TreeNode p, TreeNode q) {
        return 0;
    }

    public void mirroTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        TreeNode temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = temp;
        mirroTree(treeNode.left);
        mirroTree(treeNode.right);
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        getSum(root, sum, new ArrayList<>());
        return result;
    }

    public void getSum(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        sum = sum - root.val;
        list.add(root.val);
        if (sum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        } else {
            getSum(root.left, sum, list);
            getSum(root.right, sum, list);
        }
        list.remove(list.size() - 1);
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
