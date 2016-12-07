package com.cn.tju.util;

/**
 * Created by search on 2016/11/14.
 */

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.cn.tju.pojo.AlarmQueryParam;
import com.cn.tju.pojo.AlarmQueryType;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Data
@Slf4j
@ToString
public class DataTablePageUtil {

    private int draw; // 第几次请求
    private int start = Constants.IDISPLAYSTART;// 起止位置'0'
    private int length = Constants.DISPLAYLENGTH; // 数据长度'10'
    private String searchData;
    private String queryType;
    private String periodType;
    private Date startTime = null;
    private Date endTime = null;

    private Map<String, String> condition = new HashedMap();
    private List<String> conditionList = new ArrayList<>();

    public DataTablePageUtil() {

    }

    public DataTablePageUtil(HttpServletRequest request) {
        requestHandler(request);
    }

    public DataTablePageUtil(HttpServletRequest request,List<String> paramFilter) {
        requestHandler(request);
        if(CollectionUtils.isNotEmpty(paramFilter)&&StringUtils.isNotBlank(this.searchData))
        {
            for (int i = 0; i < paramFilter.size(); i++) {
               this.condition.put(paramFilter.get(i),this.searchData);
            }
        }
    }


    private void requestHandler(HttpServletRequest request) {
        String source = request.getParameter("formData");
        String startTime = null;
        String endTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (StringUtils.isNotBlank(source)) {
            List<Map<String, String>> aoData = JSONObject.parseObject(source, new TypeReference<List<Map<String, String>>>() {
            });
            for (int i =0;i<aoData.size();i++)
            {
                if (aoData.get(i).get("name").equals("sEcho"))
                    this.setDraw(Integer.parseInt(aoData.get(i).get("value")));

                if (aoData.get(i).get("name").equals("iDisplayStart"))
                    this.setStart(Integer.parseInt(aoData.get(i).get("value")));

                if (aoData.get(i).get("name").equals("iDisplayLength"))
                    this.setLength(Integer.parseInt(aoData.get(i).get("value")));
                if (aoData.get(i).get("name").equals("sSearch"))
                {
                    searchData = aoData.get(i).get("value");
                }
                if (aoData.get(i).get("name").equals("startTime"))
                {
                    startTime = aoData.get(i).get("value");
                }
                if (aoData.get(i).get("name").equals("endTime"))
                {
                    endTime = aoData.get(i).get("value");
                }
                if (aoData.get(i).get("name").equals("periodType"))
                {
                    periodType = aoData.get(i).get("value");
                }
                if (aoData.get(i).get("name").equals("queryType"))
                {
                    String tempQueryType = aoData.get(i).get("value");
                    if(AlarmQueryType.isContain(tempQueryType))
                    {
                        queryType = tempQueryType;
                    }
                }
            }
        }

        AlarmQueryParam myQueryParam = new AlarmQueryParam();
        myQueryParam.setQueryType(queryType);
        if(queryType.equals("custom"))
        {
            try {
                myQueryParam.setStartTime(sdf.parse(startTime));
                myQueryParam.setEndTime(sdf.parse(endTime));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        DateCalUtil.formatAlarmQueryParam(myQueryParam);
        this.startTime = myQueryParam.getStartTime();
        this.endTime = myQueryParam.getEndTime();
    }

}

