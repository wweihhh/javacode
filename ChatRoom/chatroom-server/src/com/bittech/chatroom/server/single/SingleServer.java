package com.bittech.chatroom.server.single;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleServer {
    public static void main(String[] args) {
        //聊天室服务器端
        //1.创建ServerSocket
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("服务端启动 "+
                    serverSocket.getInetAddress()+":"
                    +serverSocket.getLocalPort());

            //2.等待客户端连接,阻塞操作，直到客户端连接服务端才会往下执行
           final Socket socket = serverSocket.accept();
            System.out.println("客户端连接 "+
            socket.getRemoteSocketAddress()+":"+socket.getPort());

            //3.服务端可以进行接收发送数据
            InputStream in = socket.getInputStream();
            Scanner scanner = new Scanner(in);
            String message = scanner.next();
            System.out.println("接收到客户端发送的数据 "+message);

            OutputStream out = socket.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            printStream.println("你好客户端");
            printStream.flush();

        } catch (IOException e) {
            System.out.println("服务端发生异常 "+e.getMessage());
        }
    }
}
