package com.zh.study.principle.ocp;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class NovelBook implements IBook {
    private String name;
    private double price;
    private String author;

    public NovelBook(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public String toString() {
        return "书名："+this.getName()+"\t价格："+this.getPrice()+"\t作者："+this.getAuthor()+"\n";
    }
}
