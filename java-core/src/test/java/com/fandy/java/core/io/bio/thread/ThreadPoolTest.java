package com.fandy.java.core.io.bio.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import org.junit.jupiter.api.Test;

/**
 * @author: fandy
 * @date: 2019/2/13
 * @description:
 */
public class ThreadPoolTest {

    @Test
    public void noThreadPoolTest() throws InterruptedException {
        Long start = System.currentTimeMillis();
        final Random random = new Random();

        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            };
            thread.start();
            thread.join();
        }
        Long end = System.currentTimeMillis();

        System.out.println("时间差：" + (end - start));
        System.out.println("size: " + list.size());
    }

    @Test
    public void threadPoolTest() throws InterruptedException {
        Long start = System.currentTimeMillis();
        final Random random = new Random();

        final List<Integer> list = new ArrayList<>();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        Long end = System.currentTimeMillis();

        System.out.println("时间差：" + (end - start));
        System.out.println("size: " + list.size());
    }

    @Test
    public void threadPoolTest2() throws InterruptedException {


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1)
                //new ArrayBlockingQueue<>(1)
                , new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            }
        }){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                super.beforeExecute(t, r);
                System.out.println("线程执行前");
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                System.out.println("线程执行后");
            }
        } ;

        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("abc");
            }
        });
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("abc2");
            }
        });
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(1, TimeUnit.DAYS);

     }
}
