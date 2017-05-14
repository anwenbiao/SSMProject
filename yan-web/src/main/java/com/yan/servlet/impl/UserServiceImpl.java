package com.yan.servlet.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yan.dao.BaseDao;
import com.yan.dao.UserDao;
import com.yan.entity.User;
import com.yan.servlet.UserService;

@Service
public class UserServiceImpl extends BaseServiceAbstract<User> implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public BaseDao<User> getDao() {
		return userDao;
	}

}
