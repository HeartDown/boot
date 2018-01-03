package com.zh.study.pattern.builder.single;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class GlobalNum {
    private static GlobalNum globalNum = new GlobalNum();
    private int num = 0;

    private GlobalNum(){}

    public static GlobalNum getInstance(){
        return globalNum;
    }

    public synchronized int getNum(){
        return ++num;
    }
}
