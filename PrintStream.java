package www.bit.java.io;

import java.io.*;
//自己实现的打印流
class PrintUtil{
    private OutputStream out;

    public PrintUtil(OutputStream out){
        this.out = out;
    }

    public void print(String str)  {
        try {
            //实际上调用输出流write方法
            this.out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(String str){
        this.print(str + "\r\n");
    }

    public void print(int data){
        this.print(String.valueOf(data));
    }
    public void println(int data){
        this.print(data+"\r\n");
    }
    public void print(double data){
        this.print(String.valueOf(data));
    }
    public void println(double data){
        this.print(data+"\r\n");
    }
    public void myclose() throws IOException {
        this.out.close();
    }
}
public class PrintStream {
    public static void main(String[] args) throws Exception {
        //取得File对象
        File file = new File("C:\\Users\\xptyxx20170501A\\Desktop\\TestIo.txt");
        //取得输出流
        PrintUtil printuntil = new PrintUtil(new FileOutputStream(file));
        //数据输出
        printuntil.print(10);
        printuntil.print("haha");
        printuntil.print(12.4);
        //关闭流
        printuntil.myclose();
    }
}
