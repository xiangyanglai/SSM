package com.cn.tju.IDao;

import com.cn.tju.pojo.AmmeterSetting;
import com.cn.tju.pojo.AmmeterSettingExample;
import java.util.List;

public interface AmmeterSettingMapper {
    int countByExample(AmmeterSettingExample example);

    int deleteByPrimaryKey(String ammeterId);

    int insert(AmmeterSetting record);

    int insertSelective(AmmeterSetting record);

    List<AmmeterSetting> selectByExample(AmmeterSettingExample example);

    List<AmmeterSetting> selectAllAMmeterSettings();

    AmmeterSetting selectByPrimaryKey(String ammeterId);

    int updateByPrimaryKeySelective(AmmeterSetting record);

    int updateByPrimaryKey(AmmeterSetting record);
}