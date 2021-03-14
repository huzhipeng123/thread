package com.atguigu.interview.study.thread;/**
 * @Author huzhpm
 * @Date 2021/3/14 23:00
 * @Version 1.0
 * @Content
 */

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @program: thread
 * @description: 死锁是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的线程，若无外力干涉那他们都将无法推进下去
 * @author: huzhpm
 * @created: 2021/03/14 23:00
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA, lockB), "ThreadAAA").start();
        new Thread(new HoldLockThread(lockB, lockA), "ThreadBBB").start();
    }
}

@Data
@AllArgsConstructor
class HoldLockThread implements Runnable{

    private String lockA;

    private String lockB;

    @Override
    public void run() {
        add();
    }

    private void add() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有:"+lockA+"\t 尝试获得："+lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            }catch (Exception e){
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 自己持有:"+lockB+"\t 尝试获得："+lockA);
            }
        }
    }
}