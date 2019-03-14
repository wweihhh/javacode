
public class Fibonacci{
    public static int Fib(int i){
    if(i<=2){
        return 1;
    }else{
        return Fib(i-1)+Fib(i-2);
    }
}
      public static void main(String [] args)throws Exception{
        int x=(int) System.in.read();
        for(int i=1;i<=x;i++){
            System.out.print(Fib(i)+"、");
        }
      }
}