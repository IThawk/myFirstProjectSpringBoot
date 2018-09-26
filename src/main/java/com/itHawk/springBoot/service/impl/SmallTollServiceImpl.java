package com.itHawk.springBoot.service.impl;

import com.itHawk.springBoot.service.SmallTollService;
import com.itHawk.springBoot.utils.HttpCode;
import com.itHawk.springBoot.utils.NumUtils;
import com.itHawk.springBoot.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Map;

@Service
public class SmallTollServiceImpl implements SmallTollService {

    //日志
    Logger logger = LoggerFactory.getLogger(getClass());


    /***
     * date时间转时间戳
     * @param date 时间
     * @return
     */
    @Override
    public int dateToStamp(String date, Map<String, Object> data) {
        try {
            String stamp = TimeUtils.dateToStamp(date);
            data.put("stamp", stamp);
            return HttpCode.RESPONSE_SUCCESS;
        } catch (ParseException e) {
            logger.error("date时间转时间戳失败。原因是：{}", e);
            return HttpCode.RESPONSE_ERROR;
        }
    }

    /***
     * date时间转时间戳
     * 时间戳戳转date时间
     * @param stamp  时间戳
     * @return
     */
    @Override
    public int stampToDate(String stamp, Map<String, Object> data) {

        try {
            String date = TimeUtils.dateToStamp(stamp);
            data.put("date", date);
            return HttpCode.RESPONSE_SUCCESS;
        } catch (ParseException e) {
            logger.error("时间戳转date时间失败。原因是：{}", e);
            return HttpCode.RESPONSE_ERROR;
        }


    }


    /***
     * 16进制转2进制
     * @param  num 16进制数
     * @return 2进制数
     */
    @Override
    public int sixteen2Two(String num, Map<String, Object> data) {
        try {
            String twoNum = NumUtils.sixteen2Two(num);
            data.put("twoNum", twoNum);
            return HttpCode.RESPONSE_SUCCESS;
        } catch (Exception e) {
            logger.error("十六进制转二进制失败。原因是：{}", e);
            return HttpCode.RESPONSE_ERROR;
        }
    }

    /***
     * 2进制转16进制
     * @param  num 2进制数
     * @return 16进制数
     */
    @Override
    public int two2Sixteen(String num, Map<String, Object> data) {
        try {
            String sixteenNum = NumUtils.two2Sixteen(num);
            data.put("sixteenNum", sixteenNum);
            return HttpCode.RESPONSE_SUCCESS;
        } catch (Exception e) {
            logger.error("二进制转十六进制失败。原因是：{}", e);
            return HttpCode.RESPONSE_ERROR;
        }
    }

    /***
     * 2进制转10进制
     * @param  num 2进制数
     * @return 10进制数
     */
    @Override
    public int two2Ten(String num, Map<String, Object> data) {
        try {
            String tenNum = NumUtils.two2Ten(num);
            data.put("tenNum", tenNum);
            return HttpCode.RESPONSE_SUCCESS;
        } catch (Exception e) {
            logger.error("二进制转十进制失败。原因是：{}", e);
            return HttpCode.RESPONSE_ERROR;
        }
    }

    /***
     * 10进制转其他进制
     * @param  num 10进制数
     * @return 小于10的几进制数
     */
    @Override
    public int ten2Other(String num, Long systems, Map<String, Object> data) {
        try {
            String otherNum = NumUtils.ten2Other(num, systems);
            data.put("otherNum", otherNum);
            return HttpCode.RESPONSE_SUCCESS;
        } catch (Exception e) {
            logger.error("十进制转{}进制失败。原因是：{}", systems, e);
            return HttpCode.RESPONSE_ERROR;
        }
    }

    /***
     * 10进制转16进制
     * @param  oldNum 10进制数
     * @return 16进制数
     */
    @Override
    public int ten2Sixteen(String oldNum, Map<String, Object> data) {
        try {
            String sixteenNum = NumUtils.ten2Sixteen(oldNum);
            data.put("sixteenNum", sixteenNum);
            return HttpCode.RESPONSE_SUCCESS;
        } catch (Exception e) {
            logger.error("十进制转十六进制失败。原因是：{}", e);
            return HttpCode.RESPONSE_ERROR;
        }
    }

    /***
     * 10进制转2进制
     * @param  oldNum 10进制数
     * @return 2进制数
     */
    @Override
    public int ten2Two(String oldNum, Map<String, Object> data) {
        try {
            String twoNum = NumUtils.ten2Two(oldNum);
            data.put("twoNum", twoNum);
            return HttpCode.RESPONSE_SUCCESS;
        } catch (Exception e) {
            logger.error("十进制转二进制失败。原因是：{}", e);
            return HttpCode.RESPONSE_ERROR;
        }
    }
}
