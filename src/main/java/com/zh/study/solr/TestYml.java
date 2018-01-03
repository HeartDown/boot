package com.zh.study.solr;

import com.zh.study.solr.util.ISolrOperate;
import com.zh.study.solr.util.SolrOperateIml;

/**
 * Created by zhangheng on 2017/11/27.
 */
public class TestYml {
    public static void main(String[] args) {
        ISolrOperate solrOperate = new SolrOperateIml();
        solrOperate.createDocs();
    }
}
