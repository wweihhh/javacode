package Day09;
/*
* 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2*/

import java.util.Scanner;

public class ZeroNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while (n>=5){
            count += n/5;
            n/=5;
        }
        System.out.println(count);
    }
}
