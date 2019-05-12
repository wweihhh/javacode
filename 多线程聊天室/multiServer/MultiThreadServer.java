package com.bittech.chatroom.server.multi;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadServer {
    //支持100client
    private static  ExecutorService executor ;//=
//            Executors.newFixedThreadPool(10, new ThreadFactory() {
//                private final AtomicInteger id =
//                        new AtomicInteger(0);
//                @Override
//                public Thread newThread(Runnable r) {
//                    Thread thread = new Thread(r);
//                    thread.setName("Thread-client-Handler-" +
//                            id.getAndIncrement());
//                    return thread;
//                }
//            });

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        //解析参数
        int defaultPort = 8080;
        int defaultThread = 10;
        int port = defaultPort;
        int thread = defaultThread;
        for (String arg : args){
            if (arg.startsWith("--port=")){
                String portStr = arg.substring("--port=".length());
                try{
                    port = Integer.parseInt(portStr);
                }catch(NumberFormatException e){
                    port = defaultPort;
                }
            }
            if (arg.startsWith("--thread=")){
                String threadStr = arg.substring("--thread=".length());
                try{
                    thread = Integer.parseInt(threadStr);
                }catch(NumberFormatException e){
                    port = defaultThread;
                }
            }
        }
        try {
            executor = Executors.newFixedThreadPool(thread, new ThreadFactory() {
                private final AtomicInteger id =
                        new AtomicInteger(0);
                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread(r);
                    thread.setName("Thread-client-Handler-" +
                            id.getAndIncrement());
                    return thread;
                }
            });

            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务端启动"+serverSocket.getInetAddress()+":"+
            serverSocket.getLocalPort());

            while (true){
                final Socket client = serverSocket.accept();
                //使用线程池，采取固定线程池
                executor.execute(new ClientHandler(client));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
