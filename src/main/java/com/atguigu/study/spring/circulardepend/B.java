package com.atguigu.study.spring.circulardepend;

/**
 * @Author huzhpm
 * @Date 2021/4/5 23:40
 * @Version 1.0
 * @Content
 */
public class B {

    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B() {
        System.out.println("---B create success");
    }
}
