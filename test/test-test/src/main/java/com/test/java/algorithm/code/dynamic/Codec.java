package com.test.java.algorithm.code.dynamic;

import com.test.java.algorithm.offer.ArrayUtil;
import com.test.java.algorithm.offer.TreeNode;
import com.test.java.algorithm.offer.TreeNodeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qiaogu on 2020/12/18.
 */
public class Codec {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode treeNode = TreeNodeUtil.initSeriTreeNode();
        String[] serialize = codec.serialize(treeNode);
        ArrayUtil.printArray(serialize);
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return false;
        }
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int postorder[], int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && verifyPostorder(postorder, i, m - 1) && verifyPostorder(postorder, m, j - 1);
    }

    public String[] serialize(TreeNode root) {
        List result = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            } else {
                result.add(null);
            }
            if (node.right != null) {
                queue.add(node.right);
            } else {
                result.add(null);
            }
        }
        String[] resultArray = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = String.valueOf(result.get(i));
        }
        return resultArray;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}
