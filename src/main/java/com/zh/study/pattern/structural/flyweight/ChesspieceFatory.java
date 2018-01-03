package com.zh.study.pattern.structural.flyweight;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class ChesspieceFatory {
    private static final Chesspiece WHITE = new ChesspieceFlyWeight("白");
    private static final Chesspiece BLACK = new ChesspieceFlyWeight("黑");

    public static Chesspiece getChesspiece(String color){
        if (color.equals("白")){
            return WHITE;
        }else if (color.equals("黑")){
            return BLACK;
        }else {
            return null;
        }
    }
}
