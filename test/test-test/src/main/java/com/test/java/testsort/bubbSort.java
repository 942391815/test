package com.test.java.testsort;

public class bubbSort {
	public static void main(String args[]){
		int aa[]={100,4,1,2,5,6,10};
		int temp=0;
		for(int i=0;i<aa.length;i++){
			for(int j=i;j<aa.length;j++){
				if(aa[i]>aa[j]){
					temp=aa[i];
					aa[i]=aa[j];
					aa[j]=temp;
				}
			}
		}
		for(int c:aa){
			System.out.println(c);
		}
	}
}
