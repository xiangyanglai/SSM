package com.cn.tju.IDao;

import com.cn.tju.pojo.WeatherLog;

import java.util.HashMap;
import java.util.List;

public interface WeatherLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeatherLog record);

    int insertSelective(WeatherLog record);

    WeatherLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeatherLog record);

    int updateByPrimaryKey(WeatherLog record);

    List<WeatherLog> selectByTime(HashMap map);
}