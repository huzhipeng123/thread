package com.atguigu.interview.study.jvm.ref;/**
 * @Author huzhpm
 * @Date 2021/3/21 17:21
 * @Version 1.0
 * @Content
 */

import java.lang.ref.WeakReference;

/**
 * @program: thread
 * @description: 弱引用
 * @author: huzhpm
 * @created: 2021/03/21 17:21
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());
        o1 = null;
        System.gc();
        System.out.println("++++++++++++");
        System.out.println(o1);
        System.out.println(weakReference.get());
    }

}
