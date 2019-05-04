package com.my.split;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: java类作用描述
 * @Author: luqihua
 * @CreateDate: 2019/5/1$ 13:46$
 */
public class DynamicDataSourceHolder {
    public static final String DB_MASTER = "master";
    public static final String DB_SLAVE = "slave";
    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceHolder.class);
    private static ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static String getDbType() {
        String db = contextHolder.get();
        if (null == db) {
            db = DB_MASTER;
        }
        return db;
    }

    public static void setDbType(String dbType) {
        logger.debug("所用的数据源为---" + dbType);
        contextHolder.set(dbType);
    }

    public static void clearDbType() {
        contextHolder.remove();
    }
}
