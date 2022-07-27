package com.fandy.java.core.juc.thread;

import java.util.concurrent.TimeUnit;

public class WhatIsThread {

    static class T1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName());
            }
            super.run();
        }
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.start();
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName());
        }
    }


}
