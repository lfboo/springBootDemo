package com.example.demo.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author lvfeibiao
 * @date 2017/5/30
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", 9999));
        new Thread(new SendMsg(socket)).start();
        new Thread(new ReadMsg(socket)).start();
    }

}
