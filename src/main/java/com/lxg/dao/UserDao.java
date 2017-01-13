package com.lxg.dao;

import com.lxg.entity.User;

public interface UserDao {
	
	public User find();
	
	public User getByUserName(String userName);
	
	public Integer update(User user);
}
