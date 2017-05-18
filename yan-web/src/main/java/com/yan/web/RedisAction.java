package com.yan.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yan.redis.RedisUtil;
/**
 * ���ǲ���redis
 * @author ���ı�
 *
 */
@Controller
@RequestMapping("/redisAction")
public class RedisAction {
	
	private static final Log logger=LogFactory.getLog(RedisAction.class);
	@Autowired
	RedisUtil redisUtil;
	@RequestMapping("/setRedis")
	public String setRedis(){
		
		if(redisUtil.getString("user")!=null&&redisUtil.getString("user").length()>0){
			String user = redisUtil.getString("user");
			logger.info("��redis�ж�ȡ���ݣ�"+user);
			return "success1";
		}
		
		redisUtil.setString("user", "���ı�");
		logger.info("redis����user��ֵ��"+redisUtil.getString("user"));
		
		return "success";
	}

}
