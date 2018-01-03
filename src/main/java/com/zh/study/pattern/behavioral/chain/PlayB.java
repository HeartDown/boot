package com.zh.study.pattern.behavioral.chain;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class PlayB extends Player {
    public PlayB(Player player) {
        this.setSuccessor(player);
    }

    @Override
    public void handle(int i) {
        if (i==2){
            System.out.println("playB喝酒");
        }else {
            System.out.println("playerB传递给下一个");
            next(i);
        }
    }
}
