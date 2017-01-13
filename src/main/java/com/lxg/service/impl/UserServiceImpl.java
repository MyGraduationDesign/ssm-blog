package com.lxg.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxg.dao.UserDao;
import com.lxg.entity.User;
import com.lxg.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;
	
	public User find() {
		return userDao.find();
	}

	public User getByUserName(String userName) {
		return userDao.getByUserName(userName);
	}

	public Integer update(User user) {
		return userDao.update(user);
	}

}
