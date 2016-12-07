package com.cn.tju.service;

import com.cn.tju.pojo.AmmeterSetting;
import com.cn.tju.pojo.User;
import com.cn.tju.util.ResultDO;

import java.util.List;

public interface AmmeterSettingService {

	public ResultDO<List<AmmeterSetting>> selectAllAmmeterSettingList();

}  
