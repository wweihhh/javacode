package bitetech2;

import com.sun.javafx.collections.SortHelper;

public class SortTwo {
    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 6, 7, 1, 4};
//        bubbleSort(array);
//        insertSort(array);
//        selectionSort(array);
//        binarySort(array);
//        shellSort(array);
//        print(array);

        mergeSort(array);
        print(array);

    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        } else {
            for (int i = 0; i < n; i++) {
                boolean flag = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (array[j] < array[j + 1]) {
                        flag = true;
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
                if (!flag) {
                    System.out.println("---已经有序---");
                    break;
                }
            }
        }
    }

    public static void insertSort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        } else {
            for (int i = 1; i < n; i++) {
                int val = array[i];
                int j = i - 1;
                for (; j >= 0; j--) {
                    if (array[j] > val) {
                        array[j + 1] = array[j];
                    } else {
                        break;
                    }
                }
                array[j + 1] = val;
            }
        }


    }

    public static void selectionSort(int [] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        } else {
            for (int i = 0; i < n-1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n ; j++) {
                    if (array[j] < array[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }

        }
    }

    public static void binarySort(int [] array){
        int n = array.length;
        if(n <= 1){
            return;
        }else{
            for(int i = 1;i < n;i++){
                int val = array[i];
                int p = 0;
                int q = i-1;
                int j = i-1;
                while(p <= q){
                    int mid = p+(q-p)/2;
                    if(array[mid] < val){
                        p = mid + 1;
                    }else{
                        q = mid - 1;
                    }
                }
                //已经知道要插入的位置 需要走到这个位置
                //以及将比他大的往后搬移
                for(;j >= q+1;j--){
                    array[j+1] = array[j];
                }
                array[j+1] = val;
            }
        }
    }

    public static void shellSort(int [] array){
        int n = array.length;
        if (n <= 1){
            return;
        }else{
            int gap = n/2;
            while (gap >= 1){
                for(int i = gap;i < n;i++){
                    int val = array[i];
                    int j = i-gap;
                    for(;j >= 0;j-=gap){
                        if(array[j] > val){
                            array[j+gap] = array[j];
                        }else{
                            break;
                        }
                    }
                    array[j+gap] = val;
                }
                gap = gap/2;
            }

        }

    }

    public static void mergeSort(int [] array){
        int n = array.length;
        if(n <= 1){
            return;
        }
        int mid  = n/2;
        mergeInternal(array,0,n-1);
    }

    private static void mergeInternal(int [] array,int low,int high){
        int mid = low+(high-low)/2;

        if(low >= high){
            return;
        }
        //分
        mergeInternal(array,low,mid);
        mergeInternal(array,mid+1,high);
        //合并
        merge(array,low,mid,high);
    }
    private static void merge(int [] array,int p,int s,int q){
        int i = p;
        int j = s + 1;
        int[] temp = new int[q-p+1];
        int k = 0;
        while(i <= s && j <= q){
            if(array[i]<=array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
            }
        }
        //如果第2个有序数组已经空了，让此时的第一个数组中剩余的元素从 i到 s接在temp后面
        int star = i;//假设第一个数组还有剩余
        int end = s;
        if(j <= q){  //这是第一个数组空了的情况
            star = j;
            end = q;
        }
        while(star <= end){
            temp[k++] = array[star++];  //让剩余元素接在temp后面
        }

        //将临时空间数组拷贝给原数组
        for(i = 0;i < q-p+1;i++){
            array[p+i] = temp[i];
        }
    }




    public static void print(int[] array) {
        for (int k : array) {
            System.out.print(k + " ");
        }
    }
}
