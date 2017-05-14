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
		System.out.println("�ҽ�����");
		//��ȡ�ļ���ľ���·��
		String path = request.getRequestURI();
		System.out.println("��ȡ�ľ���·����"+path);
		
		//��ȡ��ǰjsp��·��
		path=request.getContextPath();
		System.out.println("��ȡ��ǰjsp��·��");
		
		//��ȡ��ǰ��Ŀ��·��
		path=request.getServletPath();
		System.out.println("��ȡ��ǰ��Ŀ��·����"+path);
		
		//java��ȡ��ǰclassPath��·��
		path=LoginAction.class.getResource("").toString();
		System.out.println("java��ȡclassPath��·����"+path);
		
		path=LoginAction.class.getResource(File.separator).toString();
		System.out.println("java��ȡclassPath��·����"+path);
		
		path=LoginAction.class.getClassLoader().getResource("").toString();
		System.out.println("java��ȡclassPath��·����"+path);
		
		path=LoginAction.class.getClassLoader().getResource(File.separator).toString();
		System.out.println("java��ȡclassPath��·����"+path);
		
		//ʹ���̻߳�ȡ·��
		path=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		System.out.println("ʹ���̻߳�ȡ·����"+path);
		
		
		//��servlet��ȡ·��
		//��ȡ��Ŀ�ľ���·��
		path=request.getSession().getServletContext().getRealPath(File.separator);
		System.out.println("��ȡ��Ŀ�ľ���·����"+path);
		
		//��ȡ������ĵ�ַ
		path=request.getContextPath();
		System.out.println("��ȡ������ĵ�ַ��"+path);
		
		//��ȡ��ǰ�ļ��ľ���·��
		path=request.getSession().getServletContext().getRealPath(request.getRequestURI());
		System.out.println("��ȡ��ǰ�ļ��ľ���·����"+path);
		
		
		
		
		
		
		return "login";
	}
	
	@RequestMapping("/queryAll")
	
	@ResponseBody
	public User queryALL(User user,String str){
		logger.info("==============��ѯ����ʼ");
		System.out.println("***"+str);
		System.out.println("userName:"+user.getUserName());
		System.out.println("password:"+user.getPassword());
		//List<User> list = userService.queryAll();
		logger.debug("=============��ѯ�������");
		
		
		return user;
	}
	
}
