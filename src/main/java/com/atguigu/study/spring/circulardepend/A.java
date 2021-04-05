package com.atguigu.study.spring.circulardepend;

/**
 * @Author huzhpm
 * @Date 2021/4/5 23:40
 * @Version 1.0
 * @Content
 */
public class A {

    private B b;


    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public A() {
        System.out.println("---A create success");
    }
}
