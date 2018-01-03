package com.zh.study.pattern.structural.flyweight;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class ChesspieceFlyWeight implements Chesspiece {
    private String color;

    public ChesspieceFlyWeight(String color) {
        this.color = color;
    }

    @Override
    public void put(int x, int y) {
        System.out.println("在("+x+"，"+y+")坐标处放置一个"+color+"棋子");
    }
}
