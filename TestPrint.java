package com.bittech;

/*
1.两个线程  一个打印1~52  一个打印A~Z
打印顺序：12A34B.....5152Z
 */
class Print{

    private boolean flag = true;
    private int count = 1;
    public synchronized void printNum(){
        if (flag == false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(2*count-1);
        System.out.print(2*count);
        flag = false;
        notify();
    }

    public synchronized void printChar(){
        if (flag == true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print((char)('A'+count-1));
        flag = true;
        count++;
        notify();
    }

}

public class TestPrint {
    public static void main(String[] args) {
        Print print = new Print();

        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                print.printNum();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                print.printChar();
            }
        }).start();
    }
}
