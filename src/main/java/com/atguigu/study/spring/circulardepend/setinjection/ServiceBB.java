package com.atguigu.study.spring.circulardepend.setinjection;

import org.springframework.stereotype.Component;

/**
 * @Author huzhpm
 * @Date 2021/4/5 23:27
 * @Version 1.0
 * @Content
 */
@Component
public class ServiceBB {

    private ServiceAA serviceAA;

    public ServiceAA getServiceAA() {
        return serviceAA;
    }

    public void setServiceAA(ServiceAA serviceAA) {
        this.serviceAA = serviceAA;
        System.out.println("B 里面设置了 A");
    }
}