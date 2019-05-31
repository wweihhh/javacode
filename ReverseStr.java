package Day09;
/*
* 现在有一个字符串，你要对这个字符串进行 n 次操作，每次操作给出两个数字：(p, l) 表示当前字符串中从下
标为 p
的字符开始的长度为 l 的一个子串。你要将这个子串左右翻转后插在这个子串原来位置的正后方，求最后得到
的字符串是什么。*/
import java.util.Scanner;

public class ReverseStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            int n = sc.nextInt();
            System.out.println(rever(str,n,sc));
        }
    }

    private static String rever(String str, int n, Scanner sc) {
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();
            StringBuilder string = new StringBuilder(str);
            String str1 = str.substring(p,p+l);
            StringBuilder s = new StringBuilder(str1);
            s.reverse();
            StringBuilder sb = string.insert(p+l,s);
            str = sb.toString();
        }
        return str;
    }
}
