package com.test.java.algorithm.tree;

import com.google.common.collect.Lists;

import java.util.*;


/**
 * Created by Micheal on 2020/2/10.
 */
public class TestTree {
    public static void main(String[] args) {
        Node tree = getTree();
//        mirrorV1(tree);
//        int level = maxLevel(tree);
//        System.out.println(tree);
//        List<List<Integer>> lists = levelOrder(tree);
//        for (List<Integer> each : lists) {
//            System.out.println(each);
//        }
//        TestTree testTree = new TestTree();
//        testTree.prePrint(tree);
//        System.out.println("");
//        testTree.middlePrint(tree);
//        System.out.println("");
//        testTree.afterPrint(tree);
//        System.out.println("");
//        testTree.snakePrintTree(tree);

        int array[] = {6, 7, 5, 1, 0, 4, 6};
//        quickSort(array);
        heapfiy(array);
        printArray(array);
    }

    public static void heapfiy(int array[]) {
        if (array == null || array.length == 0) {
            return;
        }
        int size = array.length;
        for (int i = size / 2; i >= 0; i--) {
            heapSort(array, i, size);
        }
        for (int i = size - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapSort(array, 0, i);

        }
    }

    private static void heapSort(int[] array, int index, int size) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < size && array[left] > array[largest]) {
            largest = left;
        }
        if (right < size && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != index) {
            swapArray(array, largest, index);
            heapSort(array, largest, size);
        }
    }

    private static void swapArray(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static boolean findForTwo(int array[], int target) {
        if (array == null || array.length == 0) {
            return false;
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (array[middle] > target) {
                end = middle - 1;
            } else if (array[middle] < target) {
                start = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " \t");
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
        seven.value = 7;
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        return one;
    }

    public void prePrint(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.print(node.value + " \t");
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    public void middlePrint(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.value + " \t");
                node = node.right;
            }
        }
    }

    public void afterPrint(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> one = new Stack<>();
        Stack<Node> two = new Stack<>();
        one.push(root);
        while (!one.isEmpty()) {
            Node node = one.pop();
            two.push(node);
            if (node.left != null) {
                one.push(node.left);
            }
            if (node.right != null) {
                one.push(node.right);
            }
        }
        while (!two.isEmpty()) {
            Node pop = two.pop();
            System.out.print(pop.value + " \t");
        }
    }

    public void snakePrintTree(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        int level = 1;
        print(level, stack);
    }

    private void print(int level, Stack<Node> stack) {
        if (stack.isEmpty()) {
            return;
        }
        System.out.println(level);
        Stack<Node> child = new Stack<>();
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.value + " \t");
            if (node != null) {
                if (level % 2 == 0) {
                    if (node.left != null) {
                        child.push(node.left);
                    }
                    if (node.right != null) {
                        child.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        child.push(node.right);
                    }
                    if (node.left != null) {
                        child.push(node.left);
                    }
                }
            }
        }
        System.out.println();
        level++;
        print(level, child);
    }

    public static void quickSort(int array[]) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int low = left;
        int hight = right;
        int index = array[low];
        while (low < hight) {
            while (low < hight && array[hight] >= index) {
                hight--;
            }
            array[low] = array[hight];
            while (low < hight && array[low] <= index) {
                low++;
            }
            array[hight] = array[low];
        }
        array[low] = index;
        quickSort(array, left, low - 1);
        quickSort(array, low + 1, right);
    }
}
