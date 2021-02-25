package com.test.java.algorithm.code.others;

import com.test.java.algorithm.offer.ListNode;
import com.test.java.algorithm.offer.TreeNode;
import com.test.java.algorithm.offer.TreeNodeUtil;

import java.util.*;

/**
 * Created by Micheal on 2020/11/22.
 */
public class OthersTestV3 {
    public static void main(String[] args) {
        OthersTestV3 othersTest = new OthersTestV3();
//        double[] doubles = othersTest.twoSum(2);
//        ArrayUtil.printArray(doubles);
        int coins[] = {1, 2, 5};
        int amount = 5;
        int array[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
//        othersTest.spiralOrder(array);
//        TreeNode treeNode = TreeNodeUtil.initMiddelNode();
//        System.out.println(othersTest.MiddlePrint(treeNode));
        System.out.println(othersTest.lengthOfLongestSubstring("abcabcbb"));
        int num[] = {1, 2, 3, 4, 3, 4};
        othersTest.singleNumbers(num);

        System.out.println(ToDBC("章光101VeryGood!- -?ａｓｄｆａｓｄｆ"));
    }

    public static String ToDBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '\u3000') {
                c[i] = ' ';
            } else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
                c[i] = (char) (c[i] - 65248);
            }
        }
        String returnString = new String(c);
        return returnString;
    }

    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int max = 1;
        int min = 14;
        for (int each : nums) {
            if (each == 0) {
                continue;
            }
            if (set.contains(each)) {
                return false;
            }
            set.add(each);
            max = Math.max(max, each);
            min = Math.min(min, each);
        }
        return max - min < 5;
    }

    public int lengthOfLongestSubstringV1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = -1;
        int result = 1;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j);
            result = Math.max(result, j - i);
        }
        return result;
    }

    public void singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp = temp ^ nums[i];
        }
        int flag = temp & -temp;
        int one = 0;
        int two = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & flag) == 0) {
                one = one ^ nums[i];
            } else {
                two = two ^ nums[i];
            }
        }
        System.out.println(one + "------" + two);
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int start = -1;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                //如果hash表里有相同的key，更新start
                start = Math.max(start, map.get(chars[i]));
            }
            //更新hash表
            map.put(chars[i], i);
            maxLen = Math.max(maxLen, i - start);
        }
        return maxLen;
    }

    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        if (p.length() > 2 && p.charAt(1) == '*') {
            //*号情况
            return isMatch(s, p.substring(2)) || (s.length() > 0 && compair(s, p)) && isMatch(s.substring(1), p);
        } else {
            return s.length() > 0 && p.length() > 0 && compair(s, p) && isMatch(s.substring(1), p.substring(1));
        }
    }

    public boolean compair(String s, String p) {
        return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
    }


    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];

        int N = matrix.length;//行
        int M = matrix[0].length;//列

        int[] res = new int[N * M];
        int k = 0; //用于结果数组的索引
        ArrayList<Integer> intermediate = new ArrayList<Integer>();//装载内循环的整数


        //外循环遍历顶端对角线
        for (int d = 0; d < N + M - 1; d++) {
            intermediate.clear();//内循环遍历之前都要清理

            //确定顶端对角元素的位置
            int row = d < M ? 0 : d + 1 - M;
            int col = d < M ? d : M - 1;

            while (row < N && col > -1) {
                intermediate.add(matrix[row][col]);
                row++;
                col--;
            }
            //偶数列
            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }
            //装进结果数组中
            for (int i = 0; i < intermediate.size(); i++) {
                res[k] = intermediate.get(i);
                k++;

            }
        }
        return res;
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || pushed.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    //    public int kthLargest(TreeNode root, int k) {
//        List<Integer> list = MiddlePrint(root);
//        return list.get(list.size() - k);
//    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int val = preorder[0];
        int index = 0;
        TreeNode root = new TreeNode(val);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        //先序左子树
        int preLeft[] = Arrays.copyOfRange(preorder, 1, index + 1);
        //先序右子树
        int preRight[] = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        //中序左子树
        int middleLeft[] = Arrays.copyOfRange(inorder, 0, index);
        //中序右子树
        int middleRight[] = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        root.left = buildTree(preLeft, middleLeft);
        root.right = buildTree(preRight, middleRight);
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        return getParentNode(root, p, q);
    }

    private TreeNode getParentNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = getParentNode(root.left, p, q);
        TreeNode right = getParentNode(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public int sumNumsV1(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public int missingNumberV1(int nums[]) {
        int low = 0;
        int hight = nums.length;
        while (low < hight) {
            int middle = (low + hight) / 2;
            if (nums[middle] != middle) {
                hight = middle;
            } else {
                low = middle;
            }
        }
        return low;
    }

    // array[] = {0,1,3};
    public int missingNumber(int[] nums) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] != mid) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private List<Integer> MiddlePrint(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                root = pop.right;
            }
        }
        return list;
    }

    public int maxDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDeep(root.left), maxDeep(root.right)) + 1;
    }

    public TreeNode mirrorTree(TreeNode root) {
        reverse(root);
        return root;
    }

    private void reverse(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            reverse(root.left);
            reverse(root.right);
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public void spiralOrder(int array[][]) {
        if (array == null || array.length == 0) {
            return;
        }
        int start = 0;
        int row = array.length;
        int column = array[0].length;
        while (row > start * 2 && column > start * 2) {
            spiralOrder(array, row, column, start);
            start++;
        }
    }

    public void spiralOrder(int array[][], int row, int column, int start) {
        int endRow = row - start - 1;
        int endColumn = column - start - 1;

        //从左往右
        for (int i = start; i <= endColumn; i++) {
            System.out.print(array[start][i] + " \t");
        }
        //从上往下
        if (start < endRow) {
            for (int i = start + 1; i <= endRow; i++) {
                System.out.print(array[i][endColumn] + " \t");
            }
        }
        //从右往左
        if (start < endRow && start < endColumn) {
            for (int i = endColumn - 1; i >= start; i--) {
                System.out.print(array[endRow][i] + " \t");
            }
        }
        //从下往上
        if (start < endRow - 1 && start < endColumn) {
            for (int i = endRow - 1; i > start; i--) {
                System.out.print(array[i][start] + "\t");

            }
        }
    }
}