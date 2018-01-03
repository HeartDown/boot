package com.zh.study.pattern.builder.prototype;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class ClientDemo {
    private static int MAX_COUNT = 6;

    public static void main(String[] args) {
        int i = 0;
        Mail mail = new Mail("抽奖活动","凡是购物超过100元即可抽奖");
        mail.setTail("解释权归商家所有");
        while (i<MAX_COUNT){
            Mail cloneMail = mail.clone();
            cloneMail.setAppellation("张"+i+"先生（女士）");
            cloneMail.setReceiver(Math.random()+"@qq.com");
            sendMain(cloneMail);
            i++;
        }
    }

    private static void sendMain(Mail cloneMail) {
        System.out.println(cloneMail);
    }
}
