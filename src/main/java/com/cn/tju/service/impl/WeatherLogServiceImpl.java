package com.cn.tju.service.impl;

import com.cn.tju.IDao.WeatherLogMapper;
import com.cn.tju.pojo.WeatherLog;
import com.cn.tju.service.WeatherLogService;
import com.cn.tju.util.Constants;
import com.cn.tju.util.ResultDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by search on 2016/11/29.
 */
@Slf4j
@Service
public class WeatherLogServiceImpl implements WeatherLogService{

    @Resource
    WeatherLogMapper weatherLogMapper;

    public ResultDO<List<WeatherLog>> getWeatherLogByDatetime(Date startTime, Date endTime) {
        log.warn("query weather log by datetiem, arguments:{}",new Object[]{startTime,endTime});
        ResultDO<List<WeatherLog>> resultDO = new ResultDO<List<WeatherLog>>();
        try{
            HashMap<String,Date> queryFilter = new HashMap<String, Date>();
            queryFilter.put("startTime",startTime);
            queryFilter.put("endTime",endTime);
            List<WeatherLog> weatherLogs = weatherLogMapper.selectByTime(queryFilter);
            resultDO.setModule(weatherLogs);
            resultDO.setSuccess(true);
        }catch (Throwable e)
        {
            log.error("query weatherlog by time filed.",e);
            resultDO.setErrorCode(Constants.getErrCode(Constants.ERR_DB_EXCEPTION,Constants.DEFAULT_ERROR_MESSAGE));
        }
        return  resultDO;
    }
}
