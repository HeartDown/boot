package com.zh.study.pattern.builder.factory;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class AppleFactory implements FruitFactory {
    @Override
    public Fruit factory() {
        return new Apple();
    }
}
