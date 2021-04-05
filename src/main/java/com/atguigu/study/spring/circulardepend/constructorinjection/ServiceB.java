package com.atguigu.study.spring.circulardepend.constructorinjection;

import org.springframework.stereotype.Component;

/**
 * @Author huzhpm
 * @Date 2021/4/5 23:22
 * @Version 1.0
 * @Content
 */
@Component
public class ServiceB {

    private ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
