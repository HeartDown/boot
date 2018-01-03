package com.zh.study.principle.isp;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class Order implements AdminOrder,OtherSysOrder,ProtalOrder{
    public static ProtalOrder getOrderForProtal(){
        return new Order();
    }

    public static OtherSysOrder getOtherSysOrder(){
        return new Order();
    }

    public static AdminOrder getAdminOrder(){
        return new Order();
    }

    @Override
    public String getOrder() {
        return "返回订单";
    }

    @Override
    public void deleteOrder() {

    }

    @Override
    public int addOrder() {
        return 0;
    }

    @Override
    public int updateOrder() {
        return 0;
    }
}
