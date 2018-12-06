 public class Day3{
     public static void main(String[] args){
//         int i=0;
//         int j=0;
//         int s=0;
//         for(i=1;i<=9;i++){
//             for(j=1;j<=i;j++) {
//                 s=i*j;
//                 System.out.print(i+"*"+j+"="+s+"\t");
//             }
//             System.out.print("\n");
//         }
//     }
// }



    // int i=0;
    // int j=0;
    // int k=0;
    // for(i=0;i<10;i++){
    //     for(j=0;j<10-i;j++){
    //         System.out.print(" ");
    //     }
    //     for(k=0;k<i;k++){
    //         System.out.print("* ");
    //     }
    //     System.out.println();
    // }



//     System.out.println(sum(100));
// }
//     public static int sum(int num){
//         if(num==1){
//             return 1;
//         }else{
//             return num+sum(num-1);
//         }
System.out.println(fac(20));
}
    public static long fac(int num){
        if(num<=1){
            return 1;
        }else{
            return num*fac(num-1);
    }
}
}