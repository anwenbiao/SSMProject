package com.yan.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 *
 * redis调用工具类:提供基础的set\delete
 *
 * 
 */
@Component
public class RedisUtil {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * redis提供的setNX函数，具有互斥的性质，可以用来设置一个标记判断唯一操作
     * @param key 标记名称，需要唯一
     * @return
     */
    public boolean setNX(final String key) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.setNX((key).getBytes(), key.getBytes());
            }
        });
    }

    /**
     * 封装redis的set方法,用于专门设置一个String类型缓存
     * @param key
     * @param value
     * @return
     */
    public boolean setString(final String key, final String value) {
        try {
            return redisTemplate.execute(new RedisCallback<Boolean>() {
                @Override
                public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                    connection.set(key.getBytes(), value.getBytes());
                    return true;
                }
            });
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * 封装redis的get方法，用于获取一个String类型缓存
     * @param key
     * @return
     */
    public String getString(final String key) {
        return redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] value = connection.get(key.getBytes());
                return value == null ? null : new String(value);
            }
        });
    }

    /**
     * 设置一个缓存的过期
     * @param key
     * @param timeout
     * @param timeUnit
     * @return
     */
    public boolean setExpire(String key, long timeout, TimeUnit timeUnit) {
        return redisTemplate.expire(key, timeout, timeUnit);
    }

    /**
     * 删除一个redis缓存
     * @param key
     * @return
     */
    public long deleteKey(final String key) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.del(key.getBytes());
            }
        });
    }

}
