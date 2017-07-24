package com.example.demo.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author lvfeibiao
 * @date 2017/5/30
 */
public class SendMsg implements Runnable {
    private DataOutputStream dos;

    private BufferedReader br;

    private SendMsg() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public SendMsg(Socket socket) {
        this();
        try {
            this.dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected synchronized String getMsg() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void send(String message) {
        try {
            dos.writeUTF(message);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            send(getMsg());
        }
    }
}
