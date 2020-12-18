package com.test.java.algorithm.code.dynamic;

import com.test.java.algorithm.offer.TreeNode;

import java.util.*;

/**
 * Created by Micheal on 2020/11/21.
 */
public class DynamicTest {
    public static void main(String[] args) {
        int array[] = {9, 11, 8, 5, 7, 12, 16, 14};
        int giftArray[][] = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        DynamicTest test = new DynamicTest();
        //股票的最大利润
//        System.out.println(test.maxProfit(array));
//        System.out.println(test.maxUpSubV1(array));
        //最大上升子序列
//        System.out.println(test.maxUpSub(array));
        //礼物的最大价值
//        System.out.println(test.maxGiftValue(giftArray, giftArray.length, giftArray[0].length));
        //剪绳子
//        System.out.println(test.cutRop(8));
        //最长不含重复字符的子串
//        System.out.println(test.longestStrNoRepeatV1("arabcacfr"));
        //连续子数组的最大和
//        int subArray[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(test.maxSubArray(subArray));
        //全排列
//        int array1[] = {1, 2, 3};
//        List<List<Integer>> permute = test.permute(array1);
//        System.out.println(permute);
//        int num[] = {3, 30, 34, 5, 9};
//        System.out.println(test.minNumber(num));
//        int preorder[] = {3, 9, 20, 15, 7};
//        int inorder[] = {9, 3, 15, 20, 7};
//        TreeNode treeNode = test.buildTree(preorder, inorder);
//        System.out.println(treeNode);
//        int arrayV[] = {1, 2, 3, 4,};
//        System.out.println(test.exchange(arrayV));
        int num[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = test.maxSlidingWindow(num, 3);
        System.out.println(ints);
    }

    public int reversePairs(int[] nums) {
        int len=nums.length;
        if(len==0)
            return 0;
        return digui(nums,0,len-1);
    }
    public int digui(int[] nums,int left,int right){
        if(left>=right)
            return 0;
        int mid=(right+left)>>1;
        int l=digui(nums,left,mid);//记录左边的结果
        int r=digui(nums,mid+1,right);//记录右边的结果
        return (l+r+mergesort(nums,left,mid,right));//左+右+当前

    }
    public int mergesort(int[]nums,int left,int mid,int right){
        int[]temp=new int[right-left+1];//left和right都可以取到，所以需要加1
        int ans=0;
        int cur1=mid;
        int cur2=right;
        int cur3=right-left;
        while(cur1>=left&&cur2>=mid+1){
            if(nums[cur1]<=nums[cur2]){
                temp[cur3--]=nums[cur2--];
            }
            else{
                temp[cur3--]=nums[cur1--];
                ans+=(cur2-mid);//比当前cur2里面的元素都大
            }
        }
        while(cur1>=left){
            temp[cur3--]=nums[cur1--];
        }
        while(cur2>=mid+1){
            temp[cur3--]=nums[cur2--];
        }
        int x=0;
        while(left<=right){
            nums[left++]=temp[x++];
        }
        return ans;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0 || nums.length == 0) {
            return new int[0];
        }
        int result[] = new int[nums.length - k + 1];
        for (int i = 0, j = i + k - 1; i < nums.length; i++, j++) {
            if (j >= nums.length) {
                break;
            }
            result[i] = getMaxValue(nums, i, j);
        }
        return result;
    }

    public int getMaxValue(int num[], int i, int j) {
        int max = num[i];
        i = i + 1;
        while (i <= j) {
            max = Math.max(max, num[i]);
            i++;
        }
        return max;
    }

