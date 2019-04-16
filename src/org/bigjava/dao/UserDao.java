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
	
	//校验邮箱是否存在
	public boolean checkemail(String email);
	
	//校验用户名是否存在
	public boolean checkusername(String username);

	//用户添加余额
	public Double addUserMoney(double money,String username);

	
	//关注
	public void attention(int user_id,int fromuser_id);
	
	//取消关注
	public void de_attention(int user_id,int fromuser_id);
	
	//判断是否关注
	public boolean is_attention(int user_id,int fromuser_id);
	
}
