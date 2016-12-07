package com.cn.tju.controller;

import com.alibaba.fastjson.JSON;
import com.cn.tju.IDao.PersonDao;
import com.cn.tju.IDao.WeatherLogMapper;
import com.cn.tju.pojo.*;
import com.cn.tju.service.AlarmService;
import com.cn.tju.service.EnergyService;
import com.cn.tju.service.InroomService;
import com.cn.tju.service.WeatherLogService;
import com.cn.tju.service.impl.WeatherLogServiceImpl;
import com.cn.tju.util.Constants;
import com.cn.tju.util.DataTablePageUtil;
import com.cn.tju.util.PageDataHelper;
import com.cn.tju.util.ResultDO;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by search on 2016/11/15.
 */
@Slf4j
@Controller
@RequestMapping("/data")
public class FetchDataController {
    @Resource
    AlarmService alarmServiceImpl;

    @Resource
    EnergyService energyServiceImpl;

    @Resource
    WeatherLogService weatherLogService;

    @Resource
    InroomService inroomServiceImpl;

    @RequestMapping(value = "/queryTem")
    @ResponseBody
    public String admin(HttpServletRequest request, Model model) {

        Preconditions.checkArgument(StringUtils.isNotBlank(request.getParameter("sensorId")),"传感器ID不能为空");
        Preconditions.checkArgument(StringUtils.isNotBlank(request.getParameter("queryDate")),"查询时间不能为空");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ResultDO<TemperatureLog> resultDO = new ResultDO<>();
        try{
            String sensorId = request.getParameter("sensorId");
            Date queryDate = sdf.parse(request.getParameter("queryDate"));
            resultDO = inroomServiceImpl.selectAllTemperature(sensorId, queryDate);
        } catch (ParseException e) {
            log.error("日期格式化失败");
        }

        return JSON.toJSONString(resultDO);
    }
    @RequestMapping(value = "/queryWeatherByTime")
    @ResponseBody
    public String queryWeatherByTime(HttpServletRequest request, Model model) {
        ResultDO<String> result = new ResultDO<String>();
        try {
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            Preconditions.checkArgument(StringUtils.isNotEmpty(startTime), Constants.getErrCode(Constants.ERR_PARAMETER_ERROR,"开始日期为空"));
            Preconditions.checkArgument(StringUtils.isNotEmpty(endTime), Constants.getErrCode(Constants.ERR_PARAMETER_ERROR,"结束日期为空"));
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);
            ResultDO<List<WeatherLog>> weatherLogList = weatherLogService.getWeatherLogByDatetime(startDate, endDate);
            return  JSON.toJSONString(weatherLogList);
        } catch (ParseException e) {
            log.error("query weatherlog by time failed,parameter error,",e);
            result.setErrorCode(Constants.getErrCode(Constants.ERR_PARAMETER_ERROR,"传入的日期格式不正确"));
            return JSON.toJSONString(result);
        }catch (Exception e)
        {
            log.error("query weatherlog by time failed,parameter error,",e);
            result.setErrorCode(Constants.getErrCode(Constants.ERR_PARAMETER_ERROR,e.toString()));
        }
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/queryEnergy")
    @ResponseBody
    public String queryData(HttpServletRequest request, Model model) {
        DataTablePageUtil myData = new DataTablePageUtil(request);
        PageDataHelper jsonData = new PageDataHelper();
        int totalSize;
        ResultDO<List<EneryConsumer>> listResultDO = null;
        ResultDO<Integer> integerResultDO = null;
        if(StringUtils.isNotEmpty(myData.getQueryType())) {
            myData.setConditionList(null);

            //myData中已经对相应的时间做处理，格式化了相应的时间
            listResultDO = energyServiceImpl.selectAllEnergy(myData);
        }

        if(listResultDO.isSuccess())
        {
            int size = listResultDO.getModule().size();
            jsonData.setSEcho(myData.getDraw());
            jsonData.setITotalRecords(size);
            jsonData.setITotalDisplayRecords(size);
            jsonData.setAaData(listResultDO.getModule());
        }else{
            //
            jsonData.setAaData(new ArrayList());
        }

        log.info(JSON.toJSONString(jsonData));
        return JSON.toJSONString(jsonData);
    }

    @RequestMapping(value = "/queryTemp")
    @ResponseBody
    public String queryTemp(HttpServletRequest request, Model model) {
        DataTablePageUtil myData = new DataTablePageUtil(request);
        PageDataHelper jsonData = new PageDataHelper();
        int totalSize;
        ResultDO<List<EneryConsumer>> listResultDO = null;
        ResultDO<Integer> integerResultDO = null;
        if (StringUtils.isNotEmpty(myData.getQueryType())) {
            myData.setConditionList(null);

            //myData中已经对相应的时间做处理，格式化了相应的时间
            listResultDO = energyServiceImpl.selectAllEnergy(myData);
        }

        if (listResultDO.isSuccess()) {
            int size = listResultDO.getModule().size();
            jsonData.setSEcho(myData.getDraw());
            jsonData.setITotalRecords(size);
            jsonData.setITotalDisplayRecords(size);
            jsonData.setAaData(listResultDO.getModule());
        } else {
            //
            jsonData.setAaData(new ArrayList());
        }

        log.info(JSON.toJSONString(jsonData));
        return JSON.toJSONString(jsonData);
    }

}
