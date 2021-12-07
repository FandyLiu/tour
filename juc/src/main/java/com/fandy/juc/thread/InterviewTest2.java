package com.fandy.juc.thread;

/**
 * 如何保证 t1, t2 交替执行
 */
public class InterviewTest2 {
    public static void main(String[] args) {
        final Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                while (true) {
                    System.out.println("t1");
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                while (true) {
                    System.out.println("t2");
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        });

        t1.start();
        t2.start();
    }

}
