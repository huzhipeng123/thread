package com.atguigu.interview.study.jvm.oom;/**
 * @Author huzhpm
 * @Date 2021/3/22 23:46
 * @Version 1.0
 * @Content StackOverflowError 是一个java中常出现的错误：在jvm运行时的数据区域中有一个java虚拟机栈，
 * 当执行java方法时会进行压栈弹栈的操作。在栈中会保存局部变量，操作数栈，方法出口等等。
 * jvm规定了栈的最大深度，当执行时栈的深度大于了规定的深度，就会抛出StackOverflowError错误。
 */

/**
 * @program: thread
 * @description:
 * @author: huzhpm
 * @created: 2021/03/22 23:46
 */
public class StackOverflowErrorDemo {

    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }

}
