package com.atguigu.study.spring.circulardepend;

/**
 * @Author huzhpm
 * @Date 2021/4/5 23:44
 * @Version 1.0
 * @Content
 */
public class ClientCode {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        b.setA(a);
        a.setB(b);
    }
}
