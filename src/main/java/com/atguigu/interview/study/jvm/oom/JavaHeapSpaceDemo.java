package com.atguigu.interview.study.jvm.oom;

import java.util.Random;

/**
 *OutOfMemoryError异常Demo
 * 栈溢出
 */
public class JavaHeapSpaceDemo {

    public static void main(String[] args) {
//        String str = "atguigu";
//        while(true){
//            str += str + new Random().nextInt(1111111) + new Random().nextInt(222222);
//            str.intern();
//        }

        byte[] bytes = new byte[80*1024*1024];
    }

}
