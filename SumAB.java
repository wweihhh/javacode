package Day15;

/*不用加号求和
* 异或相当于加
* 与相等于进位*/
import java.util.Scanner;

public class SumAB {
    public  static int addAB(int A, int B) {
        // write code here
        if(B == 0){
            return A;
        }
        int sum = A^B;
        int cin = (A&B)<<1;
        return addAB(sum,cin);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int sum = sc.nextInt();
            int cin = sc.nextInt();
            System.out.println(addAB(sum,cin));
        }
    }
}
