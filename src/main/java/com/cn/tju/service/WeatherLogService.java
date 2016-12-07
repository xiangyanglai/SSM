package com.cn.tju.service;

import com.cn.tju.pojo.WeatherLog;
import com.cn.tju.util.ResultDO;

import java.util.Date;
import java.util.List;

/**
 * Created by search on 2016/11/29.
 */
public interface WeatherLogService {

    public ResultDO<List<WeatherLog>> getWeatherLogByDatetime(Date startTime, Date endTime);
}
