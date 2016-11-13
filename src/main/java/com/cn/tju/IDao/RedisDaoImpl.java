package com.cn.tju.IDao;

import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

/**
 * Created by search on 2016/11/12.
 */
public class RedisDaoImpl implements RedisDao{

    private RedisTemplate<String, Object> redisTemplate = null;

    public RedisDaoImpl() {

    }

    public void sendMessage(String channel, Serializable message) {
        redisTemplate.convertAndSend(channel, message);
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
