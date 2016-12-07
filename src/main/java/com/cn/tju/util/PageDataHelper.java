package com.cn.tju.util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by search on 2016/11/15.
 */
@Data
@NoArgsConstructor
public class PageDataHelper<T> implements Serializable{

    private int sEcho;
    private int iTotalRecords;
    private int iTotalDisplayRecords;
    private List<T> aaData;
}
