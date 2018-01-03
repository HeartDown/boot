package com.zh.study.pattern.builder.abstractfactory;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class LevelOneFactory implements AbstractFactory {
    @Override
    public ProductA factoryA() {
        return new ProductALevelOne();
    }

    @Override
    public ProductB factoryB() {
        return new ProductBLevelOne();
    }
}
