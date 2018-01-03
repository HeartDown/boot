package com.zh.study.pattern.structural.proxy;

import java.time.Instant;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class GamePlayerProxy implements IGamePlayer{
    private IGamePlayer player = null;
    public void log(){
        System.out.println("打怪时间："+ Instant.now());
    }

    public GamePlayerProxy(IGamePlayer player) {
        this.player = player;
    }

    public void count(){
        System.out.println("升一级");
    }

    @Override
    public void killBoss() {
        this.log();
        player.killBoss();
    }

    @Override
    public void upGrade() {
        this.count();
        player.upGrade();
    }
}
