package com.atguigu.study.spring.aop.impl;

import com.atguigu.study.spring.aop.CalcService;
import org.springframework.stereotype.Service;

/**
 * @Author huzhpm
 * @Date 2021/4/5 21:47
 * @Version 1.0
 * @Content
 */
@Service
public class CalcServiceimpl implements CalcService {
    @Override
    public int div(int x, int y) {
        int result = x / y;
        System.out.println("=========>CalcServiceImpl被调用了,我们的计算结果："+result);
        return result;
    }
}
