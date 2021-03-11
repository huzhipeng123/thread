package com.atguigu.interview.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @Author huzhpm
 * @Date 2021/3/7 15:59
 * @Version 1.0
 * @Content
 */
@AllArgsConstructor
public enum CountryEnum {

    ONE(1, "齐"),
    TWO(2, "楚"),
    THREE(3, "燕"),
    FOUR(4, "赵"),
    FIVE(5, "魏"),
    SIX(6, "韩");

    @Getter private Integer retCode;
    @Getter private String retMessage;

    public static CountryEnum forEach_CountryEnum(int index){
        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum element : values) {
            if(index == element.getRetCode()){
                return element;
            }
        }
        return null;
    }

}
