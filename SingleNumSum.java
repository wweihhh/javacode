package Day14;

/*
* 输出m的三次方的分解
*可理解为等差数列求和
**/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SingleNumSum{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = bf.readLine())!=null){
            long m = Integer.valueOf(s);
            long first = m*m-m+1;
            System.out.print(first);
            for (int i = 1; i < m; i++) {
                first += 2;
                System.out.print("+"+first);
            }
            System.out.println();
        }
        bf.close();
    }
}
