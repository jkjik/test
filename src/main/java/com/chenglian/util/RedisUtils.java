package com.chenglian.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * Created by lenovo on 2019/9/14.
 */
@Service
public class RedisUtils {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取
     * @param key
     * @return
     */
    public Object get(String key){
        return key == null ? null :redisTemplate.opsForValue().get(key);
    }

    /**
     * 添加
     * @param key
     * @param value
     * @return
     */
    public Boolean set(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * key是否存在
     * @param key
     * @return
     */
    public Boolean hasKay(String key){
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除
     * @param key
     */
    @SuppressWarnings("unchecked")
    public void del(String ... key){
        if(key!=null&&key.length>0){
            if(key.length==1){
                redisTemplate.delete(key[0]);
            }else{
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

}
