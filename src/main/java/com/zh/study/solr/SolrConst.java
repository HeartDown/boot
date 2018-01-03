package com.zh.study.solr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zhangheng on 2017/11/27.
 */
@Component
public class SolrConst {
    //检索服务地址
    public static String SERVER_URL="127.0.0.1:8983/core";
    //zookeeper集群地址
    @Value("${spring.data.solr.zk-host}")
    public static String ZOOKEEPER_URL;
    //链接超时时间
    @Value("${spring.data.solr.outtime}")
    public static long CONNECT_OUT_TIME;

}
