package Day16;
/*
* 输入： 2      人数
       30 40   成绩
       40      目标成绩
 输出： 1       与目标成绩匹配的人数
*/
import java.util.Scanner;

public class DestScore {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            int[] a = new int[N];
            for(int i = 0;i<a.length;i++){
                a[i] = sc.nextInt();
            }
            int dest = sc.nextInt();
            if(N == 0){
                return;
            }
            int count = 0;
            for(int i=0;i<a.length;i++){
                if(a[i] == dest){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
