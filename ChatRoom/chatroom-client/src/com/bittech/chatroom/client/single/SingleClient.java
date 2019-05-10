package com.bittech.chatroom.client.single;

import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SingleClient {
    public static void main(String[] args) {
        //客户端
        String host = "127.0.0.1";//本机地址
        int port = 8080;
        try {
            //1.创建客户端的Socket和服务器建立连接
            Socket socket = new Socket(host,port);
            //客户端进行接收发送数据
            OutputStream out = socket.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            printStream.println("服务器我来了");
            printStream.flush();

            InputStream in = socket.getInputStream();
            Scanner scanner = new Scanner(in);
            String message = scanner.next();
            System.out.println("从服务端接收数据 "+message);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
