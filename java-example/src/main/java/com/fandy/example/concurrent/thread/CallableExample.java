package com.fandy.example.concurrent.thread;

import java.util.concurrent.Callable;

/**
 * @author: fandy
 * @date: 2019/2/13
 * @description:
 */
public class CallableExample implements Callable<String> {
    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ; i < 5 ; i++){
            sb.append(i);
        }
        sb.append("Callable");
        System.out.println("Callable 实现");
        return sb.toString();
    }



}
