package com.zh.study.pattern.structural.proxy;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class GamePlayer implements IGamePlayer {
    private String name;
    public GamePlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void killBoss() {
        System.out.println("我杀死BOSS了");
    }

    @Override
    public void upGrade() {
        System.out.println("升级了");
    }
}
