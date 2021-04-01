package com.atguigu.study.javase;

/**
 * @author huzhpm
 * @date 2021-04-01 17:40
 * @Description 字符串常量内部加载
 */
public class StringPool58Demo {
    public static void main(String[] args) {
        String str1 = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println("====================");
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
    }
}
