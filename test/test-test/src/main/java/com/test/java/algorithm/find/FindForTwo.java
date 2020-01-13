package com.test.java.algorithm.find;

/**
 * Created by micheal on 2020/1/6.
 * 二分查找
 */
public class FindForTwo {
    public static void main(String[] args) {
        int array[] = {10,30,55,67,100,188,190,289};
        int target = 101;
//        System.out.println(findForTwo(array,target));
//        System.out.println(findForTwo(array,100));

        System.out.println(findForTwoRec(array,0,array.length-1,100));
        System.out.println(findForTwoRec(array,0,array.length-1,102));
    }

    public static int findForTwoRec(int array[],int left,int right,int target){
        if(target<array[left]|| target>array[right]|| left>right){
            return -1;
        }
        int middle = (left+right)/2;
        if(array[middle]>target){
            return findForTwoRec(array,left,middle-1,target);
        }else if(array[middle]<target){
            return findForTwoRec(array,middle+1,right,target);
        }else {
            return array[middle];
        }
    }
    public static int findForTwo(int array[],int target){
        int left =0;
        int right=array.length-1;
        while (left<=right){
            int middle = (left+right)/2;
            if(array[middle]<target){
                left = middle+1;
            }else if(array[middle]>target){
                right = middle-1;
            }else{
                return array[middle];
            }
        }
        return -1;
    }
}
