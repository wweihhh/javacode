package bitetech2;

public class qquickSort {
    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 6, 7, 1, 4 ,5 , 6};
//        quickSort(array);
        qquickSort(array,0,array.length - 1);
        print(array);
    }


    public static void quickSort(int[] array){
        int n = array.length;
        if(n <= 1){
            return;
        }
        quickSortInteral(array,0,n-1);
    }
    private static void quickSortInteral(int [] array,int l,int r){
        int n = array.length;
        if(l >= r){
            return;
        }
//        int q = partition(array,l,r);
        int q = ppartition(array,l,r);
        quickSortInteral(array,l,q-1);
        quickSortInteral(array,q+1,r);
    }
    private static int partition(int[] array,int l,int r) {
        int val = array[l];
        int i = l;
        int j = l + 1;
        for (; j <= r; j++) {
            if (array[j] < val) {
                swap(array,i + 1,j);
                i++;
            }
        }
        swap(array, l, i);
        return i;
    }
    private static int ppartition(int[] array,int l,int r){
        int index = (int)(Math.random()*(r-l+1)+l);
        swap(array,l,index);
        int val = array[l];
        int i = l + 1;
        int j = r;
        while(true){
            while (i <= r && array[i] < val){
                i++;
            }
            while (j > l && array[j] > val){
                j--;
            }
            if(i > j){
                break;
            }
            swap(array,i++,j--);
        }
        swap(array,l,j);
        return j;
    }
    private static void swap(int [] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
//        if(i != j){
//            array[i] ^= array[j];
//            array[j] ^= array[i];
//            array[i] ^= array[j];
//        }


    }

    public static void qquickSort(int[] array,int l,int r){
        if(array == null || array.length < 2){
            return;
        }
        if(l >= r){
            return;
        }
        int index = (int)(Math.random()*(r - l + 1)+l);
        swap(array,index,l);
        int val = array[l];
        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        while(i < gt){
            if(array[i] < val){
                swap(array,i,lt + 1);
                lt++;
                i++;
            }
            else if(array[i] > val){
                swap(array,i,gt - 1);
                gt--;
            }
            else{
                i++;
            }
        }
        swap(array,l,lt);
        qquickSort(array,l,lt - 1);//因为此时已经交换了l和lt的值  小于区变为 l-lt-1
        qquickSort(array,gt,r);

    }


    public static void print(int[] array) {
        for (int k : array) {
            System.out.print(k + " ");
        }
    }
}
