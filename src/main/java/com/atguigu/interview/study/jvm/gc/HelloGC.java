package com.atguigu.interview.study.jvm.gc;

public class HelloGC {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("********HelloGC");
        System.out.println(System.getProperties());
        Thread.sleep(Integer.MAX_VALUE);
    }
}
