package com.cn.tju.service.impl;

import com.cn.tju.IDao.AmmeterSettingMapper;
import com.cn.tju.pojo.AmmeterSetting;
import com.cn.tju.pojo.WeatherLog;
import com.cn.tju.service.AmmeterSettingService;
import com.cn.tju.util.Constants;
import com.cn.tju.util.ResultDO;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Search on 2016/12/1.
 */
@Slf4j
@Service
public class AmmeterSettingServiceImpl implements AmmeterSettingService{

    @Resource
    AmmeterSettingMapper ammeterSettingMapper;

    @Override
    public ResultDO<List<AmmeterSetting>> selectAllAmmeterSettingList() {
        log.warn("query all ammetersetting :{}");
        ResultDO<List<AmmeterSetting>> resultDO = new ResultDO<List<AmmeterSetting>>();
        try{
            List<AmmeterSetting> AmmeterSettings = ammeterSettingMapper.selectAllAMmeterSettings();
            resultDO.setModule(AmmeterSettings);
            resultDO.setSuccess(true);
        }catch (Throwable e)
        {
            log.error("query all ammetersetting  filed.",e);
            resultDO.setErrorCode(Constants.getErrCode(Constants.ERR_DB_EXCEPTION,Constants.DEFAULT_ERROR_MESSAGE));
        }
        return  resultDO;
    }
}
