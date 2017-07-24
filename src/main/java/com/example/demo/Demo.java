package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author lvfeibiao
 * @date 2017/7/7
 */
public class Demo {

    public static void main(String[] args) {
        final Exchanger<List<Integer>> exchanger = new Exchanger<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Integer> l = new ArrayList<>();
                l.add(1);
                l.add(2);

                try{
                    l = exchanger.exchange(l);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Thread1" + l);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Integer> l = new ArrayList<>();
                l.add(3);
                l.add(4);
                l.add(5);

                try{
                    l = exchanger.exchange(l);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Thread2" +l);
            }
        }).start();
    }

}
