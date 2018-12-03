//Java数组章节练习题
public class ArrayUtils{

    //1.计算数组中最大值
    public static int arrayMaxElement(int[] data){
         int temp=data[0];
         for(int i=0;i<data.length;i++){
             if(data[i]>temp){
                 temp=data[i];
             }
         }
        return temp;
    }
    
    //2.计算数组中最小值
    public static int arrayMinElement(int[] data){
        int z=data[0];
        for(int i=1;i<data.length;i++){
             if(z>data[i]){
                 z=data[i];
             }
         }
        return z;
    }
    
    
    //3.计算数组值之和
    public static int arrayElementSum(int[] data){
        int s=0;
        for(int i=0;i<data.length;i++){
            s+=data[i];
        }
        return s;
    }
    
    //4.数组拼接
    // A {1,3,5,7,9} B {2,4,6,8,10} -> {1,3,5,7,9,2,4,6,8,10}
    public static int[] arrayJoin(int[] a, int[] b){
        int len=a.length+b.length;
        int [] c=new int [len];
        for(int i=0;i<a.length;i++){
            c[i]=a[i];
        }
        for(int j=a.length;j<len;j++){
            c[j]=b[j-a.length];
        }
        return c;
    }

    //5.数组截取
    //[start, end)
    // A {1,3,5,7,9} ->(A,1,3) > {3,5}
    public static int[] arraySub(int[] data, int start , int end){
        for(int i=start;i<end;i++){
            System.out.print(data[i]+"、");
        }
        return data;
    }
    
    //6.数组打印
    public static void printArray(int[] data){
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+"、");
        }
    }
    
    //7.数组反转
    // 比如：[1,2,3,4] => [4,3,2,1]
    public static void printReversal(int[] data){
        int left=0;
        int right=data.length-1;
        int ret=0;
        for(int i=0;i<data.length;i++){
            while(left<right){
                ret=data[left];
                data[left]=data[right];
                data[right]=ret;
                left++;
                right--;
            }
        }
        for(int j=0;j<data.length;j++){
             System.out.print(data[j]+"、");

        }
    }
    
    public static void main(String[] args){
        //TODO 测试     
        int [] data=new int []{1,2,3,4,5,6,7,8,12,34} ;
        int [] A=new int []{1,3,5,7,9};
        int [] B=new int []{2,4,6,8,10};
       int max= arrayMaxElement(data);
       System.out.println("max="+max);
       int min=arrayMinElement(data);
       System.out.println("min="+min);
       int sum=arrayElementSum(data);
       System.out.println("sum="+sum);
       int []newArray=arrayJoin(A,B);
       printArray(newArray);
       System.out.println();
       arraySub(data,2,5);
       System.out.println();
       printReversal(data);
    }
}