package com.atguigu.study.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author huzhpm
 * @Date 2021/4/2 23:11
 * @Version 1.0
 * @Content
 */
public class LockSupportDemo {

    static Object objectLock = new Object();

    static Lock lock = new ReentrantLock();

    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
//        synchronizedWaitNotify();

//        lockAwaitSingal();
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t-----come in");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName()+"\t-----被唤醒");
        }, "a");
        a.start();

        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread b = new Thread(() -> {
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName()+"\t----通知");
        }, "b");
        b.start();
    }

    private static void lockAwaitSingal() {
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"\t-----come in");
                condition.await();
                System.out.println(Thread.currentThread().getName()+"\t------被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "A").start();

        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t-----通知");
            }finally {
                lock.unlock();
            }
        }, "B").start();
    }

    private static void synchronizedWaitNotify() {
        new Thread(() -> {
            synchronized (objectLock){
                System.out.println(Thread.currentThread().getName() + "\t-----come in");
                try {
                    objectLock.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\t------被唤醒");
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (objectLock){
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "\t-----通知");
            }
        }, "B").start();
    }

}
