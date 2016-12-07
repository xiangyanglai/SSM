package com.cn.tju.IDao;

import com.cn.tju.pojo.Hot;
import com.cn.tju.pojo.HotExample;
import java.util.List;

public interface HotMapper {
    int countByExample(HotExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Hot record);

    int insertSelective(Hot record);

    List<Hot> selectByExample(HotExample example);

    Hot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hot record);

    int updateByPrimaryKey(Hot record);

    Float queryHotTotalBySensorId(String sensorId);
}