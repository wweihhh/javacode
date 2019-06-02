package bin_tree.bin_search_tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        char[] c = N.toCharArray();
        List<Integer> list = new LinkedList<>();
        for (int i = 0;i < 10;i++){
            list.add(0);
        }
        for (int j = 0;j < c.length;j++){
            list.set(c[j]-'0',list.get(c[j]-'0')+1);
        }
        for (int k = 0; k < list.size(); k++) {
            if (list.get(k)>0){
                System.out.println(k+":"+list.get(k));
            }
        }

    }
}
