package com.fandy.java.core.juc.thread;

/**
 * @author: fandy
 * @date: 2019/2/13
 * @description:
 */
public class RunnableExample implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable 实现");
    }
}
