package com.zh.study.principle.ocp;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class OffNovelBook extends NovelBook{
    public OffNovelBook(String name, double price, String author) {
        super(name, price, author);
    }

    @Override
    public double getPrice() {
        return super.getPrice()*0.8;
    }
}
