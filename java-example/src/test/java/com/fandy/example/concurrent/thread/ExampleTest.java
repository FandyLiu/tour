package com.fandy.example.concurrent.thread;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: fandy
 * @date: 2019/2/13
 * @description:
 */
public class ExampleTest {

    @Test
    public void runnableTest() {
        Thread thread = new Thread(new RunnableExample());
        thread.start();
    }

    @Test
    public void threadTest() {
        ThreadExample threadTest2 = new ThreadExample();
        threadTest2.start();
    }

    @Test
    public void callableTest() throws ExecutionException, InterruptedException {
        CallableExample callableTest3 = new CallableExample();
        FutureTask<String> futureTask = new FutureTask(callableTest3);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    @Test
    public void callableTest2() throws ExecutionException, InterruptedException {
        CallableExample callableTest3 = new CallableExample();
        FutureTask<String> futureTask = new FutureTask(callableTest3);
        new Thread(futureTask).start();
        futureTask.cancel(true);
        System.out.println(futureTask.get());
    }
}
