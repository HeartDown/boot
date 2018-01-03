package com.zh.study.solr.util;

import com.zh.study.solr.SolrConst;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by zhangheng on 2017/11/27.
 */
public class SolrOperateIml implements ISolrOperate{

    private SolrClient  client;

    public SolrOperateIml() {
        this.client = new HttpSolrClient(SolrConst.SERVER_URL);
    }

    @Override
    public void createDocs() {
        Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
        for (int i = 1; i <= 2; i++) {
            SolrInputDocument doc1 = new SolrInputDocument();
            doc1.addField("id", UUID.randomUUID().toString(), 1.0f);
            doc1.addField("name", "bean");
            doc1.addField("equIP_s", "192.168.2.104");
            doc1.addField("level_s", "4");
            doc1.addField("collectPro_s", "ffffffffffffffffffffjajajajajajdddddddddd");
            doc1.addField("sourceType_s", "miaohqaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            doc1.addField("filePath_s", "/home/xxxx/test");
            doc1.addField("filename_s", "zhonggggmaiaiadadadddddddddddddddddddddddddd");//            doc1.addField("_route_", "shard1");
            docs.add(doc1);
        }
        System.out.println("success");
    }

    @Override
    public void queryDocs() {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void deleteByQuery(String queryCon) {

    }

    @Override
    public void updateField(String id, String fieldName, Object fieldValue) {

    }
}
