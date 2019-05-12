package com.bittech.chatroom.client.multi;

import java.io.IOException;
import java.net.Socket;

public class MultiThreadClient {
    public static void main(String[] args) {

        String defaultHost = "127.0.0.1";
        int defaultPort = 8080;
        String host = defaultHost;
        int port = defaultPort;
        for (String arg : args){
            if (arg.startsWith("--port=")){
                try{
                    String portStr = arg.substring("--port=".length());
                    port = Integer.parseInt(portStr);
                }catch (NumberFormatException e){
                    port = defaultPort;
                }
            }
            if (arg.startsWith("--host=")){

                    host = arg.substring("--host=".length());
                    //java校验IPv4是否合法
            }
        }

        try {
            Socket socket = new Socket(host,port);

            Thread read = new ReadDataFromServerThread(socket);
            read.setName("Threah-Client-Read");
            read.start();

            Thread write = new WriteDataToServerThread(socket);
            write.setName("Thread-Client-Write");
            write.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
