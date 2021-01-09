package com.test.java.algorithm.code.second;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by qiaogu on 2020/12/25.
 */
public class Solution {
    public static void main(String[] args) {
        Solution test = new Solution();
//        int array[] = {3, 2, 1};
//        int[] leastNumbers = test.getLeastNumbers(array, 2);
//        for (int i = 0; i < leastNumbers.length; i++) {
//            System.out.print(leastNumbers[i] + "\t");
//        }
//        System.out.println(test.isNumber("5e"));
        System.out.println(test.myPow(3, 2));
    }

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }
        while (b > 0) {
            if((b&1)==1){
                res = res*x;
            }
            b = b>>>1;
            x = x*x;
        }
        return res;
    }


    public double myPowV1(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * x;
            }
            b = b >>> 1;
            x = x * x;
        }
        return res;
    }

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] str = s.trim().toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                numSeen = true;
            } else if (str[i] == '.') {
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numSeen = false;////重置numSeen，排除123e或者123e+的情况,确保e之后也出现数
            } else if (str[i] == '-' || str[i] == '+') {
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numSeen;
    }


    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) != null) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        Set<Character> keySet = map.keySet();
        for (Character each : keySet) {
            if (map.get(each) == 1) {
                return each;
            }
        }
        return ' ';
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


    public Node copyRandomListV1(Node head) {
        HashMap<Node, Node> map = new HashMap<>(); //创建HashMap集合
        Node cur = head;
        //复制结点值
        while (cur != null) {
            //存储put:<key,value1>
            map.put(cur, new Node(cur.val)); //顺序遍历，存储老结点和新结点 (先存储新创建的结点值)
            cur = cur.next;
        }
        //复制结点指向
        cur = head;
        while (cur != null) {
            //得到get:<key>.value2,3
            map.get(cur).next = map.get(cur.next); //新结点next指向同旧结点的next指向
            map.get(cur).random = map.get(cur.random); //新结点random指向同旧结点的random指向
            cur = cur.next;
        }

        //返回复制的链表
        return map.get(head);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int size = arr.length;
        //构建堆
        for (int i = size / 2; i >= 0; i--) {
            heapSort(arr, i, size);
        }
        for (int i = size - 1, j = 0; i >= 0 && j < k; i--, j++) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapSort(arr, 0, i);
        }
        int result[] = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[size - i - 1];
        }
        return result;
    }

    private void heapSort(int array[], int index, int size) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < size && array[left] < array[largest]) {
            largest = left;
        }
        if (right < size && array[right] < array[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(array, largest, index);
            heapSort(array, largest, size);
        }
    }

    private void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
