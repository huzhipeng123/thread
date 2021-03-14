package com.atguigu.juc.study;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyThread implements Runnable{


    @Override
    public void run() {
        System.out.println("come in Runnable");
    }
}

/**
 * 有返回值
 * 会抛异常
 */
class MyThread2 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("*********come in Callable");
        return 1024;
    }
}

/**
 *
 */
public class CallableDemo {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread2());

        Thread t2 = new Thread(new MyThread());
        t2.start();

        Thread t1 = new Thread(futureTask);
        t1.start();
    }
}



