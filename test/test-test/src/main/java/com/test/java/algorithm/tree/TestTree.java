package com.test.java.algorithm.tree;

import com.google.common.collect.Lists;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * Created by Micheal on 2020/2/10.
 */
public class TestTree {
    public static void main(String[] args) {
        Node tree = getTree();
        mirrorV1(tree);
//        int level = maxLevel(tree);
//        System.out.println(tree);
        List<List<Integer>> lists = levelOrder(tree);
        for (List<Integer> each : lists) {
            System.out.println(each);
        }
    }

    public static void mirrorV1(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        Node temp = null;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            mirrorV1(root.left);
        }
        if (root.right != null) {
            mirrorV1(root.right);
        }
    }


    public static void mirror(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        Node temp = null;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            mirror(root.left);
        }
        if (root.right != null) {
            mirror(root.right);
        }
    }

    public static int getMaxWith(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        int result = 1;
        while (true) {
            int len = queue.size();
            if (len == 0) {
                break;
            }
            while (len > 0) {
                Node poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                len--;
            }
            result = Math.max(result, queue.size());
        }
        return result;
    }

    public static List<List<Integer>> levelOrderV1(Node node) {
        List<List<Integer>> result = Lists.newArrayList();
        List<Node> list = Lists.newArrayList();
        list.add(node);
        while (!list.isEmpty()) {
            List<Integer> cur = Lists.newArrayList();
            List<Node> next = Lists.newArrayList();
            for (Node each : list) {
                cur.add(each.value);
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

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList();
        List<Node> list = new ArrayList();
        if (root == null) return result;
        list.add(root);
        while (!list.isEmpty()) {
            List<Integer> curList = new ArrayList();
            List<Node> nextList = new ArrayList();
            for (Node cur : list) {
                curList.add(cur.value);
                if (cur.left != null) nextList.add(cur.left);
                if (cur.right != null) nextList.add(cur.right);
            }
            list = nextList;
            result.add(curList);
        }
        return result;
    }

    public static void level(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node peek = queue.poll();
            System.out.println(peek.value);
            if (peek.left != null) {
                queue.offer(peek.left);
            }
            if (peek.right != null) {
                queue.offer(peek.right);
            }
        }
    }

    /**
     * 递归
     *
     * @param node
     * @return
     */
    public static int maxLevel(Node node) {
        if (node == null) {
            return 0;
        }
        return maxLevel(node.left) + 1 > maxLevel(node.right) + 1 ?
                maxLevel(node.left) + 1 : maxLevel(node.right) + 1;
    }

    public static Node getTree() {
        Node one = new Node();
        Node two = new Node();
        Node three = new Node();
        Node four = new Node();
        Node five = new Node();
        Node six = new Node();
        Node seven = new Node();
        one.value = 1;
        two.value = 2;
        three.value = 3;
        four.value = 4;
        five.value = 5;
        six.value = 6;
        seven.value = 10;
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.right = six;
        three.left = seven;
        return one;
    }
}
