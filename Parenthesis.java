package Day03;

import java.util.Stack;

public class Parenthesis {

    public boolean chkParenthesis(String A,int n){
        if (A == null || n == 0) {
            return true;
        }else{
           char[] c =  A.toCharArray();
           Stack<Character> stack = new Stack<>();
           for (int i = 0;i < n;i++){
               if (c[i] == '(' || c[i] == '{' || c[i] == '[' || c[i] == '<'){
                   stack.push(c[i]);
               }else if (c[i] == ')'|| c[i] == '}' || c[i] == ']' || c[i] == '>'){
                   if (!stack.isEmpty()){
                       if (!isCouple(stack.pop(),c[i])){
                           return false;
                       }
                   }else {
                       return false;
                   }

               }
           }
           return stack.isEmpty();
        }

    }

    public boolean isCouple(char a,char b){
        if (a == '(' && b == ')'){
            return true;
        }
        if (a == '{' && b == '}'){
            return true;
        }
        if (a == '[' && b == ']'){
            return true;
        }
        if (a == '<' && b == '>'){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
