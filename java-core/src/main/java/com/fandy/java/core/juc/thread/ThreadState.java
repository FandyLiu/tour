package com.fandy.java.core.juc.thread;

import java.util.concurrent.TimeUnit;

public class ThreadState {
    public static void main(String[] args) {
        Object o = new Object();
        Thread thread = new Thread(() -> {
            System.out.println("2 runnable " + Thread.currentThread().getState().name());

            synchronized (o) {
                try {
                    System.out.println(1);
                    o.wait();
                    System.out.println(2);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        System.out.println("1 new  " + thread.getState().name());
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (o) {
            System.out.println("4  waiting " + thread.getState().name());
            o.notify();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("4 2 waiting " + thread.getState().name());
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5  terminal " + thread.getState().name());

    }
}
