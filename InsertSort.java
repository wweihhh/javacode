package com.gitwh;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {4,2,3,1,7,88,0,6};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static int[] insertSort(int[] arr){
        for (int i = 1;i < arr.length;i++){
            int temp = arr[i];
            int k = i;
            for (int j = i-1;(j>=0)&&(arr[j] > temp);j--){
                arr[j+1] = arr[j];
                k = j;
            }
            arr[k] = temp;
        }
        return arr;
    }
}
