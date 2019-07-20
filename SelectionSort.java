package com.gitwh;


public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4,2,3,1,7,88,0,6};
        selection(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static int[] selection(int[] arr){
        int k = 0;
        for (int i = 0;i < arr.length;i++){
            k = i;
            for (int j = i+1;j<arr.length;j++){
                if (arr[k] > arr[j]){
                    k = j;//每次确定一个最小值   k是最小值的在下标
                }
            }
            swap(arr,i,k);//将找出的最小值放入无序数组的位置
        }
        return arr;
    }
    public static void swap(int[] arr,int i,int k){
        int t = arr[i];
        arr[i] = arr[k];
        arr[k] = t;
    }
}
