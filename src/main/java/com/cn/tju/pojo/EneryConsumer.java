package com.cn.tju.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 主机系统消耗统计pojo类
 * Created by Search on 2016/12/5.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EneryConsumer {

    /**
     * 时间
     */
    String dateTime;


    /**
     * 单位面积能耗
     */
    private double dwmjEnergy;

    /**
     * 空调主机COP
     */
    private double ktzjEnergy;

    /**
     * 空调系统能效
     */
    private double ktxtEnergy;
}
