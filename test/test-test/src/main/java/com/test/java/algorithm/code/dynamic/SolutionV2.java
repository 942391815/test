package com.test.java.algorithm.code.dynamic;

import com.test.java.algorithm.offer.TreeNode;
import com.test.java.algorithm.offer.TreeNodeUtil;
import sun.reflect.generics.tree.Tree;

/**
 * Created by qiaogu on 2020/12/18.
 */
public class SolutionV2 {
    TreeNode pre, head;

    public static void main(String[] args) {
        SolutionV2 solutionV1 = new SolutionV2();
        TreeNode treeNode = TreeNodeUtil.initMiddelNode();
        TreeNode treeNode1 = solutionV1.treeToDoublyList(treeNode);
        System.out.println(treeNode1);
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
