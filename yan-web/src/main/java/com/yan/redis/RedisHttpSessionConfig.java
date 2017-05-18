package com.yan.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import redis.clients.jedis.JedisShardInfo;


/**
 * Created by 安文彪
 *
 * HttpSession 与redis集群关联代码
 *
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 7200)
public class RedisHttpSessionConfig {

    /**
     * redis sentinel 名称
     */
    @Value("${spring.session.redis.sentinel.name}")
    private String name;

    /**
     * redis sentinel 连接
     */
    @Value("${spring.session.redis.sentinel.connections}")
    private String connections;

    /**
     * redis 连接构造 哨兵
     * @return
     */
/*    @Bean
    public RedisConnectionFactory connectionFactory() {

        RedisSentinelConfiguration sentinelConfiguration = new RedisSentinelConfiguration();
        sentinelConfiguration.master(this.name);

        String[] urls = connections.split("\\|");
        if (urls != null && urls.length > 0) {
            for (String url : urls) {
                String ip = url.split(":")[0];
                Integer port = Integer.parseInt(url.split(":")[1]);
                sentinelConfiguration.sentinel(ip, port);
            }
        }
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(sentinelConfiguration);

        return connectionFactory;
    }*/
    
    @Bean
    public RedisConnectionFactory connectionRedis(){
    	//如果是本地的话shardInfo不用设置也可以在JedisConnectionFactory中给出了默认值及 localhost:6379
    	JedisShardInfo shardInfo=new JedisShardInfo("127.0.0.1","6379");
    	 JedisConnectionFactory connectionFactory = new JedisConnectionFactory(shardInfo);

         return connectionFactory;
    }
}
