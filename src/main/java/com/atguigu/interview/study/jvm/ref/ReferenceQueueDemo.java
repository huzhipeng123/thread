package com.atguigu.interview.study.jvm.ref;/**
 * @Author huzhpm
 * @Date 2021/3/22 23:21
 * @Version 1.0
 * @Content
 */

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @program: thread
 * @description: 弱引用Demo
 * @author: huzhpm
 * @created: 2021/03/22 23:21
 */
public class ReferenceQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1, queue);
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(queue.poll());

        System.out.println("=====================");
        o1 = null;
        System.gc();
        Thread.sleep(5000);
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(queue.poll());
    }

}
