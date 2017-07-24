package com.example.demo.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lvfeibiao
 * @date 2017/5/30
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            Socket accept = serverSocket.accept();
            new Thread(new ReadMsg(accept)).start();
            new Thread(new SendMsg(accept)).start();
        }
    }

}
