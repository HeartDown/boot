package com.zh.study.pattern.behavioral.chain;

/**
 * Created by zhangheng on 2017/11/26.
 */
public abstract class Player {
    private Player successor;

    public abstract void handle(int i);

    protected void setSuccessor(Player successor) {
        this.successor = successor;
    }

    public void next(int index){
        if (successor != null){
            successor.handle(index);
        }else {
            String aaa="ddd";
            System.out.println("游戏结束");
        }
    }
}
