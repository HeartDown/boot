package com.zh.study.solr.util;

import com.zh.study.solr.SolrConst;
import com.zh.study.solr.entity.Document;
import com.zh.study.solr.entity.DocumentResult;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.ContentStreamUpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * Created by Administrator on 2017/10/30.
 */
public class SolrUtil {

    @Value("${spring.data.solr.host}")
    private static String url;

    public static HttpSolrClient getSolrClient() {
        //从系统配置文件中读取
        HttpSolrClient solrClient = new HttpSolrClient(SolrConst.SERVER_URL);
        return solrClient;
    }

    public static void addDocuments(List<Document> documents) throws Exception {
        for (Document document : documents) {
            HttpSolrClient solrClient = getSolrClient();
            ContentStreamUpdateRequest request = new ContentStreamUpdateRequest("/update/extract");
            indexFilesSolrCell(document, request);
            solrClient.request(request);
            solrClient.commit();
        }

    }

    /**
     * Method to index all types of files into Solr.
     *
     * @param document
     * @throws IOException
     * @throws SolrServerException
     */
    private static void indexFilesSolrCell(Document document, ContentStreamUpdateRequest request) throws IOException, SolrServerException {
        request.addFile(new File(document.getUrl()), "");
        //literal.xxx 文件以外的字段，xxx将映射到managed-schema中的同名字段
        request.setParam("literal.id", document.getId());
        request.setParam("literal.title", document.getTitle());
        request.setParam("literal.attachmentname", document.getAttachmentname());
        request.setParam("literal.description", document.getDescription());
        request.setParam("literal.documentauthor", document.getDocumentauthor());
        request.setParam("literal.keywords", document.getKeywords());
        request.setParam("literal.fileType", document.getFiletype());
        request.setParam("literal.category", document.getCategory());
        request.setParam("literal.url", document.getUrl());
        request.setParam("literal.createtime", document.getCreatetime() + "");
        request.setParam("fmap.content", "content");

        //up.setParam("uprefix", "attr_");
        //up.setParam("fmap.content", "content");
        //request.setAction(AbstractUpdateRequest.ACTION.COMMIT, true, true);
    }

    /**
     * 根据id集合删除索引
     *
     * @param ids
     * @throws Exception
     */
    public static void deleteDocumentByIds(List<String> ids) throws Exception {
        HttpSolrClient solrClient = getSolrClient();
        solrClient.deleteById(ids);
        solrClient.commit();
    }

    /**
     * 根据单独id删除索引
     *
     * @param id
     * @throws Exception
     */
    public static void deleteDocumentById(String id) throws Exception {
        HttpSolrClient solrClient = getSolrClient();
        solrClient.deleteById(id);
        solrClient.commit();
    }

