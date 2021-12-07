package com.fandy.juc.thread;

import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Wait_Notify {
    public static void main(String[] args) {
        final Object lock = new  Object();
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("1 start");
                    lock.wait();
                    System.out.println("1 end");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(1);
                    System.out.println("2 start");
                    lock.notify();
                    System.out.println("2 end");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        thread2.start();
    }
}
