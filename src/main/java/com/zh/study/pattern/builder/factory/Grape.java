package com.zh.study.pattern.builder.factory;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class Grape implements Fruit {
    @Override
    public void grow() {
        System.out.println("葡萄正在生长");
    }

    @Override
    public void harvest() {
        System.out.println("葡萄收获了");
    }

    @Override
    public void plant() {
        System.out.println("葡萄种植了");
    }
}
