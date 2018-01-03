package com.zh.study.solr.util;

/**
 * Created by zhangheng on 2017/11/27.
 */
public interface ISolrOperate {
    /**
     * 创建文档
     */
    public void createDocs();

    /**
     * 查询
     */
    public void queryDocs();

    /**
     * 通过id删除索引
     * @param id
     */
    public void deleteById(String id);

    /**
     * 通过参数删除
     * @param queryCon
     */
    public void deleteByQuery(String queryCon);

    /**
     * 更新字段
     * @param id
     * @param fieldName
     * @param fieldValue
     */
    public void updateField(String id,String fieldName, Object fieldValue);


}
