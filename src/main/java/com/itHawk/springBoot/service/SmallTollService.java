package com.itHawk.springBoot.service;

import java.util.Map;

public interface SmallTollService {
    /*
     * 将时间转换为时间戳
     */
    int dateToStamp(String date, Map<String, Object> data);

    /*
     * 将时间戳转换为时间
     */
    int stampToDate(String stamp, Map<String, Object> data);

    /***
     * 16进制转2进制
     * @param  num 16进制数
     * @return 2进制数
     */
    int sixteen2Two(String num, Map<String, Object> data);

    /***
     * 2进制转16进制
     * @param  num 2进制数
     * @return 16进制数
     */
    int two2Sixteen(String num, Map<String, Object> data);

    /***
     * 2进制转10进制
     * @param  num 2进制数
     * @return 10进制数
     */
    int two2Ten(String num, Map<String, Object> data);

    /***
     * 10进制转其他进制
     * @param  num 10进制数
     * @return 小于10的几进制数
     */
    int ten2Other(String num, Long systems, Map<String, Object> data);

    /***
     * 10进制转16进制
     * @param  oldNum 10进制数
     * @return 16进制数
     */
    int ten2Sixteen(String oldNum, Map<String, Object> data);

    /***
     * 10进制转2进制
     * @param  oldNum 10进制数
     * @return 2进制数
     */
    int ten2Two(String oldNum, Map<String, Object> data);
}
