package com.cn.tju.util;

/**
 * Created by search on 2016/11/14.
 */
public class Constants {
    public static final int IDISPLAYSTART = 0;
    public static final int DISPLAYLENGTH = 6;
    public static final int CALC_AREA = 30;

    public static final String ERR_QUERY_RESULT = "ERR_QUERY_RESULT";   //结果查询错误
    public static final String ERR_DB_EXCEPTION = "ERR_DB_EXCEPTION";            //数据库异常
    public static final String ERR_PARAMETER_ERROR = "ERR_PARAMETER_ERROR";     //参数错误
    public static final String DEFAULT_ERROR_MESSAGE = "抱歉，当前系统繁忙，请稍后再试。";

    public static String getErrCode(String code, String msg) {
        return code + "::" + msg;
    }
}
