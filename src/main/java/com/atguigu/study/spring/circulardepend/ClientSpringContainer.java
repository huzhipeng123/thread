package com.atguigu.study.spring.circulardepend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author huzhpm
 * @Date 2021/4/5 23:52
 * @Version 1.0
 * @Content
 */
public class ClientSpringContainer {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        A a = context.getBean("a", A.class);
        B b = context.getBean("b", B.class);
    }

}
