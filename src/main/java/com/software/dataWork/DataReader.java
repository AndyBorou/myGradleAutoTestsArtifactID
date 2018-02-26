package com.software.dataWork;

import one.util.streamex.StreamEx;
import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.StringUtils.substringAfter;
import static org.apache.commons.lang3.StringUtils.substringAfterLast;

public interface DataReader {

    String getDataType();
//    default String getDataType (final String dataSource){
//        //получить подстроку строку каторая идет за последним разделителем
//        return substringAfterLast(dataSource, ".");
//    }

    <T> T readForm (final String dataSource, final Class<T> entityClass);
}
