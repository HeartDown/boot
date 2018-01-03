package com.zh.study.solr.entity;

import org.apache.solr.client.solrj.beans.Field;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/30.
 */
public class Document {
    //文档ID
    @Field
    private String id;
    //文档标题
    @Field
    private String title;
    //文档主题
    @Field
    private String subject;
    //文档说明
    @Field
    private String description;
    //文档作者
    @Field
    private String documentauthor;
    //关键字
    @Field
    private String keywords;
    //文件类型


    @Field
    private String filetype;
    //文档分类
    @Field
    private String category;
    //文档路径
    @Field
    private String url;
    //文档创建时间
    @Field
    private Date createtime;
    //附件名
    @Field
    private String attachmentname;
    @Field
    private ArrayList text;

    private String searchKey;

    private String begintime;

    private String endtime;

    private String searcharea;

    public String getSearcharea() {
        return searcharea;
    }

    public void setSearcharea(String searcharea) {
        this.searcharea = searcharea;
    }

    public String getAttachmentname() {
        return attachmentname;
    }

    public void setAttachmentname(String attachmentname) {
        this.attachmentname = attachmentname;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public ArrayList getText() {
        return text;
    }

    public void setText(ArrayList text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocumentauthor() {
        return documentauthor;
    }

    public void setDocumentauthor(String documentauthor) {
        this.documentauthor = documentauthor;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
