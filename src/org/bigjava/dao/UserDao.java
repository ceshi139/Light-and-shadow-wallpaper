package org.bigjava.dao;

import org.bigjava.entity.User;

public interface UserDao {
	//用户登录
	public User login(String username, String password);
	
	//用户注册
	public void save(User user);
	
	//用户个人信息
	public User find(int id);
	
	//修改个人信息
	public void update(User user);
	
	//校验用户是否存在
	public boolean checkemail(String email);
	
}
