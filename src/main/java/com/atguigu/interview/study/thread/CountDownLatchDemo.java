package com.atguigu.interview.study.thread;

import com.atguigu.interview.enums.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * @Author huzhpm
 * @Date 2021/3/7 15:44
 * @Version 1.0
 * @Content
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        closeDoor();
    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i = 1; i <= 6; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t 国，被灭");
                countDownLatch.countDown();
            }, CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 88888888888888秦帝国，一统华夏");
    }

}
