package com.zh.study.pattern.behavioral.chain;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class PlayA extends Player {
    public PlayA(Player player) {
        this.setSuccessor(player);
    }

    @Override
    public void handle(int i) {
        if (i==1){
            System.out.println("playA喝酒");
        }else {
            System.out.println("playerA传递给下一个");
            next(i);
        }
    }
}
