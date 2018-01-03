package com.zh.study.solr;

import com.zh.study.solr.entity.Document;
import com.zh.study.solr.util.SolrUtil;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class SolrTest {
    @Test
    public void addDoc() {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        String title = "Apache_Shiro参考手册中文版.pdf";
        String subject = "update";
        String description = "文档352af1";
        String documentauthor = "21";
        String keywords = "公司业务";
        String fileType = "application/msword";
        String category = "文档分类321";
        String url = "E:/文档/Apache_Shiro参考手册中文版.pdf";
        Date createTime = new Date();
        Document document = new Document();
        document.setId(id);
        document.setTitle(title);
        document.setSubject(subject);
        document.setDescription(description);
        document.setDocumentauthor(documentauthor);
        document.setKeywords(keywords);
        document.setFiletype(fileType);
        document.setCategory(category);
        document.setUrl(url);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        String time = sdf.format(new Date());
//解析时间 2016-01-05T15:06:58+0800

        try {
            document.setCreatetime(sdf.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        document.setCreatetime(createTime);

        List<Document> documents = new ArrayList();
        documents.add(document);

        try
        {
            SolrUtil.addDocuments(documents);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     * 查询
     */
    @Test
    public void testQuery() {
        HttpSolrClient solrClient = SolrUtil.getSolrClient();
        SolrQuery filterQuery = new SolrQuery();
        filterQuery.setQuery("title:321 AND keywords:关键字123");
        try {
            QueryResponse response = solrClient.query(filterQuery);
            SolrDocumentList results = response.getResults();
            System.out.println(results);
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void addDelete() {
        List<String> ids = new ArrayList<String>();
        ids.add("d888bc988c5a4a11aaac26bd2e98fd11");
        try {
            SolrUtil.deleteDocumentByIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}