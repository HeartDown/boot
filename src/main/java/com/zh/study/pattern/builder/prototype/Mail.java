package com.zh.study.pattern.builder.prototype;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class Mail implements Cloneable {
    private String receiver;//收件人
    private String subject;//邮件标题
    private String appellation;//称谓
    private String content;//内容
    private String tail;//尾部

    public Mail(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    @Override
    public String toString() {
        return "标题："+this.getSubject()+"\t收件人:"+this.getReceiver()
                +"\t内容"+this.getContent()+"\t.....发送成功";
    }

    public Mail clone(){
        Mail mail = null;
        try {
            mail = (Mail) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return mail;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }
}
