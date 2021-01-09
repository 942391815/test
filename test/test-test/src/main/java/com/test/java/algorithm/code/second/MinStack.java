package com.test.java.algorithm.code.second;

import com.test.java.algorithm.offer.ArrayUtil;

import javax.validation.constraints.Min;
import java.util.Objects;
import java.util.Stack;

/**
 * Created by qiaogu on 2020/12/28.
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
//        minStack.push(0);
//        minStack.push(1);
//        minStack.push(0);
//        System.out.println(minStack.min());
//        minStack.pop();
//        System.out.println(minStack.min());
        int array[] = {1, 2, 3, 3, 2, 1, 4, 5};
        int[] numbs = minStack.getNumbs(array);
        ArrayUtil.printArray(numbs);
    }

    public int[] getNumbs(int array[]) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            res = res ^ array[i];
        }
        int flag = res & (-res);
        int one = 0;
        int two = 0;
        for (int i = 0; i < array.length; i++) {
            if ((flag & array[i]) == 0) {
                one = one ^ array[i];
            } else {
                two = two ^ array[i];
            }
        }
        int result[] = new int[2];
        result[0] = one;
        result[1] = two;
        return result;
    }

    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        A.push(x);
        if (B.isEmpty() || B.peek() >= x) {
            B.push(x);
        }
    }

    public void pop() {
        Integer pop = A.pop();
        if (!B.isEmpty() && Objects.equals(B.peek(), pop)) {
            B.pop();
        }
    }

    public int top() {
        if (!A.isEmpty()) {
            return A.peek();
        }
        return -1;
    }

    public int min() {
        if (!B.isEmpty()) {
            return B.peek();
        }
        return -1;
    }
}
