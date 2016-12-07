package com.cn.tju.IDao;

import com.cn.tju.pojo.TemperatureLog;
import com.cn.tju.pojo.TemperatureLogExample;
import java.util.List;

public interface TemperatureLogMapper {
    int countByExample(TemperatureLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TemperatureLog record);

    int insertSelective(TemperatureLog record);

    List<TemperatureLog> selectByExample(TemperatureLogExample example);

    TemperatureLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TemperatureLog record);

    int updateByPrimaryKey(TemperatureLog record);
}