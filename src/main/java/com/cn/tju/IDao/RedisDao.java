package com.cn.tju.IDao;

import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

/**
 * Created by search on 2016/11/12.
 */
public interface RedisDao {
    void sendMessage(String channel, Serializable message);


    RedisTemplate getRedisTemplate();

    void setRedisTemplate(RedisTemplate redisTemplate);
}
