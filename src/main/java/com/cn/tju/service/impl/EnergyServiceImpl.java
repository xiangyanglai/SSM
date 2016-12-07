package com.cn.tju.service.impl;

import com.cn.tju.IDao.AlarmMapper;
import com.cn.tju.IDao.AmmeterMapper;
import com.cn.tju.IDao.HotMapper;
import com.cn.tju.pojo.*;
import com.cn.tju.service.EnergyService;
import com.cn.tju.util.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.Oneway;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Search on 2016/12/6.
 */
@Slf4j
@Service
public class EnergyServiceImpl implements EnergyService{

    @Resource
    AmmeterMapper ammeterMapper;

    @Resource
    HotMapper  hotMapper;




    @Override
    public ResultDO<List<EneryConsumer>> selectAllEnergy(DataTablePageUtil dataTablePageUtil) {
        log.warn("query all energy :");
        ResultDO<List<EneryConsumer>> resultDO = new ResultDO<List<EneryConsumer>>();
        try {
            String periodType = dataTablePageUtil.getPeriodType();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();

            //保存汇总结果
            List<EneryConsumer> eneryConsumersList = new ArrayList<>();

            List<String> everydayList = AccountDate.getEveryday(sdf.format(dataTablePageUtil.getStartTime()), sdf.format(dataTablePageUtil.getEndTime()));

            switch (periodType) {
                case "byHour":
                    for (String oneDay : everydayList) {
                        try {
                            Date currentDate = sdf.parse(oneDay);
                            List<Date> everyHours = AccountDate.getEveryHour(currentDate);
                            for (Date oneHour : everyHours) {
                                //TODO
                                EneryConsumer energyConsumer = getEnergyConsumer(ammeterMapper, hotMapper, oneHour, AccountDate.addOneHour(oneHour), "byHour");
                                eneryConsumersList.add(energyConsumer);
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case "byMonth":
                    List<Date> everyMonths = AccountDate.getEveryMonth(dataTablePageUtil.getStartTime(), dataTablePageUtil.getEndTime());
                    for (Date oneMonth : everyMonths) {
                        //TODO
                        EneryConsumer energyConsumer = getEnergyConsumer(ammeterMapper, hotMapper, oneMonth, AccountDate.subOneHour(AccountDate.addOneMonth(oneMonth)),"byMonth");
                        eneryConsumersList.add(energyConsumer);
                    }

                    break;
                case "byDay":
                    for (String oneDay : everydayList) {
                        EneryConsumer tempEnergyConsumer = new EneryConsumer();
                        tempEnergyConsumer.setDateTime(oneDay);
                        try {
                            Date currentDate = sdf.parse(oneDay);
                            cal.setTime(currentDate);
                            cal.add(Calendar.DATE, -1);
                            Date startDate = DateCalUtil.getStartDate(cal).getTime();
                            EneryConsumer energyConsumer = getEnergyConsumer(ammeterMapper, hotMapper, startDate, AccountDate.subOneHour(currentDate), "byDay");
                            eneryConsumersList.add(energyConsumer);

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }

                    break;
            }
            resultDO.setSuccess(true);
            resultDO.setModule(eneryConsumersList);
        }catch (Throwable e)
        {
            log.error("查询出现问题，error：", e.toString());
            resultDO.setErrorCode(Constants.getErrCode(Constants.ERR_DB_EXCEPTION, Constants.DEFAULT_ERROR_MESSAGE));
        }
        return resultDO;
    }

    private EneryConsumer getEnergyConsumer(AmmeterMapper ammeterMapper, HotMapper hotMapper, Date startDate, Date currentDate, String periodType) {

        SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat sdfHour = new SimpleDateFormat("yyyy-MM-dd HH");
        EneryConsumer tempEnergyConsumer = new EneryConsumer();
        //TODO
        switch (periodType)
        {
            case "byDay":
                tempEnergyConsumer.setDateTime(sdfDay.format(startDate));
                break;
            case "byMonth":
                tempEnergyConsumer.setDateTime(sdfMonth.format(startDate));
                break;
            case "byHour":
                tempEnergyConsumer.setDateTime(sdfHour.format(startDate));
                break;

        }
        //获取一天的总能耗
        float totalEnergyByDay = getTotalEnergyByDay(ammeterMapper, startDate, currentDate, "WV0012");

        //设置平均能耗
        tempEnergyConsumer.setDwmjEnergy(totalEnergyByDay/ Constants.CALC_AREA);


        //主机能耗
        float zjEnergyByDay = getTotalEnergyByDay(ammeterMapper, startDate, currentDate, "W0017");

        //获取总热量
        float hotEnergyByDay = getHotEnergyByDay(hotMapper, startDate, currentDate, "R0001");

        //坐主机能耗是否为空的判定，若为空值为零
        if(Math.abs(zjEnergyByDay-0)<1e-6)
        {
            tempEnergyConsumer.setKtxtEnergy(0);
        }else{
            //设置空调COP
            tempEnergyConsumer.setKtxtEnergy(hotEnergyByDay/zjEnergyByDay);
        }

        //获取空调总能耗
        float ktEnergyByDay = getTotalEnergyByDay(ammeterMapper, startDate, currentDate, "WV0011");


        //坐空调总能耗是否为空的判定，若为空值为零
        if(Math.abs(ktEnergyByDay-0)<1e-6)
        {
            tempEnergyConsumer.setKtzjEnergy(0);
        }else{
            //设置空调COP
            tempEnergyConsumer.setKtzjEnergy(hotEnergyByDay/ktEnergyByDay);
        }
        return tempEnergyConsumer;
    }

    private float getTotalEnergyByDay(AmmeterMapper ammeterMapper, Date startDate, Date currentDate,String sensorId) {
        float totalEnergy;
        List<Ammeter> ktnhAmmeters = ammeterMapper.selectByExample(getQueryExample(startDate,currentDate,sensorId));
        totalEnergy = 0;
        for (Ammeter ktAmmeter: ktnhAmmeters)
        {
          totalEnergy+=ktAmmeter.getAmmeterTotal();
        }
        return totalEnergy;
    }

    private float getHotEnergyByDay(HotMapper hotMapper, Date startDate, Date currentDate,String sensorId) {
        float totalEnergy;
        List<Hot> ktnhAmmeters = hotMapper.selectByExample(getHotExample(startDate,currentDate,sensorId));
        totalEnergy = 0;
        for (Hot ktAmmeter: ktnhAmmeters)
        {
            totalEnergy+=ktAmmeter.getHotTotal();
        }
        return totalEnergy;
    }


    public AmmeterExample getQueryExample(Date startDate, Date currentDate,String sensorId)
    {
        AmmeterExample queryExample = new AmmeterExample();
        AmmeterExample.Criteria queryCriteria = queryExample.createCriteria();
        queryCriteria.andDatetimeBetween(startDate, currentDate);
        queryCriteria.andSensorIdEqualTo(sensorId);
        queryExample.or(queryCriteria);
        return queryExample;
    }


    public HotExample getHotExample(Date startDate, Date currentDate, String sensorId)
    {
        HotExample queryExample = new HotExample();
        HotExample.Criteria queryCriteria = queryExample.createCriteria();
        queryCriteria.andDatetimeBetween(startDate, currentDate);
        queryCriteria.andSensorIdEqualTo(sensorId);
        queryExample.or(queryCriteria);
        return queryExample;
    }

}
