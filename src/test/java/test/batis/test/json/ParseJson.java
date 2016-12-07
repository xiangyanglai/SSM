package test.batis.test.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.cn.tju.util.PageDataHelper;
import com.cn.tju.util.ResultDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by search on 2016/11/14.
 */
public class ParseJson {
    public static void main(String[] args) {
      /* String source = "[{'name':'sEcho','value':2},{'name':'iColumns','value':5},{'name':'sColumns','value':',,,,'},{'name':'iDisplayStart','value':0},{'name':'iDisplayLength','value':20},{'name':'mDataProp_0','value':'id'},{'name':'sSearch_0','value':''},{'name':'bRegex_0','value':false},{'name':'bSearchable_0','value':true},{'name':'bSortable_0','value':true},{'name':'mDataProp_1','value':'title'},{'name':'sSearch_1','value':''},{'name':'bRegex_1','value':false},{'name':'bSearchable_1','value':true},{'name':'bSortable_1','value':true},{'name':'mDataProp_2','value':'description'},{'name':'sSearch_2','value':''},{'name':'bRegex_2','value':false},{'name':'bSearchable_2','value':true},{'name':'bSortable_2','value':true},{'name':'mDataProp_3','value':'createTime'},{'name':'sSearch_3','value':''},{'name':'bRegex_3','value':false},{'name':'bSearchable_3','value':true},{'name':'bSortable_3','value':true},{'name':'mDataProp_4','value':'id'},{'name':'sSearch_4','value':''},{'name':'bRegex_4','value':false},{'name':'bSearchable_4','value':true},{'name':'bSortable_4','value':true},{'name':'sSearch','value':'a'},{'name':'bRegex','value':false},{'name':'iSortCol_0','value':0},{'name':'sSortDir_0','value':'asc'},{'name':'iSortingCols','value':1}]" ;
        List<Map<String, String>> maps = JSONObject.parseObject(source, new TypeReference<List<Map<String, String>>>() {
        });
        for (int i =0;i<maps.size();i++)
        {
            System.out.println(maps.get(i).get("name")+":"+maps.get(i).get("value"));
        }*/
     /*   PageDataHelper test = new PageDataHelper();
        List myList = new ArrayList();
        System.out.println(JSON.toJSON(test))*/;

        ResultDO result = new ResultDO();
        result.setModule("success");
        result.setSuccess(true);
        System.out.println( JSON.toJSONString(result));

    }
}
