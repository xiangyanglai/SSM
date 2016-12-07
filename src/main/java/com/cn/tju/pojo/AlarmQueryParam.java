package com.cn.tju.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Created by Search on 2016/12/4.
 */
@Data
public class AlarmQueryParam {
   String queryType;
   Date startTime;
   Date endTime;
}
