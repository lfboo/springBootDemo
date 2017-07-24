package com.example.demo.net;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author lvfeibiao
 * @date 2017/5/30
 */
public class ReadMsg implements Runnable {
    private DataInputStream dis;

    public ReadMsg(Socket socket) {
        try {
            this.dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String read() {
        try {
            return dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println(read());
        }
    }
}
