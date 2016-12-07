package com.cn.tju.service.impl;

import com.cn.tju.IDao.TemperatureLogMapper;
import com.cn.tju.pojo.*;
import com.cn.tju.service.InroomService;
import com.cn.tju.util.AccountDate;
import com.cn.tju.util.Constants;
import com.cn.tju.util.DateCalUtil;
import com.cn.tju.util.ResultDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Search on 2016/12/7.
 */
@Slf4j
@Service
public class InroomServiceImpl implements InroomService {

    @Resource
    TemperatureLogMapper temperatureLogMapper;

    @Override
    public ResultDO<TemperatureLog> selectAllTemperature(String sensorId, Date queryDate) {
        log.warn("query all temperature :");
        ResultDO<TemperatureLog> resultDO = new ResultDO<TemperatureLog>();
        try {

            TemperatureLogExample queryExample = new TemperatureLogExample();
            TemperatureLogExample.Criteria queryCriteria = queryExample.createCriteria();
            queryCriteria.andSensorIdEqualTo(sensorId);
            queryCriteria.andDatetimeBetween(AccountDate.subOneHour(queryDate),AccountDate.addOneHour(queryDate));
            queryExample.or(queryCriteria);
            List<TemperatureLog> temperatureLogs = temperatureLogMapper.selectByExample(queryExample);
            if(temperatureLogs.size()>=1)
            {
                resultDO.setModule(temperatureLogs.get(0));
                resultDO.setSuccess(true);
            }
        } catch (Throwable e) {
            log.error("query all temperature  filed.", e);
            resultDO.setErrorCode(Constants.getErrCode(Constants.ERR_DB_EXCEPTION, Constants.DEFAULT_ERROR_MESSAGE));
        }
        return resultDO;
    }
}
