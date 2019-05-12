package com.bittech.chatroom.client.multi;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class WriteDataToServerThread extends Thread{
    private final Socket client;

    public WriteDataToServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            //控制台输入后，通过输出流将信息发给服务器端
            OutputStream out = this.client.getOutputStream();
            PrintStream printStream = new PrintStream(out);

            while (true){
                System.out.print("请输入>");
                String message = scanner.nextLine();
                printStream.println(message);
                if (message.equals("quit")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                this.client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
