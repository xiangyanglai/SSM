package com.cn.tju.IDao;

import com.cn.tju.pojo.Ammeter;
import com.cn.tju.pojo.AmmeterExample;
import java.util.List;

public interface AmmeterMapper {
    int countByExample(AmmeterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ammeter record);

    int insertSelective(Ammeter record);

    List<Ammeter> selectByExample(AmmeterExample example);

    List<Double> queryAmmeterTotalBySensorId(String sensorId);

    Ammeter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ammeter record);

    int updateByPrimaryKey(Ammeter record);
}