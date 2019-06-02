package Day10;

import java.util.Scanner;

public class FibonacciNumber{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int a = 0,b = 1,c = 1;
        while (sc.hasNext()){
            n = sc.nextInt();
            while (c < n){
                a = b;
                b = c;
                c = a + b;
            }
            int res1 = n-b;
            int res2 = c-n;
            System.out.println(res1<res2?res1:res2);
        }
    }
}
