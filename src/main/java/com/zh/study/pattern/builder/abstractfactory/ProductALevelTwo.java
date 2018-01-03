package com.zh.study.pattern.builder.abstractfactory;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class ProductALevelTwo implements ProductA {

    @Override
    public void decreption() {
        System.out.println("我是产品A的第二级零件");
    }
}
