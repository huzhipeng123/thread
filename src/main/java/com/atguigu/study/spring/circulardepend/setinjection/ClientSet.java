package com.atguigu.study.spring.circulardepend.setinjection;

/**
 * @Author huzhpm
 * @Date 2021/4/5 23:32
 * @Version 1.0
 * @Content
 */
public class ClientSet {

    public static void main(String[] args) {
        ServiceAA serviceAA = new ServiceAA();
        ServiceBB serviceBB = new ServiceBB();
        serviceAA.setServiceBB(serviceBB);
        serviceBB.setServiceAA(serviceAA);
    }

}
