package org.bigjava.dao;

import org.bigjava.entity.User;

public interface UserDao {
	//鐢ㄦ埛鐧诲綍
	public User login(String username, String password);
	
	//鐢ㄦ埛娉ㄥ唽
	public void save(User user);
	
	//鐢ㄦ埛涓汉淇℃伅
	public User find(int id);
	
	//淇敼涓汉淇℃伅
	public void update(User user);
	
	//校验邮箱是否存在
	public boolean checkemail(String email);
	
	//校验用户名是否存在
	public boolean checkusername(String username);
	
}
