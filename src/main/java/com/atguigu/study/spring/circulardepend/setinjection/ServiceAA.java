package com.atguigu.study.spring.circulardepend.setinjection;

import org.springframework.stereotype.Component;

/**
 * @Author huzhpm
 * @Date 2021/4/5 23:26
 * @Version 1.0
 * @Content
 */
@Component
public class ServiceAA {

    private ServiceBB serviceBB;


    public void setServiceBB(ServiceBB serviceBB) {
        this.serviceBB = serviceBB;
        System.out.println("A 里面设置了 B");
    }
}
