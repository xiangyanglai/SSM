package com.cn.tju.service;

import com.cn.tju.pojo.Alarm;
import com.cn.tju.pojo.AlarmQueryParam;
import com.cn.tju.pojo.EneryConsumer;
import com.cn.tju.util.DataTablePageUtil;
import com.cn.tju.util.ResultDO;

import java.util.List;

/**
 * 日志类操作service
 */

public interface EnergyService {


    /**
     * 按页获取全部数据
     * @param dataTablePageUtil
     * @return
     */
    ResultDO<List<EneryConsumer>> selectAllEnergy(DataTablePageUtil dataTablePageUtil);


}  
