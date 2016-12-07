package com.cn.tju.IDao;

import com.cn.tju.pojo.Alarm;
import com.cn.tju.util.DataTablePageUtil;
import com.cn.tju.util.ResultDO;

import java.util.HashMap;
import java.util.List;

public interface AlarmMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Alarm record);

    int insertSelective(Alarm record);

    Alarm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Alarm record);

    int updateByPrimaryKey(Alarm record);

    List<Alarm> selectAllAlarms();

    /**
     * 根据具体请求查询数据并分页处理,需要过滤的字段类型为List
     * @param dataTablePageUtil
     * @return
     */
    List<Alarm> selectAlarmsByPage(DataTablePageUtil dataTablePageUtil);

    /**
     * 根据具体请求查询数据并分页处理,需要过滤的字段类型为Map
     * @param dataTablePageUtil
     * @return
     */
    List<Alarm> selectAlarmsByPageMap(DataTablePageUtil dataTablePageUtil);

    /**
     * 根据具体请求获取符合条件的数据总数
     * @param dataTablePageUtil
     * @return
     */
    Integer getAlarmSizeByPara(DataTablePageUtil dataTablePageUtil);

    /**
     * 获取全部数据总数
     * @return
     */
    Integer getTotalAlarmSize(DataTablePageUtil dataTablePageUtil);

    /**
     * 根据时间过滤alarms集合
     * @param queryParams
     * @return
     */
    List<Alarm> selectAlarmsByTime(HashMap<String,Object> queryParams);


    List<Alarm> selectAllAlarmsPerpage(DataTablePageUtil dataTablePageUtil);


}