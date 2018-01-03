package com.zh.study.solr.entity;

import java.util.ArrayList;
import java.util.List;

public class DocumentResult {

    private List<Document> resultList = new ArrayList<>();
    private int totalsize;

    public List<Document> getResultList() {
        return resultList;
    }

    public void setResultList(List<Document> resultList) {
        this.resultList = resultList;
    }

    public int getTotalsize() {
        return totalsize;
    }

    public void setTotalsize(int totalsize) {
        this.totalsize = totalsize;
    }
}
