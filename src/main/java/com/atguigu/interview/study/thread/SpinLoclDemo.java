package com.atguigu.interview.study.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author huzhpm
 * @Date 2021/3/6 14:54
 * @Version 1.0
 * @Content
 *  题目：实现一个自旋锁
 *  自旋锁好处：循环比较获取直到成功为止，没有类似wait的阻塞
 *
 *  通过CAS操作完成自旋锁，A线程先进来调用myLock方法自己持有锁5秒钟，
 *  B随后进来后发现当前有线程持有锁，不是null，所有只能通过自旋等待，
 *  直到A释放锁后B随后抢到
 */
public class SpinLoclDemo {

    /**
     * 原子引用线程
     */
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
        while(!atomicReference.compareAndSet(null, thread)){

        }
        System.out.println(Thread.currentThread().getName() +"\t come in ");
    }

    public void myUnLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() +"\t invoked myUnLock ");
    }

    public static void main(String[] args) {
        SpinLoclDemo spinLoclDemo = new SpinLoclDemo();
        new Thread(() -> {
            spinLoclDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLoclDemo.myUnLock();
        }, "AA").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            spinLoclDemo.myLock();
            spinLoclDemo.myUnLock();
        }, "BB").start();
    }

}
