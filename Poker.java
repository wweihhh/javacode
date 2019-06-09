package Day16;

import java.util.Scanner;
public class Poker{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int group = sc.nextInt();
            while(group > 0){
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] res = new int[2*n];
                for(int i = 0;i<2*n;i++){
                    int t = i+1;
                    for(int j = 0;j<k;j++){
                        if(t<=n){
                            t = 2*t-1;
                        }else{
                            t = 2*(t-n);
                        }
                    }
                    res[t-1]=sc.nextInt();
                }
                if(res.length>0){
                    System.out.print(res[0]);
                }
                for(int i=1;i<2*n;i++){
                    System.out.print(" "+res[i]);
                }
                System.out.println();
            }
        }
    }
}
