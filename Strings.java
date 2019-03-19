//String类扩展功能实现
public class Strings{

    
     /**
     * 重复某个字符
     * 
     * 例如： 
     * 'a' 5   => "aaaaa"  
     * 'a' -1  => ""
     * 
     * @param c     被重复的字符
     * @param count 重复的数目，如果小于等于0则返回""
     * @return 重复字符字符串
     */
    public static String repeat(char c, int count) {
       //TODO
       if(count<=0){
       return "";
       }
       else{
           char[] x=new char[count];
           for(int i=0;i<count;i++){
             x[i]=c;
           }
           String str1=new String(x);
           return str1;
       }
    }
    
    
     /**
     * 将已有字符串填充为规定长度，如果已有字符串大于等于这个长度则返回这个字符串
     * 字符填充于字符串前
     *
     * 例如： 
     * "abc" 'A' 5  => "AAabc"
     * "abc" 'A' 2  => "abc"
     *
     * @param str        被填充的字符串
     * @param filledChar 填充的字符
     * @param len        填充长度
     * @return 填充后的字符串
     */
    public static String fillBefore(String str, char filledChar, int len) {
       //TODO
       int i=str.length();
       if(i>=len){
           return str;
       }
       else{
           char[] y=new char[len-i];
           for(int j=0;j<len-i;j++){
               y[j]=filledChar;
           }
           String str2=new String(y);
           str=str2+str;
           return str;
       }
      
    }
    
    /**
     * 将已有字符串填充为规定长度，如果已有字符串大于等于这个长度则返回这个字符串<br>
     * 字符填充于字符串后
     * 例如： 
     * "abc" 'A' 5  => "abcAA"
     * "abc" 'A' 3  => "abc"
     *
     * @param str        被填充的字符串
     * @param filledChar 填充的字符
     * @param len        填充长度
     * @return 填充后的字符串
     */
    public static String fillAfter(String str, char filledChar, int len) {
        //TODO
        int i=str.length();
       if(i>=len){
           return str;
       }
       else{
           char[] y=new char[len-i];
           for(int j=0;j<len-i;j++){
               y[j]=filledChar;
           }
           String str2=new String(y);
           str=str+str2;
           return str;
       }
    }

    /**
     * 移除字符串中所有给定字符串
     * 例：removeAll("aa-bb-cc-dd", "-") => aabbccdd
     *
     * @param str         字符串
     * @param strToRemove 被移除的字符串
     * @return 移除后的字符串
     */
    public static String removeAll(String str, String strToRemove) {
        //TODO
        
        if(str==null){
            return "";
        }
        else{
            String str1=str.toString();
           String str2=str1.replaceAll(strToRemove.toString()," ");
            return str2;
        }
        
    }
    
    /**
     * 反转字符串
     * 例如：abcd => dcba
     *
     * @param str 被反转的字符串
     * @return 反转后的字符串
     */
    public static String reverse(String str) {
        //TODO
        char []data=str.toCharArray();
        int left=0;
        int right=str.length()-1;
        char t;
        while(left<right){
            t=data[left];
            data[left]=data[right];
            data[right]=t;
            left++;
            right--;
        }
        String str1=new String(data);
        return str1;
    }
    public static void main(String [] args){
        String result1=repeat('a',3);
        System.out.println(result1);
        String result2=fillBefore("abcd",'D',6);
        System.out.println(result2);
        String result3=fillAfter("abcd",'A',6);
        System.out.println(result3);
        String result4=removeAll("a-b-c-d","-");
        System.out.println(result4);
        String result5=reverse("hello");
        System.out.println(result5);
    }
   
}
