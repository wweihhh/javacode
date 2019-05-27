package Day06;
/*
* 输出数组出现次数最多并且超过半数的数*/

import java.util.Scanner;

public class ArrayNumberTimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String[] s = str.split(" ");
            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length ; i++) {
                arr[i] = Integer.valueOf(s[i]);
            }
            int num = arr[0];
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == num){
                    count++;
                }else if (count > 0){
                    count--;
                }else {
                    num = arr[j];
                }
            }
            System.out.println(num);
        }
    }
}
