package com.test.java.algorithm.sort;

/**
 * Created by micheal on 2020/1/6.
 * 冒泡排序
 */
public class Bubbling {
    public static void main(String[] args) {
        int array[] = {12,1,3,0,9,-50,-1};
        sort(array);
        print(array);
    }
    public static void sort(int array[]){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public static void print(int array[]){
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
