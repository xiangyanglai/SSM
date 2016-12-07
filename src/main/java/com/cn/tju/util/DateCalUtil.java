package com.cn.tju.util;

import com.cn.tju.pojo.Alarm;
import com.cn.tju.pojo.AlarmQueryParam;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Search on 2016/12/4.
 */

/**
 * 日期操作工具类
 * 获取当天，当周，当月，当季度，当年时间
 */
@Slf4j
public class DateCalUtil {
    /**
     * 获取当前日期与周一相差的天数
     * @return
     */
    public static int getMondayPlus(){
        Calendar day=Calendar.getInstance();
        int dayOfWeek=day.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek==1){ //一周中第一天（周日）
            return -6;
        }else{
            return 2-dayOfWeek;
        }
    }
    /**
     * 获得当天的起始时间
     * @return
     */
    public static Calendar getStartDate(Calendar today){
        today.set(Calendar.HOUR_OF_DAY,0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        return today;
    }
    /**
     * 获取当天截止时间
     * @return
     */
    public static Calendar getEndDate(Calendar endToday){
        endToday.set(Calendar.HOUR_OF_DAY, 23);
        endToday.set(Calendar.MINUTE, 59);
        endToday.set(Calendar.SECOND, 59);
        endToday.set(Calendar.MILLISECOND, 59);
        return endToday;
    }
    /**
     * 获得当月起始时间
     * @return
     */
    public static Calendar getStartMounth(Calendar today){
        Calendar calendar = getStartDate(today);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar;
    }
    /**
     * 获得当月结束时间
     * @return
     */
    public static Calendar getEndMounth(Calendar endToday){
        Calendar endMounth=getEndDate(endToday);
        endMounth.set(Calendar.DAY_OF_MONTH, endMounth.getActualMaximum(endMounth.DAY_OF_MONTH));
        return endMounth;
    }
    /**
     * 获取当前季度 起始时间
     * @return
     */
    public static Calendar getStartQuarter(Calendar today){
        int currentMonth = today.get(Calendar.MONTH) + 1;
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                today.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                today.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                today.set(Calendar.MONTH, 4);
            else if (currentMonth >= 10 && currentMonth <= 12)
                today.set(Calendar.MONTH, 9);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return today;
    }
    /**
     * 获取当季的结束时间
     */
    public static Calendar getEndQuarter(Calendar today){
        int currentMonth = today.get(Calendar.MONTH) + 1;
        try {
            if (currentMonth >= 1 && currentMonth <= 3) {
                today.set(Calendar.MONTH, 2);
                today.set(Calendar.DATE, 31);
            } else if (currentMonth >= 4 && currentMonth <= 6) {
                today.set(Calendar.MONTH, 5);
                today.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 9) {
                today.set(Calendar.MONTH,8);
                today.set(Calendar.DATE, 30);
            } else if (currentMonth >= 10 && currentMonth <= 12) {
                today.set(Calendar.MONTH, 11);
                today.set(Calendar.DATE, 31);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return today;
    }
    /**
     * 获取当年起始时间
     */
    public static Calendar getStartYear(Calendar today){
        try {
            today.set(Calendar.MONTH, 0);
            today.set(Calendar.DAY_OF_MONTH, today.getActualMinimum(Calendar.DAY_OF_MONTH));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return today;
    }
    /**
     * 获取当年结束时间
     */
    public static Calendar getEndYear(Calendar today){
        try {
            today.set(Calendar.MONTH, 11);
            today.set(Calendar.DAY_OF_MONTH, today.getMaximum(Calendar.DAY_OF_MONTH));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return today;
    }

    public static  void formatAlarmQueryParam(AlarmQueryParam queryParam)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date startTime = null;
        Date endTime = null;
        Date nowDate = new Date();
        try {
            cal.setTime(sdf.parse(sdf.format(nowDate)));
            endTime = nowDate;
            switch (queryParam.getQueryType()) {
                case "byWeek":
                    cal.set(Calendar.DATE, cal.get(Calendar.DATE) + DateCalUtil.getMondayPlus());
                    startTime = cal.getTime();
                    break;
                case "byMonth":
                    startTime = DateCalUtil.getStartMounth(cal).getTime();
                    break;
                case "byYear":
                    startTime = DateCalUtil.getStartYear(cal).getTime();
                    break;
                case "custom":
                    startTime = queryParam.getStartTime();
                    endTime = queryParam.getEndTime();
                    break;
                case "all":
                    startTime = null;
                    endTime = null;
                    break;
                default:
                    cal.add(Calendar.DATE, -1);
                    startTime = DateCalUtil.getStartDate(cal).getTime();
                    endTime = nowDate;
            }
        }catch (Exception e)
        {
            log.error("日期格式转换出现错误：{}",e.toString());
        }
        queryParam.setStartTime(startTime);
        queryParam.setEndTime(endTime);
    }
}
