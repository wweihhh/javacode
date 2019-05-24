package Day04;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.Scanner;

public class RemovePublicStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            char[] c = scanner.nextLine().toCharArray();
            String str = scanner.nextLine();
            for (int i = 0;i < c.length;i++){
                if (!str.contains(String.valueOf(c[i]))){
                    System.out.print(c[i]);
                }
            }
        }
    }
}
