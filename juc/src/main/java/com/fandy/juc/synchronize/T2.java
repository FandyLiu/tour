package com.fandy.juc.synchronize;

public class T2 implements Runnable {

    private /*volatile*/ int count = 100;

    public /*synchronized*/ void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        T2 t = new T2();
        for(int i=0; i<100; i++) {
            new Thread(t, "THREAD" + i).start();
        }
    }

}