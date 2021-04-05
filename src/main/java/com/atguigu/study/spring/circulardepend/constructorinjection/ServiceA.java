package com.atguigu.study.spring.circulardepend.constructorinjection;

import org.springframework.stereotype.Component;

/**
 * @Author huzhpm
 * @Date 2021/4/5 23:22
 * @Version 1.0
 * @Content
 */
@Component
public class ServiceA {

    private ServiceB serviceB;

    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
}
