package com.itHawk.springBoot.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * 用于读取文件中的内容的类  （key-value）
 * @author IThawk
 * @date 2018/9/26
 */
public class PropertyUtils {
    //日志
    private static Logger logger = LoggerFactory.getLogger(PropertyUtils.class);
    private static Properties props;

    static {
        loadProps();
    }

    private  PropertyUtils() {
        throw new IllegalAccessError("PropertyUtils class");
    }

    /***
     * 用与初始化加载配置文件的方法
     */
    synchronized static private void loadProps() {
        logger.info("开始加载properties文件内容.......");
        props = new Properties();
        InputStream in = null;

        in = PropertyUtils.class.getClassLoader().getResourceAsStream("constant.properties");
        try {
            props.load(in);
        } catch (IOException e) {
            logger.info("开始加载properties文件内容出错",e);
        }
        logger.info("加载properties文件内容完成...........");
        logger.info("properties文件内容：" + props);
    }

    /***
     * 读取文件中中的内容
     * @param key  左边的东西
     * @return
     */
    public static String getProperty(String key) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }
}