package com.test.java.algorithm.matrix;

import com.test.java.algorithm.offer.TreeNode;

public class TestTwo {
    public static void main(String[] args) {
        TreeNode initTree = Test.initTree();
        TestTwo test = new TestTwo();
        System.out.println(test.pathSum(initTree,22));
    }
    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        int maxDeep = getMaxDeep(root);
        int path[] = new int[maxDeep];
        findSum(root,sum,path,0);
        return count;
    }

    private void findSum(TreeNode node, int sum, int path[], int level) {
        if (node == null) {
            return;
        }
        path[level] = node.val;
        int t = 0;
        for(int i=level;i>=0;i--){
            t = t+path[i];
            if(t==sum){
                count++;
            }
        }
        findSum(node.left,sum,path,level+1);
        findSum(node.right,sum,path,level+1);
        path[level] = Integer.MIN_VALUE;
    }

    public int getMaxDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getMaxDeep(root.left), getMaxDeep(root.right));
    }
}
