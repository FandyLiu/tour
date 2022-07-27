package com.fandy.java.core.juc.thread;

public class ThreadCreate {

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRunnable");
        }
    }
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread");
        }
    }



    public static void main(String[] args) {

        Thread thread1 = new Thread(new MyRunnable());
        thread1.start();

        MyThread myThread = new MyThread();
        myThread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("666");
            }
        }).start();

        Thread thread = new Thread(() -> {
            System.out.println("666");
        });
        thread.start();
    }


}
