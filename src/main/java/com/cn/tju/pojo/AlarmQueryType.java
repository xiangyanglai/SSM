package com.cn.tju.pojo;

import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * Created by Search on 2016/12/4.
 */
public enum AlarmQueryType {
    All("all"),ByDay("byDay"),ByWeek("byWeek"),ByYear("byYear"),ByMonth("byMonth"),Cunstom("custom");

    private String queryType;

    public String getQueryType()
    {
        return this.queryType;
    }

    public void setQueryType(String queryType)
    {
        this.queryType = queryType;
    }


    AlarmQueryType(String queryType)
    {
        this.queryType = queryType;
    }

    public static boolean isContain(String queryType)
    {
        if(StringUtils.isNotEmpty(queryType))
        {
            for (AlarmQueryType c : AlarmQueryType.values()) {
                if (c.getQueryType().equals(queryType)) {
                    return true;
                }
            }
        }
        return false;
    }
}
