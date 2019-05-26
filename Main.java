package Day05;


import sun.awt.AWTAccessor;

import java.util.Scanner;

/*输入n个物品  和 物品的体积
输出体积可以组成40的所有组合
* */
public class Main {
    static int[] weight;
    static int N;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            N = sc.nextInt();
            weight = new int[N+1];

            for (int i = 1; i <= N; i++) {
                weight[i] = sc.nextInt();
            }
            count(40,N);
            System.out.println(count);

        }
    }

    public static void count(int s, int n) {
        if (s == 0){
            ++count;
            return;
        }
        if (s < 0 || (s > 0 && n < 1) )
            return;


        count(s - weight[n],n-1);
        count(s,n-1);
    }
}
