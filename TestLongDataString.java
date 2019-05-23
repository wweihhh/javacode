package Day03;

import Day02.TestBottle;

public class TestLongDataString {
    public StringBuffer longData(String str,int n){
        char[] c = str.toCharArray();
        StringBuffer string1 = new StringBuffer("");
        StringBuffer result = new StringBuffer("");
        for (int i = 0;i < c.length;i++){
            if (result.length() <= string1.length()){
                result = string1;
            }
           if (c[i] >= '0' && c[i]<= '9'){
               string1.append(c[i]);

           }else {
               string1 = new StringBuffer("");
           }
        }
        return result;
    }
    public static void main(String[] args) {
        TestLongDataString testLongDataString = new TestLongDataString();
        String str = "ae1234908i6u34567";
        System.out.println(testLongDataString.longData(str,str.length()));;
    }
}
