package com.zh.study.principle.ocp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangheng on 2017/11/26.
 * 开闭原则 OCP
 */
public class BookStoreOCP {
    private List bookList = new ArrayList<IBook>();

    public BookStoreOCP() {
//        bookList.add(new NovelBook("三国演义",22.22,"罗贯中"));
//        bookList.add(new NovelBook("三国演义",22.22,"罗贯中"));
//        bookList.add(new NovelBook("三国演义",22.22,"罗贯中"));
        bookList.add(new OffNovelBook("三国演义",22.22,"罗贯中"));
        bookList.add(new OffNovelBook("三国演义",22.22,"罗贯中"));
        bookList.add(new OffNovelBook("三国演义",22.22,"罗贯中"));
    }

    public void showBook(){
        System.out.println("书店售书列表：");
        bookList.forEach(System.out::print);
    }

    public static void main(String[] args) {
        BookStoreOCP bookStore = new BookStoreOCP();
        bookStore.showBook();
    }
}