    public static List<Document> queryDocById(Document document) {
        HttpSolrClient solrClient = getSolrClient();
        String id = document.getId();
        String query = "id:" + id;
        SolrQuery params = new SolrQuery(query);
        QueryResponse response = null;
        try {
            response = solrClient.query(params);
            List<Document> documents = response.getBeans(Document.class);
            return documents;
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DocumentResult queryDoc(Document document, int pagesize, int pagenum) {
        HttpSolrClient solrClient = getSolrClient();
        StringBuffer stringBuffer = new StringBuffer();

        if (document.getCategory() == null || document.getCategory() == "") {
            stringBuffer.append("category:知识库，论文库");
        } else {

            stringBuffer.append("category:" + document.getCategory());
        }

        stringBuffer.append(" AND " + document.getSearcharea() + ":" + document.getSearchKey());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String utcbegindate = "*";
        String utcendtime = "*";
        try {
            if (document.getBegintime() != null && document.getBegintime() != "") {
                Date begintime = sdf.parse(document.getBegintime());
                utcbegindate = local2utc(begintime);
            }
            if (document.getEndtime() != null && document.getEndtime() != "") {
                Date endtime = sdf.parse(document.getEndtime());
                utcendtime = local2utc(endtime);
            }
            stringBuffer.append(" AND createtime:[" + utcbegindate + " TO " + utcendtime + "]");
        } catch (ParseException e) {
            e.printStackTrace();
        }
/*        String keywords = document.getKeywords();
        String title = document.getTitle();
        String documentauthor = document.getDocumentauthor();
        String id = document.getId();


        if (title != null && title != "") {
            stringBuffer.append(" AND title:" + title);
        }
        if (documentauthor != null && documentauthor != "") {
            stringBuffer.append(" AND documentauthor:" + documentauthor);
        }
        if (keywords != null && keywords != "") {
            stringBuffer.append(" AND keywords:" + keywords);
        }
        if (id != null && id != "") {
            stringBuffer.append(" AND id:" + id);
        }*/

        String query = "text:docx";
        SolrQuery params = new SolrQuery(stringBuffer.toString());
//        SolrQuery params = new SolrQuery(query);


        // 设置高亮
        params.setHighlight(true);

        // 设置高亮的字段
        params.addHighlightField("title");
        params.addHighlightField("filetype");
        params.addHighlightField("documentauthor");
        params.addHighlightField("category");
        params.addHighlightField("description");
        params.addHighlightField("createtime");

        // 设置高亮的样式
        params.setHighlightSimplePre("<font color='red'>");
        params.setHighlightSimplePost("</font>");

        params.setStart(pagenum * pagesize);
        params.setRows(pagesize);
        try {
            QueryResponse response = solrClient.query(params);
            List<Document> documents = response.getBeans(Document.class);

            Map<String, Map<String, List<String>>> map = response.getHighlighting();
            for (Map.Entry<String, Map<String, List<String>>> highlighting : map.entrySet()) {
                for (Document documentEntity : documents) {
                    if (!highlighting.getKey().equals(documentEntity.getId().toString())) {
                        continue;
                    }
                    if (highlighting.getValue().get("title") != null) {
                        String titleValue = String.valueOf(highlighting.getValue().get("title"));
                        documentEntity.setTitle(resulValue(titleValue));
                    }
                    if (highlighting.getValue().get("filetype") != null) {
                        String filetypeValue = String.valueOf(highlighting.getValue().get("filetype"));
                        documentEntity.setFiletype(resulValue(filetypeValue));
                    }
                    if (highlighting.getValue().get("documentauthor") != null) {
                        String documentauthorValue = String.valueOf(highlighting.getValue().get("documentauthor"));
                        documentEntity.setDocumentauthor(resulValue(documentauthorValue));
                    }
                    if (highlighting.getValue().get("category") != null) {
                        String categoryValue = String.valueOf(highlighting.getValue().get("category"));
                        documentEntity.setCategory(resulValue(categoryValue));
                    }
                    if (highlighting.getValue().get("description") != null) {
                        String descriptionValue = String.valueOf(highlighting.getValue().get("description"));
                        documentEntity.setDescription(resulValue(descriptionValue));
                    }
                    break;
                }
            }

            DocumentResult result = new DocumentResult();
            result.setResultList(documents);
            result.setTotalsize((int) response.getResults().getNumFound());

            return result;
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String resulValue(String value) {
        return value.substring(1, value.length() - 1);
    }


    /**
     * 函数功能描述:本地时间转UTC时间时间格式
     *
     * @param date 时间
     * @return 本地时间格式的时间
     */
    public static String local2utc(Date date) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
/*        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");*/
        sdf1.setTimeZone(TimeZone.getTimeZone("UTC"));
//        String utcTime = sdf1.format(date) + "T" + sdf2.format(date) + "Z";
        String utcTime = sdf1.format(date);
        return utcTime;
    }

    /**
     * 函数功能描述:UTC时间转本地时间格式
     *
     * @param utcTime          UTC时间
     * @param localTimePattern 本地时间格式(要转换的本地时间格式)
     * @return 本地时间格式的时间
     */
    public static String utc2Local(String utcTime, String localTimePattern) {
        String utcTimePattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        String subTime = utcTime.substring(10);//UTC时间格式以 yyyy-MM-dd 开头,将utc时间的前10位截取掉,之后是含有多时区时间格式信息的数据
        utcTime = utcTime.substring(0, 10) + subTime;

        SimpleDateFormat utcFormater = new SimpleDateFormat(utcTimePattern);
        utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date gpsUtcDate = null;
        try {
            gpsUtcDate = utcFormater.parse(utcTime);
        } catch (Exception e) {
            return utcTime;
        }
        SimpleDateFormat localFormater = new SimpleDateFormat(localTimePattern);
        localFormater.setTimeZone(TimeZone.getDefault());
        String localTime = localFormater.format(gpsUtcDate.getTime());
        return localTime;
    }

}