    public int[] exchange(int nums[]) {
        int i = 0;
        int j = nums.length - 1;
        int temp = 0;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) {
                i++;
            }
            while (i < j && (nums[j] & 1) == 0) {
                j--;
            }
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    // [3,4,5,1,2]
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (numbers[middle] > numbers[right]) {
                left = middle + 1;
            } else if (numbers[middle] == numbers[right]) {
                right = right - 1;
            } else {
                right = middle;
            }
        }
        return numbers[left];
    }


    public int minArrayV1(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i + 1 < n; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int rootValue = preorder[0];
        int index = -1;
        //index 为中序遍历左子树位置
        for (int i = 0; i < inorder.length; i++) {
            if (Objects.equals(rootValue, inorder[i])) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        //中序左子树
        int[] inOrderLeft = Arrays.copyOfRange(inorder, 0, index);
        //中序遍历柚子树
        int[] inOrderRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        //先序遍历左子树
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, index + 1, preorder.length);

        root.left = buildTree(preorderLeft, inOrderLeft);
        root.right = buildTree(preorderRight, inOrderRight);
        return root;
    }

    //连续子数组的最大和
    public int maxSubArray(int array[]) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int dp[] = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    //最长不含重复字符的子串
    public int longestStrNoRepeatV1(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int dp = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer lastI = map.getOrDefault(c, -1);
            map.put(c, i);
            if (dp < i - lastI) {
                dp = dp + 1;//说明不含重复字符
            } else {
                dp = i - lastI;//重复字符加载中间
            }
            res = Math.max(dp, res);
        }
        return res;
    }

    //剪绳子
    public int cutRop(int len) {
        int result[] = new int[len + 1];
        if (len == 0) {
            return 0;
        }
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        for (int i = 4; i <= len; i++) {
            int max = result[i];
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, result[i - j] * result[j]);
            }
            result[i] = max;
        }
        return result[len];
    }

    //礼物最大值
    public int maxGiftValue(int array[][], int column, int rows) {
        int result[][] = new int[rows][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = result[i - 1][j];
                }
                if (j > 0) {
                    left = result[i][j - 1];
                }
                result[i][j] = Math.max(up, left) + array[i][j];
            }
        }
        return result[rows - 1][column - 1];
    }

    /**
     * 最大上升子序列
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     */
    public int maxUpSub(int num[]) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int dp[] = new int[num.length];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < num.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int maxUpSubV1(int num[]) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int length = num.length;
        int dp[] = new int[num.length];
        dp[0] = 1;
        int max = dp[0];
        /**
         * dp[i] = dp[i-1]+1
         */

        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    //股票最大值
    public int maxProfit(int array[]) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int min = array[0];
        int maxDiff = array[1] - min;
        for (int i = 2; i < array.length; i++) {
            if (array[i - 1] < min) {
                min = array[i - 1];
            }
            int currentDiff = array[i] - min;
            if (currentDiff > maxDiff) {
                maxDiff = currentDiff;
            }
        }
        return maxDiff;
    }

    public int maxProfitV1(int price[]) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int each : price) {
            cost = Math.min(cost, each);
            profit = Math.max(profit, each - cost);
        }
        /**
         * 1.找到最小值
         *
         * dp[i] = max(dp[i-1],dp[i]-min)
         */
        return profit;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> result, int[] visited) {
        if (nums.length == result.size()) {
            res.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;//标记
            result.add(nums[i]);
            backtrack(res, nums, result, visited);
            visited[i] = 0;
            result.remove(result.size() - 1);
        }
    }

    public String minNumber(int[] nums) {
        String[] strArray = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArray[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArray, (x, y) -> (x + y).compareTo(y + x));
        String str = "";
        for (int i = 0; i < strArray.length; i++) {
            str = str + strArray[i];
        }
        return str;
    }

    public List<List<Integer>> levelOrderV1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            Queue<TreeNode> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode each = queue.poll();
                cur.add(each.val);
                if (each.left != null) {
                    next.add(each.left);
                }
                if (each.right != null) {
                    next.add(each.right);
                }
            }
            list.add(cur);
            queue = next;
        }
        return list;
    }

    public int[] levelOrder(TreeNode root) {
        List<Integer> tempArray = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            tempArray.add(treeNode.val);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        int result[] = new int[tempArray.size()];
        for (int i = 0; i < tempArray.size(); i++) {
            result[i] = tempArray.get(i);
        }
        return result;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        return isSymmetric(left, right);
    }


    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (Objects.equals(left.val, right.val)) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;
    }

    public int cuttingRope(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * dp[j]);
            }
        }
        return dp[n + 1];
    }
}
