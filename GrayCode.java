package Day12;

public class GrayCode {
    public String[] getGray(int n) {
       if (n == 1){
            String[] result = new String[2];
            result[0] = "0";
            result[1] = "1";
            return result;
        }else {
            String[] s = getGray(n-1);
            int l = s.length;
            String[] result = new String[l*2];
            for (int i = 0; i < l; i++) {
                result[i] = "0"+s[i];
            }
            for (int i = 0; i < l; i++) {
                result[2*l-1-i] = "1"+s[i];
            }
            return result;
        }
    }
}
