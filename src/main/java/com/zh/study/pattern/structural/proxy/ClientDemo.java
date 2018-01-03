package com.zh.study.pattern.structural.proxy;

/**
 * Created by zhangheng on 2017/11/26.
 * 代理模式
 */
public class ClientDemo {
    public static void main(String[] args) {
        IGamePlayer gamePlayer = new GamePlayer("芦苇微微");
        IGamePlayer proxy = new GamePlayerProxy(gamePlayer);

        proxy.killBoss();
        proxy.upGrade();
    }
}
