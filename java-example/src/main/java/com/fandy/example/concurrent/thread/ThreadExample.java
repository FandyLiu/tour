package com.fandy.example.concurrent.thread;

/**
 * @author: fandy
 * @date: 2019/2/13
 * @description:
 */
public class ThreadExample extends Thread {
    @Override
    public void run() {
        System.out.println("继承 Thread");
    }
}
