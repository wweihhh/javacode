package com.bittech.java;

//topK
public class Finder {
    public static void main(String[] args) {
        Finder finder = new Finder();
        int[] arr = new int[]{1,4,2,6,5};
        finder.partation(arr,0,arr.length - 1);
        int r = finder.findKth(arr,arr.length,3);
        System.out.println(r);
    }
    public int findKth(int[] arr,int n,int K){
        if(arr == null || n == 0 || n < K){
            throw new IllegalArgumentException("参数不合法");
        }
        return findKth(arr,0,n-1,K);
    }
    public int findKth(int[] arr,int left,int right,int K){
        int ret = partation(arr,left,right);
        if(ret == K -1) {
            return arr[ret];
        }else if (ret > K-1){
           return findKth(arr,left,ret-1,K);
        }else {
           return findKth(arr,ret+1,right,K);
        }

    }
    public int partation(int[] arr,int left,int right){
        int temp = arr[right];
        int more = left - 1;
        int less = right + 1;
        while (left < less){
            if (arr[left] > temp){
                swap(arr,++more,left++);
            }else if (arr[left] < temp){
                swap(arr,--less,left);
            }else{
                left++;
            }
        }
        return more + 1;
    }
    public void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
