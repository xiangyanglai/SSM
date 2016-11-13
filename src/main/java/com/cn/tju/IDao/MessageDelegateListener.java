package com.cn.tju.IDao;

import java.io.Serializable;

/**
 * Created by search on 2016/11/12.
 */
public interface MessageDelegateListener {
     void handleMessage(Serializable message);
}
