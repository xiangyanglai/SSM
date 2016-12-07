package com.cn.tju.service;

import com.cn.tju.pojo.EneryConsumer;
import com.cn.tju.pojo.TemperatureLog;
import com.cn.tju.util.DataTablePageUtil;
import com.cn.tju.util.ResultDO;

import java.util.Date;
import java.util.List;

/**
 * 室内环境温度service类
 */

public interface InroomService {


    /**
     * 按页获取全部数据
     * @param sensorId
     * @return
     */
    ResultDO<TemperatureLog> selectAllTemperature(String sensorId, Date queryDate);


}  
