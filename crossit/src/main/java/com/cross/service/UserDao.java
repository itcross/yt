package com.cross.service;

import com.cross.model.User;

public interface UserDao {
	
	public String findId(User user);
	
	public String findPwd(User user);
	
	public void updateTempPwd(String temppwd);
	
	public User getUser(String user_id);
}
