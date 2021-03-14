package com.atguigu.interview.study.thread;
/**
 * @Author huzhpm
 * @Date 2021/3/14 13:44
 * @Version 1.0
 * @Content
 */

import sun.nio.ch.ThreadPool;

import java.sql.Time;
import java.util.concurrent.*;

/**
 * @program: thread
 * @description:
 * @author: huzhpm
 * @created: 2021/03/14 13:44
 * 第4种获得线程，使用java的方式，线程池
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {

//        ExecutorService threadPool = new ThreadPoolExecutor(2, 5, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
//        ExecutorService threadPool = new ThreadPoolExecutor(2, 5, 1, TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        ExecutorService threadPool = new ThreadPoolExecutor(2, 5, 1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 1; i <= 10; i++){
            int index = i;
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName()+"\t 处理业务:\t"+index);
            });
        }
//        try{
//            TimeUnit.SECONDS.sleep(2);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        System.out.println(Runtime.getRuntime().availableProcessors());
        threadPool.shutdown();
    }

    private static void threadPoolInit() {
        // 一池5个处理线程
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try{
            for(int i = 1; i <= 10; i++){
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
//                try {
//                    TimeUnit.MILLISECONDS.sleep(200);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
