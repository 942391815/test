package com.test.java.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Micheal on 2020/4/6.
 * 二叉树的路径和为S
 */
public class TreeSum {
    static List<List<Integer>> context = new ArrayList<>();

    public static void getWay(Node root, int sum) {
        if (root == null) {
            return;
        }
        List<Integer> list = new ArrayList();
        addForSum(root, list, sum);
    }

    public static void addForSum(Node node, List<Integer> list, int sum) {
        if (node == null) {
            return;
        }
        list.add(node.value);
        sum = sum - node.value;
        if (sum == 0 && node.left == null && node.right == null) {
            context.addAll(new ArrayList(list));
        } else {
            addForSum(node.left, list, sum);
            addForSum(node.right, list, sum);
        }
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        Node left = new Node(1);
        Node right = new Node(3);
        root.left = left;
        root.right = right;
        getWay(root, 3);
        System.out.println(context);
    }
}
