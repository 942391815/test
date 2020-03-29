package com.test.java.algorithm.mine;

import com.test.java.algorithm.list.ListNode;

/**
 * Created by Micheal on 2020/3/22.
 */
public class FindForTwo {
    public static void main(String[] args) {
        int arry[] = {1, 3, 6, 7, 10, 30};
        int target = 101;
//        findForTwo(arry, target);
        int sortArray[] = {2, 1, 10, -9, 100, -1000, 1000};
//        heapSort(sortArray);
//        for (int each : sortArray) {
//            System.out.println(each);
//        }
//        initNode();
        int nums[] = {2, 2};
        System.out.println(search(nums, 2));
    }

    public static int search(int[] nums, int target) {
        int index = getIndex(nums, target);
        if (index < 0) {
            return 0;
        }
        int count = 1;
        int left = index - 1;
        int right = index + 1;
        while (left >= 0 && nums[left] == target) {
            count++;
            left--;
        }
        while (right < nums.length && nums[right] == target) {
            count++;
            right++;
        }
        return count;
    }

    public static int getIndex(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] > target) {
                end = middle - 1;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void initNode() {
        int array[] = {1, 2, 3, 4, 5};
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
//        ListNode six = new ListNode(6);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
//        five.next = six;
        ListNode listNode = middleNode(one);
        System.out.println(listNode.val);
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void heapSort(int array[]) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = array.length / 2; i >= 0; i--) {
            heapSort(array, i, array.length);
        }
        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapSort(array, 0, i);
        }
    }

    public static void heapSort(int array[], int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if (left < size && array[left] > array[largest]) {
            largest = left;
        }
        if (right < size && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != index) {
            replace(array, largest, index);
            heapSort(array, largest, size);
        }
    }

    public static void replace(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void quickSort(int array[]) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int array[], int start, int end) {
        if (start >= end) {
            return;
        }
        int low = start;
        int high = end;
        int index = array[low];
        while (low < high) {
            while (low < high && array[high] >= index) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= index) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = index;
        quickSort(array, start, low - 1);
        quickSort(array, low + 1, end);
    }

    public static int findForTwo(int arr[], int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] > target) {
                right = middle - 1;
            } else if (arr[middle] < target) {
                left = middle + 1;
            } else {
                System.out.println("查询到目标值" + target);
                return target;
            }
        }
        return -1;
    }
}
