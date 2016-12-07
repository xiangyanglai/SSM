package com.cn.tju.IDao;

import com.cn.tju.pojo.AmmeterVirtual;

public interface AmmeterVirtualMapper {
    int deleteByPrimaryKey(String ammetervirtualId);

    int insert(AmmeterVirtual record);

    int insertSelective(AmmeterVirtual record);

    AmmeterVirtual selectByPrimaryKey(String ammetervirtualId);

    int updateByPrimaryKeySelective(AmmeterVirtual record);

    int updateByPrimaryKey(AmmeterVirtual record);
}