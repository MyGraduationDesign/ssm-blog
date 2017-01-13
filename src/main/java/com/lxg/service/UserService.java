package com.lxg.service;

import com.lxg.entity.User;

public interface UserService {
	public User find();
	
	public User getByUserName(String userName);
	
	public Integer update(User user);
}
