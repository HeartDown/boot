package com.zh.study.principle.isp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 接口隔离原则（ISP）
 * Created by zhangheng on 2017/11/26.
 */
public class TestISP {
    public static void main(String[] args) {
        ProtalOrder protalOrder = Order.getOrderForProtal();
        AdminOrder adminOrder = Order.getAdminOrder();
        OtherSysOrder otherSysOrder = Order.getOtherSysOrder();

        System.out.println(protalOrder.getOrder());
        System.out.println(adminOrder.updateOrder());
        System.out.println(otherSysOrder.addOrder());

        String[] a=new String[3];
        System.out.println(a[8]);
        try {
            InputStream inputStream = new FileInputStream("sss");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
