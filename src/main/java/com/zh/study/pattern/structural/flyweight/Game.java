package com.zh.study.pattern.structural.flyweight;

/**
 * Created by zhangheng on 2017/11/26.
 * 享元模式
 */
public class Game {
    public static void main(String[] args) {
        Chesspiece p1 = ChesspieceFatory.getChesspiece("白");
        p1.put(3,3);
        Chesspiece p2 = ChesspieceFatory.getChesspiece("黑");
        p2.put(3,5);
    }
}
