//package com.test.java.algorithm.code.dynamic;
//
//import com.google.common.collect.Lists;
//import com.test.java.algorithm.offer.ArrayUtil;
//import com.test.java.algorithm.offer.TreeNode;
//import com.test.java.algorithm.offer.TreeNodeUtil;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
///**
// * Created by qiaogu on 2020/12/18.
// */
//public class Codec {
//    static List<List<Integer>> result = Lists.newArrayList();
//
//    public static void main(String[] args) {
//        Codec codec = new Codec();
//        TreeNode treeNode = TreeNodeUtil.initSeriTreeNode();
////        String serialize = codec.serialize(treeNode);
////        ArrayUtil.printArray(serialize);
////        System.out.println(serialize);
////        int array[] = {1, 2, 3};
////        codec.sortArray(array);
////        System.out.println(result);
//        System.out.println(codec.isMatch("aa", "a*"));
//
//    }
//
//    public boolean verifyPostorder(int[] postorder) {
//        if (postorder == null || postorder.length == 0) {
//            return true;
//        }
//        return verifyPostorder(postorder, 0, postorder.length - 1);
//    }
//
//    public boolean verifyPostorder(int[] postorder, int i, int j) {
//        if (postorder == null || postorder.length == 0) {
//            return true;
//        }
//        int num = postorder[postorder.length - 1];
//        int p = 0;
//        while (p < postorder.length && postorder[p] < num) {
//            p++;
//        }
//        int middle = p;
//        while (p < postorder.length && postorder[p] > num) {
//            p++;
//        }
//        return p == postorder.length && verifyPostorder()
//    }
//
//    /**
//     * @param s s为字符串
//     * @param p p为正则表达式
//     * @return
//     */
//    public boolean isMatch(String s, String p) {
//        if (p.length() == 0) {
//            return s.length() == 0;
//        }
//        if (p.length() > 1 && p.charAt(1) == '*') {
//            //去掉* 进行匹配
//            //多次匹配
//            return isMatch(s, p.substring(2)) || (s.length() > 0 && compair(s, p)) && isMatch(s.substring(1), p);
//        } else {
//            return s.length() > 0 && p.length() > 0 && compair(s, p) && isMatch(s.substring(1), p.substring(1));
//        }
//    }
//
//    public boolean compair(String s, String p) {
//        return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
//    }
//
//    /**
//     * 数字的全排列
//     */
//    public void sortArray(int array[]) {
//        if (array == null || array.length == 0) {
//            return;
//        }
//        int vistied[] = new int[array.length];
//        List<Integer> list = new ArrayList<>();
//        sortArray(array, vistied, list);
//    }
//
//    private void sortArray(int[] array, int[] vistied, List<Integer> list) {
//        if (list.size() == array.length) {
//            List<Integer> integers = new ArrayList<>(list);
//            result.add(integers);
//        }
//        for (int i = 0; i < array.length; i++) {
//            if (vistied[i] == 1) {
//                continue;
//            }
//            vistied[i] = 1;
//            list.add(array[i]);
//            sortArray(array, vistied, list);
//            vistied[i] = 0;
//            list.remove(list.size() - 1);
//        }
//    }
//
//    public boolean verifyPostorder(int[] postorder) {
//        if (postorder == null || postorder.length == 0) {
//            return false;
//        }
//        return verifyPostorder(postorder, 0, postorder.length - 1);
//    }
//
//    public boolean verifyPostorder(int postorder[], int i, int j) {
//        if (i >= j) return true;
//        int p = i;
//        while (postorder[p] < postorder[j]) {
//            p++;
//        }
//        int m = p;
//        while (postorder[p] > postorder[j]) {
//            p++;
//        }
//        return p == j && verifyPostorder(postorder, i, m - 1) && verifyPostorder(postorder, m, j - 1);
//    }
//
//    public String serialize(TreeNode root) {
//        if (root == null) return "[]";
//        StringBuilder res = new StringBuilder("[");
//        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
//            add(root);
//        }};
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node != null) {
//                res.append(node.val + ",");
//                queue.add(node.left);
//                queue.add(node.right);
//            } else res.append("null,");
//        }
//        res.deleteCharAt(res.length() - 1);
//        res.append("]");
//        return res.toString();
//    }
//
//    public String[] serializeV1(TreeNode root) {
//        List result = new ArrayList<>();
//        if (root == null) {
//            return null;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node != null) {
//                result.add(node.val);
//                queue.add(node.left);
//                queue.add(node.right);
//            } else {
//                result.add(null);
//            }
//        }
//        String[] resultArray = new String[result.size()];
//        for (int i = 0; i < result.size(); i++) {
//            resultArray[i] = String.valueOf(result.get(i));
//        }
//        return resultArray;
//    }
//
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if ("[]".equals(data)) {
//            return null;
//        }
//        String values[] = data.substring(1, data.length() - 1).split(",");
//        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        int i = 1;
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (!values[i].equals("null")) {
//                node.left = new TreeNode(Integer.parseInt(values[i]));
//                queue.add(node.left);
//            }
//            i++;
//            if (!values[i].equals("null")) {
//                node.right = new TreeNode(Integer.parseInt(values[i]));
//                queue.add(node.right);
//            }
//            i++;
//        }
//        return root;
//    }
//
//    public TreeNode deserializeV1(String data) {
//        if (data.equals("[]")) return null;
//        String[] vals = data.substring(1, data.length() - 1).split(",");
//        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
//        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
//            add(root);
//        }};
//        int i = 1;
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (!vals[i].equals("null")) {
//                node.left = new TreeNode(Integer.parseInt(vals[i]));
//                queue.add(node.left);
//            }
//            i++;
//            if (!vals[i].equals("null")) {
//                node.right = new TreeNode(Integer.parseInt(vals[i]));
//                queue.add(node.right);
//            }
//            i++;
//        }
//        return root;
//    }
//}
