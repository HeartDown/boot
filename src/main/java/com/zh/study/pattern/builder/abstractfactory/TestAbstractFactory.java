package com.zh.study.pattern.builder.abstractfactory;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class TestAbstractFactory {
    public static void main(String[] args) {
        AbstractFactory levelOne = new LevelOneFactory();
        ProductA productA = levelOne.factoryA();
        productA.decreption();

        ProductB productB = levelOne.factoryB();
        productB.decreption();

        AbstractFactory levelTwo = new LevelTwoFactory();
        ProductA productA1 = levelTwo.factoryA();
        productA1.decreption();

        ProductB productB1 = levelTwo.factoryB();
        productB1.decreption();
    }
}
