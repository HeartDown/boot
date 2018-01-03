package com.zh.study.pattern.builder.factory;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class TestFactory {
    public static void main(String[] args) {
        FruitFactory fruitFactory = new AppleFactory();
        Fruit apple = fruitFactory.factory();

        FruitFactory fruitFactory1 = new GrapeFactory();
        Fruit grape = fruitFactory1.factory();

        apple.grow();
        grape.grow();
    }
}
