package com.zh.study;

/**
 * Created by zhangheng on 2018/1/3.
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(getSum(1, 1, 5));
    }

    static int sum = 0;

    private static int getSum(int start, int end, int length) {
        System.out.println(start+",");
        if (length == 0)
            return sum+start+end;
        sum+=start;
        return getSum(end,start+end,length-1);
    }
}
