package bitetech2;

public class SortOne {
    public static void main(String[] args) {
        int[] data=new int[]{3,5,6,7,1};
        bubbleSort(data);
        print(data);
        System.out.println();
        insertSort(data);
        print(data);
    }
    public static void bubbleSort(int [] data){
        int l=data.length;
        if(l<=1){
            return;
        }
        else{
            for(int i = 0;i<l;i++){
                boolean flag=false;
                for(int j = 0;j<l-i-1;j++){
                    if(data[j]>data[j+1]){
                        flag=true;
                        int temp=data[j];
                        data[j]=data[j+1];
                        data[j+1]=temp;
                    }
                }
                if(!flag){
                    System.out.println("已经有序");
                    break;
                }
            }

        }
    }
    public static void insertSort(int [] data){
        int n=data.length;
        if(n<=1){
            return;
        }else{
            //i是待排序部分的头
            for(int i = 1;i<n;i++){
                int value=data[i];
                int j = i-1;
                //j是已排序部分的尾
                for(;j>=0;j--){//j--让他依次往已排序的前面找  这是<尾的情况
                    if(data[j]>value){
                        data[j+1]=data[j];
                    } else{
                        break;
                    }
                }
                //找到插入的位置了
                data[j+1]=value;
            }
        }
    }
    public static void print(int [] data){
        for(int k:data){
            System.out.print(k+" ");
        }
    }
}
