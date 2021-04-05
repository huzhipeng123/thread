package com.atguigu.study.spring.aop.controller;

import com.atguigu.study.spring.aop.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huzhpm
 * @Date 2021/4/5 22:13
 * @Version 1.0
 * @Content
 */
@RestController
public class TestAopController {

    @Autowired
    public CalcService calcService;

    @GetMapping("/test4")
    public Object testAop4(){
        System.out.println("spring版本"+ SpringVersion.getVersion()+"\tSpringBoot版本："+ SpringBootVersion.getVersion());
        System.out.println();
        int result = calcService.div(10, 0);
        System.out.println(result);
        return result;
    }

}
