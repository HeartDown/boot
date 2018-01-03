package com.zh.study.pattern.behavioral.chain;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class PlayC extends Player {
    public PlayC(Player player) {
        this.setSuccessor(player);
    }

    @Override
    public void handle(int i) {
        if (i==3){
            System.out.println("playc喝酒");
        }else {
            System.out.println("playerc传递给下一个");
            next(i);
        }
    }
}
