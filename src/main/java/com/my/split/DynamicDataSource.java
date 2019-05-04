package com.my.split;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * @Description: java类作用描述
 * @Author: luqihua
 * @CreateDate: 2019/5/1$ 13:39$
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("-----DynamicDataSource---DbType:" + DynamicDataSourceHolder.getDbType());
        return DynamicDataSourceHolder.getDbType();
    }
}
