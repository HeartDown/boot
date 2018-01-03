package com.zh.study.pattern.builder.abstractfactory;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class ProductALevelOne implements ProductA {
    @Override
    public void decreption() {
        System.out.println("我是产品A的第一级零件");
    }
}
