package com.atguigu.interview.study.jvm.oom;/**
 * @Author huzhpm
 * @Date 2021/3/24 22:39
 * @Version 1.0
 * @Content
 * java.lang.OutOfMemoryError: GC overhead limit exceeded GC回收时间过长
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @program: thread
 * @description:
 * @author: huzhpm
 * @created: 2021/03/24 22:39
 */
public class GCOverheadDemo {

    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        try {
            while (true){
                list.add(String.valueOf(++i).intern());
            }
        } catch (Exception e) {
            System.out.println("**************i:"+i);
            e.printStackTrace();
        }
    }

}
