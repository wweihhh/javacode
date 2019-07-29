package com.gitwh;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4,2,3,1,7,88,0,6};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void mergeSort(int [] arr){
        int l = arr.length;
        if (l<=1){
            return;
        }
        mergeSortInternal(arr,0,l-1);
    }

    private static void mergeSortInternal(int[] arr, int low, int high) {
        int mid = low + (high - low)/2;
        if (low >= high){
            return;
        }
        //分区
        mergeSortInternal(arr,low,mid);
        mergeSortInternal(arr,mid+1,high);
        //合并
        merge(arr,low,mid,high);
    }

    private static void merge(int[] arr, int p, int s, int q) {
        int i = p;
        int j = s + 1;
        int[] temp = new int[q+1];
        int k = 0;
        while (i <= s && j <= q){
            if (arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }

//        int start = i;
//        int end = s;
//        if (j <= q){
//            start = j;
//            end = q;
//        }
//        while (start <= end){
//            temp[k++] = arr[start++];
//        }
        //如果i至s区间还有元素，但j至q区间通过比较已经没有元素 将剩余元素接在数组后面
        while(i <= s){
            temp[k++] = arr[i++];
        }
        //如果j至q区间还有元素，但i至s区间通过比较已经没有元素
        while (j <= q){
            temp[k++] = arr[j++];
        }
        //将临时数组的元素拷贝到原来数组
        for (int t = 0;t < q-p+1;t++){
            arr[p+t] = temp[t];
        }
    }
}
