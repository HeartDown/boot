package com.zh.study.pattern.builder.abstractfactory;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class LevelTwoFactory implements AbstractFactory {
    @Override
    public ProductA factoryA() {
        return new ProductALevelTwo();
    }

    @Override
    public ProductB factoryB() {
        return new ProductBLevelTwo();
    }
}
