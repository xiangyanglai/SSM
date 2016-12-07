package com.cn.tju.service.impl;

import com.cn.tju.IDao.AlarmMapper;
import com.cn.tju.pojo.Alarm;
import com.cn.tju.pojo.AlarmQueryParam;
import com.cn.tju.pojo.AmmeterSetting;
import com.cn.tju.service.AlarmService;
import com.cn.tju.util.Constants;
import com.cn.tju.util.DataTablePageUtil;
import com.cn.tju.util.DateCalUtil;
import com.cn.tju.util.ResultDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Search on 2016/12/3.
 */

@Slf4j
@Service
public class AlarmServiceImpl implements AlarmService {

    @Resource
    AlarmMapper alarmMapper;


    @Override
    public ResultDO<List<Alarm>> selectAllAlarms() {
        log.warn("query all alarms :");
        ResultDO<List<Alarm>> resultDO = new ResultDO<List<Alarm>>();
        try {
            List<Alarm> alarms = alarmMapper.selectAllAlarms();
            resultDO.setModule(alarms);
            resultDO.setSuccess(true);
        } catch (Throwable e) {
            log.error("query all alarms  filed.", e);
            resultDO.setErrorCode(Constants.getErrCode(Constants.ERR_DB_EXCEPTION, Constants.DEFAULT_ERROR_MESSAGE));
        }
        return resultDO;
    }

    @Override
    public ResultDO<List<Alarm>> selectAlarmsByMap(DataTablePageUtil dataTablePageUtil) {
        log.warn("query all alarms by para :{}", dataTablePageUtil.toString());
        ResultDO<List<Alarm>> resultDO = new ResultDO<List<Alarm>>();
        try {
            List<Alarm> alarms = alarmMapper.selectAlarmsByPageMap(dataTablePageUtil);
            resultDO.setModule(alarms);
            resultDO.setSuccess(true);
        } catch (Throwable e) {
            log.error("query  alarms  filed.", e);
            resultDO.setErrorCode(Constants.getErrCode(Constants.ERR_DB_EXCEPTION, Constants.DEFAULT_ERROR_MESSAGE));
        }
        return resultDO;
    }

    @Override
    public ResultDO<List<Alarm>> selectAlarmsByList(DataTablePageUtil dataTablePageUtil) {
        log.warn("query all alarms by para :{}", dataTablePageUtil.toString());
        ResultDO<List<Alarm>> resultDO = new ResultDO<List<Alarm>>();
        try {
            List<Alarm> alarms = alarmMapper.selectAlarmsByPage(dataTablePageUtil);
            resultDO.setModule(alarms);
            resultDO.setSuccess(true);
        } catch (Throwable e) {
            log.error("query  alarms  filed.", e);
            resultDO.setErrorCode(Constants.getErrCode(Constants.ERR_DB_EXCEPTION, Constants.DEFAULT_ERROR_MESSAGE));
        }
        return resultDO;
    }

    @Override
    public ResultDO<Integer> getAlarmSizeByPara(DataTablePageUtil dataTablePageUtil) {

        log.warn("query all alarms size by para :{}", dataTablePageUtil.toString());
        ResultDO<Integer> resultDO = new ResultDO<Integer>();
        try {
            Integer alarmSizeByPara = alarmMapper.getAlarmSizeByPara(dataTablePageUtil);
            resultDO.setModule(alarmSizeByPara);
            resultDO.setSuccess(true);
        } catch (Throwable e) {
            log.error("query  alarms  filed.", e);
            resultDO.setErrorCode(Constants.getErrCode(Constants.ERR_DB_EXCEPTION, Constants.DEFAULT_ERROR_MESSAGE));
        }
        return resultDO;
    }

    @Override
    public ResultDO<Integer> getTotalAlarmSize(DataTablePageUtil dataTablePageUtil) {
        log.warn("query all alarms size");
        ResultDO<Integer> resultDO = new ResultDO<Integer>();
        try {
            Integer alarmSizeByPara = alarmMapper.getTotalAlarmSize(dataTablePageUtil);
            resultDO.setModule(alarmSizeByPara);
            resultDO.setSuccess(true);
        } catch (Throwable e) {
            log.error("query  alarms  filed.", e);
            resultDO.setErrorCode(Constants.getErrCode(Constants.ERR_DB_EXCEPTION, Constants.DEFAULT_ERROR_MESSAGE));
        }
        return resultDO;
    }

    @Override
    public ResultDO<List<Alarm>> selectAlarmsByTime(AlarmQueryParam queryParam) {
        log.warn("query  alarms by time");
        ResultDO<List<Alarm>> resultDO = new ResultDO<List<Alarm>>();
        DateCalUtil.formatAlarmQueryParam(queryParam);
        HashMap<String, Object> queryFilter = new HashMap<String, Object>();
        queryFilter.put("startTime", queryParam.getStartTime());
        queryFilter.put("endTime", queryParam.getEndTime());
        List<Alarm> weatherLogs = alarmMapper.selectAlarmsByTime(queryFilter);
        resultDO.setModule(weatherLogs);
        resultDO.setSuccess(true);

        return resultDO;
    }

    @Override
    public ResultDO<List<Alarm>> selectAllAlarmsPerpage(DataTablePageUtil dataTablePageUtil) {
        log.warn("query all alarms by para :{}", dataTablePageUtil.toString());
        ResultDO<List<Alarm>> resultDO = new ResultDO<List<Alarm>>();
        try {
            List<Alarm> alarms = alarmMapper.selectAllAlarmsPerpage(dataTablePageUtil);
            resultDO.setModule(alarms);
            resultDO.setSuccess(true);
        } catch (Throwable e) {
            log.error("query  alarms  filed.", e);
            resultDO.setErrorCode(Constants.getErrCode(Constants.ERR_DB_EXCEPTION, Constants.DEFAULT_ERROR_MESSAGE));
        }
        return resultDO;
    }
}
