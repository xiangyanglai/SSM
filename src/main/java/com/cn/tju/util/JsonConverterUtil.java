package com.cn.tju.util;

import com.alibaba.fastjson.JSON;

/**
 * Created by search on 2016/11/16.
 */
public class JsonConverterUtil {
    public static String loginInfoByJson(String successMsg, boolean isSuccess)
    {
        ResultDO result = new ResultDO();
        result.setModule(successMsg);
        result.setSuccess(isSuccess);
        return JSON.toJSONString(result);
    }


}
