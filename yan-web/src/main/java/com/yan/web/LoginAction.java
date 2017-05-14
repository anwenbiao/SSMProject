package com.yan.web;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yan.entity.User;
import com.yan.servlet.UserService;

@Controller
public class LoginAction {
	
	private static final Log logger=LogFactory.getLog(LoginAction.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		System.out.println("我进来了");
		//获取文件你的绝对路径
		String path = request.getRequestURI();
		System.out.println("获取的绝对路径："+path);
		
		//获取当前jsp的路径
		path=request.getContextPath();
		System.out.println("获取当前jsp的路径");
		
		//获取当前项目的路径
		path=request.getServletPath();
		System.out.println("获取当前项目的路径："+path);
		
		//java获取当前classPath的路径
		path=LoginAction.class.getResource("").toString();
		System.out.println("java获取classPath的路径："+path);
		
		path=LoginAction.class.getResource(File.separator).toString();
		System.out.println("java获取classPath的路径："+path);
		
		path=LoginAction.class.getClassLoader().getResource("").toString();
		System.out.println("java获取classPath的路径："+path);
		
		path=LoginAction.class.getClassLoader().getResource(File.separator).toString();
		System.out.println("java获取classPath的路径："+path);
		
		//使用线程获取路径
		path=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		System.out.println("使用线程获取路径："+path);
		
		
		//用servlet获取路径
		//获取项目的绝对路径
		path=request.getSession().getServletContext().getRealPath(File.separator);
		System.out.println("获取项目的绝对路径："+path);
		
		//获取浏览器的地址
		path=request.getContextPath();
		System.out.println("获取浏览器的地址："+path);
		
		//获取当前文件的绝对路径
		path=request.getSession().getServletContext().getRealPath(request.getRequestURI());
		System.out.println("获取当前文件的绝对路径："+path);
		
		
		
		
		
		
		return "login";
	}
	
	@RequestMapping("/queryAll")
	
	@ResponseBody
	public User queryALL(User user,String str){
		logger.info("==============查询请求开始");
		System.out.println("***"+str);
		System.out.println("userName:"+user.getUserName());
		System.out.println("password:"+user.getPassword());
		//List<User> list = userService.queryAll();
		logger.debug("=============查询请求结束");
		
		
		return user;
	}
	
}
