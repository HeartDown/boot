package com.zh.study.pattern.builder.single;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class SingleDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            GlobalNum globalNum = GlobalNum.getInstance();
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+",第"+globalNum.getNum());
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.setName("线程1");
        Thread thread2 = new Thread(()->{
            GlobalNum globalNum = GlobalNum.getInstance();
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+",第"+globalNum.getNum()+"次访问");
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
    }
}
