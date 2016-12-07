package com.cn.tju.util;

/**
 * Created by search on 2016/11/14.
 */

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * DataTablePageUtil的copy版本，区别在于此类输入依赖前台设定要访问的值，
 * 秉持着永远不要相信前台的原则，此种设计忽略，DataTablePageUtil版本中的
 * 要过滤的条件依赖于手动设定
 */
@Data
@Slf4j
public class DataTablePageUtilCopy {

    private int draw; // 第几次请求
    private int start = Constants.IDISPLAYSTART;// 起止位置'0'
    private int length = Constants.DISPLAYLENGTH; // 数据长度'10'
    private String searchData;

    private Map<String, Object> condition = new HashedMap();

    public DataTablePageUtilCopy() {

    }

    public DataTablePageUtilCopy(HttpServletRequest request) {
        requestHandler(request);
    }

    public DataTablePageUtilCopy(HttpServletRequest request, List<String> paramFilter) {
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
        List<String> allColumnNames = Lists.newArrayList();
        List<String> searchColumnNames = Lists.newArrayList();
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
                if(aoData.get(i).get("name").equals("sColumns"))
                {
                    if(StringUtils.isNotEmpty(aoData.get(i).get("value")))
                    {
                        String[] tempColumns = aoData.get(i).get("value").split(",");
                        for(String temp: tempColumns)
                        {
                              allColumnNames.add(temp);
                        }
                        if(aoData.get(i).get("value").endsWith(","))
                            allColumnNames.add("");

                    }

                }
                if (aoData.get(i).get("name").contains("bSearchable_"))
                {
                    if(aoData.get(i).get("value").equals("true"))
                    {
                        try{
                            int index = Integer.parseInt(aoData.get(i).get("name").split("_")[1]);
                            if(StringUtils.isNotEmpty(allColumnNames.get(index)))
                            {
                                searchColumnNames.add(allColumnNames.get(index));
                            }
                        }catch (Exception e)
                        {
                            log.error("转换查询列下标出现错误，可能是由于用户输入包含search");
                            e.printStackTrace();
                        }
                    }

                }
            }
            //将所获取到可查询的值加入过滤列表
            if(StringUtils.isNotEmpty(searchData))
            {
               if(searchColumnNames.size()>0) {
                   for (int i = 0; i < searchColumnNames.size(); i++) {
                       condition.put(searchColumnNames.get(i), searchData);
                   }
               }
            }
        }
    }

}

