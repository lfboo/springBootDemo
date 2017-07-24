package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

/**
 * @author lvfeibiao
 * @date 2017/5/29
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException, IllegalAccessException, InstantiationException {
        InetAddressDemo.class.newInstance().url();
    }

    private void inetAddress() {
        InetAddress address = null;
        try {
            address = InetAddress.getByName("www.baidu.com");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());
        System.out.println(address.getCanonicalHostName());
    }

    private void inetSocketAddress() {
        InetSocketAddress socketAddress = new InetSocketAddress("cn.bing.com",8080);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress.getPort());
    }

    private void url() {
        try {
            URL url = new URL("http://www.baidu.com/index.php");
            System.out.println("protocol:" + url.getProtocol());
            System.out.println("port:" + url.getPort());
            System.out.println("path:" + url.getPath());
            System.out.println("host:" + url.getHost());
            InputStream inputStream = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String msg = null;
            while((msg = reader.readLine()) != null) {
                System.out.println(msg + "\n");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
