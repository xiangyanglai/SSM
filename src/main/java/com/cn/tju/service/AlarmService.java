package com.cn.tju.service;

import com.cn.tju.pojo.Alarm;
import com.cn.tju.pojo.AlarmQueryParam;
import com.cn.tju.pojo.User;
import com.cn.tju.util.DataTablePageUtil;
import com.cn.tju.util.ResultDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 日志类操作service
 */

public interface AlarmService {

    /**
     * 获取所有alarms信息
     * @return
     */
    ResultDO<List<Alarm>> selectAllAlarms();

    /**
     * 根据过滤条件查询数据，其中过滤字段属性用Map存储
     * @param dataTablePageUtil
     * @return
     */
    ResultDO<List<Alarm>> selectAlarmsByMap(DataTablePageUtil dataTablePageUtil);

    /**
     * 根据过滤条件查询数据，其中过滤字段属性用List存储
     * @param dataTablePageUtil
     * @return
     */
    ResultDO<List<Alarm>> selectAlarmsByList(DataTablePageUtil dataTablePageUtil);

    /**
     * 根据过滤条件筛选出所有符合条件的数据总数
     * @param dataTablePageUtil
     * @return
     */
    ResultDO<Integer> getAlarmSizeByPara(DataTablePageUtil dataTablePageUtil);


    /**
     * 获取所有数据总数
     * @return
     */
    ResultDO<Integer> getTotalAlarmSize(DataTablePageUtil dataTablePageUtil);


    /**
     * 根据时间过滤查找alarms
     * @param queryParam
     * @return
     */
    ResultDO<List<Alarm>> selectAlarmsByTime(AlarmQueryParam queryParam);

    /**
     * 按页获取全部数据
     * @param dataTablePageUtil
     * @return
     */
    ResultDO<List<Alarm>> selectAllAlarmsPerpage(DataTablePageUtil dataTablePageUtil);


}  
