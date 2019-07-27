package com.gitwh;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,2,3,1,7,88,0,99,5,8};
        quickSort3(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }


    public static void quickSort1(int[] arr,int left,int right){
        //当每个排序区间只剩下一个或是没有元素时 就不排序了
        if (left >= right){
            return;
        }
        //取得基准值最终放入位置的下标
        int q = partition1(arr,left,right);
        //递归过程再次处理每个小于区间和大于区间
        quickSort1(arr,left,q-1);
        quickSort1(arr,q+1,right);
    }
    private static int partition1(int[] arr, int left, int right) {
        int value = arr[left];
        int i = left + 1;
        int j = left;
        //让i变量去遍历整个数组，j变量位置是小于区间的而最后一个数
        while (i <= right){
            //若i位置的元素是小于基准值的数 就让小于区间增大
            if (arr[i] < value){
                swap(arr,++j,i++);
            }else {//否则i向后遍历寻找小于基准值的数，找到后交换位置
                i++;
            }
        }
        //直到i遍历完序列中所有数后，将小于区最后一个数与基准值进行交换
        swap(arr,left,j);
        return j;
    }


    public static void quickSort2(int[] arr,int left,int right){
        if (left >= right){
            return;
        }
        int q = partition2(arr,left,right);
        quickSort2(arr,left,q-1);
        quickSort2(arr,q+1,right);
    }
    private static int partition2(int[] arr, int left, int right) {
        int val = arr[left];
        int i = left + 1;
        int j = right;
        while (true){
            //随机选择一个数作为基准数
//            int index = (int) (Math.random()*(right-left+1)+1);
//            swap(arr,left,index);
            while (i <= right && arr[i] < val) {
                i++;
            }
            while (j >= left+1 && arr[j] > val){
              j--;
            }
            if (i > j){
                break;
            }
            swap(arr,i++,j--);
        }
        swap(arr,left,j);
        return j;
    }


    public static void quickSort3(int[] arr,int left,int right){
        if (left >= right){
            return;
        }
        int q[] = partition3(arr,left,right);
        quickSort3(arr,left,q[0]-1);
        quickSort3(arr,q[0]+1,right);
    }
    private static int[] partition3(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right + 1;
        int l = left;
        int index = (int) (Math.random()*(right-left+1)+left);
        swap(arr,right,index);
        int val = arr[right];
        while (l < more){
            if (arr[l] < val){
                swap(arr,++less,l++);
            }else if (arr[l] > val){
                swap(arr,--more,l);
            }else {
                l++;
            }
        }
        //返等于区
        return new int[]{less+1,more-1};
    }


    private static void swap(int[] arr, int i, int j) {
        if(i != j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }
    }
}

