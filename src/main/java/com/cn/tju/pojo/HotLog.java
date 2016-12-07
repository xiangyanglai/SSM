package com.cn.tju.pojo;

/**
 * Created by Search on 2016/11/22.
 */

import lombok.Data;

import java.util.Date;

/**
 * HotLog数据表
 */
@Data
public class HotLog {

    private int id;
    /**
     * 热表编码
     */
    private String sensorID;
    /**
     * 出水温度
     */
    private float hotOutTerm;
    /**
     * 回水温度
     */
    private float hotInTerm;
    /**
     * 当前流量
     */
    private float hotFLow;
    /**
     * 总能耗
     */
    private float hotTotal;
    /**
     * 采集时间
     */
    private Date datetime;
}
