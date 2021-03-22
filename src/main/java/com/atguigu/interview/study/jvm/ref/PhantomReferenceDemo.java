package com.atguigu.interview.study.jvm.ref;/**
 * @Author huzhpm
 * @Date 2021/3/22 23:28
 * @Version 1.0
 * @Content
 */

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @program: thread
 * @description: 虚引用Demo
 * @author: huzhpm
 * @created: 2021/03/22 23:28
 */
public class PhantomReferenceDemo {

    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1, queue);
        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(queue.poll());

        System.out.println("====================");
        o1 = null;
        System.gc();
        Thread.sleep(5000);

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(queue.poll());
    }
}
