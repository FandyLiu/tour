package com.fandy.java.core.juc.synchronize;

public class T1 {

    private static int count;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    count++;
                }
            });
            thread.start();
//            thread.join();
        }
        
        System.out.println(count);
    }

}
