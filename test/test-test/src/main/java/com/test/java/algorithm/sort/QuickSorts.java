package com.test.java.algorithm.sort;

/**
 * Created by Micheal on 2020/1/9.
 */
public class QuickSorts {
    public static void main(String[] args) {
        int array [] = {17,2,5,1,6,7,9,0};
        sort(array,0,array.length-1);
        System.out.println(array);
    }
    public static void sort(int arry[],int left,int right){
        if(left>=right){
            return;
        }
        int low = left;
        int hight = right;
        int key = arry[left];
        while (low<hight){
            while (low<hight && arry[hight]>=key){
                hight--;
            }
            arry[low] = arry[hight];
            while (low<hight && arry[low]<=key){
                low++;
            }
            arry[hight] = arry[low];
        }
        arry[low] = key;
        sort(arry,left,low-1);
        sort(arry,hight+1,right);
    }
}
