package com.cn.tju.IDao;

import com.cn.tju.pojo.EnergySecond;

public interface EnergySecondMapper {
    int deleteByPrimaryKey(Integer energysecondId);

    int insert(EnergySecond record);

    int insertSelective(EnergySecond record);

    EnergySecond selectByPrimaryKey(Integer energysecondId);

    int updateByPrimaryKeySelective(EnergySecond record);

    int updateByPrimaryKey(EnergySecond record);
}