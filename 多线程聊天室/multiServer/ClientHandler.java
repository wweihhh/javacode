package com.bittech.chatroom.server.multi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ClientHandler implements Runnable{

    //将注册的成员保存在Map中，用static以及final修饰，因为成员是共享信息
    private static final Map<String,Socket> SOCKET_MAP =
            new ConcurrentHashMap<>();


    private final Socket client;
    //当前客户端注册的名称
    private String currentname;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        //TODO 业务实现
        try {
            InputStream in = this.client.getInputStream();
            Scanner scanner = new Scanner(in);
            while (true){
                String line = scanner.nextLine();
                if (line.startsWith("register")){
                    //register注册
                    String[] segments = line.split(":");
                    if (segments.length == 2 && segments[0].equals("register")){
                        String name = segments[1];
                        register(name,this.client);

                    }
                    continue;
                }
                if (line.startsWith("group")){
                    //群聊
                    String[] segments = line.split(":");
                    if (segments.length == 2 && segments[0].equals("group")){
                        String message = segments[1];
                        groupChat(message);

                    }
                    continue;
                }
                if (line.startsWith("private")){
                    //私聊
                    String[] segments = line.split(":");
                    if (segments.length == 3 && segments[0].equals("private")){
                        String name = segments[1];
                        String message = segments[2];
                        privateChat(name,message);
                    }
                    continue;
                }
                if (line.startsWith("quit")){
                    //退出流程
                    quit();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //注册
    private void register(String name,Socket client){
        //注册
        SOCKET_MAP.put(name,this.client);
        //优化
        this.currentname = name;
        this.sendMessage(this.client,"恭喜"+name+"注册成功");
        printOnlineClient();
    }
    //打印注册信息
    private void printOnlineClient(){
        System.out.println("当前在线客户端有： "+
        SOCKET_MAP.size()+" 名称列表如下：");
        //keySet（）将Map中所有key不重复的打印出来
        for (String key:SOCKET_MAP.keySet()) {
            System.out.println(key);
        }
    }
    //发送注册成功信息
    private void sendMessage(Socket socket,String message)  {
        try {
            //获得服务端Socket对象的输出流，发送注册信息给客户端（输入流读取这个数据）
            OutputStream out = socket.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            printStream.println(message);
            printStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void groupChat(String message){
        //群聊 发送消息给当前在线的客户端
        //谁 发 消息
        Set<Map.Entry<String,Socket>> entrySet = SOCKET_MAP.entrySet();
//        String currentName = "";
//        //遍历集合，确定发送消息人的名字
//        for (Map.Entry<String,Socket> entry:entrySet){
//            String key = entry.getKey();
//            Socket socket = entry.getValue();
//            if(socket == this.client){
//                //如果是当前对象，就确定了当前发消息的人（就把当前对象的名字设置为Key（name））
//                currentName = key;
//            }
//        }
        for (Map.Entry<String,Socket> entry:SOCKET_MAP.entrySet()){
            Socket socket = entry.getValue();
            if(socket != this.client){
                //如果不是当前对象就让他群发消息
               this.sendMessage(socket,this.currentname+"说>"+message);

            }
        }

    }


    private void privateChat(String name,String message){
        //私聊
        //谁 说 什么
//        Set<Map.Entry<String,Socket>> entrySet = SOCKET_MAP.entrySet();
//        String currentName = "";
//        //遍历，获得发消息的人的名字
//        for (Map.Entry<String,Socket> entry:entrySet){
//            String key = entry.getKey();
//            Socket socket = entry.getValue();
//            if(socket == this.client){
//                currentName = key;
//            }
//        }
        //传入名字，获得socket对象，如果对象存在，就发消息
        Socket socket = SOCKET_MAP.get(name);
        if (socket != null){
            this.sendMessage(socket,this.currentname+"说>"+message);
        }
    }

    private void quit(){
        //退出
        Iterator<Map.Entry<String,Socket>> iterator = SOCKET_MAP.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String,Socket> entry = iterator.next();
                if (entry.getValue() == this.client){
                    System.out.println(entry.getKey()+"退出");
                    iterator.remove();
                    break;
                }
            }
        printOnlineClient();
    }
}
