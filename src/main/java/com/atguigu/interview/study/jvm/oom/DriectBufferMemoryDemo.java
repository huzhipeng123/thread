package com.atguigu.interview.study.jvm.oom;/**
 * @Author huzhpm
 * @Date 2021/3/24 23:20
 * @Version 1.0
 * @Content
 */

/**
 * @program: thread
 * @description:
 * @author: huzhpm
 * @created: 2021/03/24 23:20
 */
public class DriectBufferMemoryDemo {

    public static void main(String[] args) {
        System.out.println("配置的maxDrirectMemory:"+(sun.misc.VM.maxDirectMemory() / (double) 1024/ 1024) + "MB");


    }

}
