package com.cn.tju.IDao;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by search on 2016/11/12.
 */
public class MessageDelegateListenerImpl implements MessageDelegateListener {

    public void handleMessage(Serializable message) {
        System.out.println("**message**");
        //什么都不做,只输出
        if(message == null){
            System.out.println("**message*2");
            System.out.println("null");
        } else if(message.getClass().isArray()){
            System.out.println("**message*3");
            System.out.println(Arrays.toString((Object[])message));
        } else if(message instanceof List<?>) {
            System.out.println("**message*4");
            System.out.println(message);
        } else if(message instanceof Map<? , ?>) {
            System.out.println("**message*5");
            System.out.println(message);
        } else {
            System.out.println("**message*6");
            System.out.println(ToStringBuilder.reflectionToString(message));
        }
    }
}
