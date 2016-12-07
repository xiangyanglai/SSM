package com.cn.tju.IDao;

import com.cn.tju.pojo.AmmeterLog;
import com.cn.tju.pojo.AmmeterLogExample;
import java.util.List;

public interface AmmeterLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmmeterLog record);

    int insertSelective(AmmeterLog record);

    List<AmmeterLog> selectByExample(AmmeterLogExample example);

    AmmeterLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmmeterLog record);

    int updateByPrimaryKey(AmmeterLog record);
}