package org.bigjava.dao;

import org.bigjava.entity.User;

public interface UserDao {
	//�û���¼
	public User login(String username, String password);
	
	//�û�ע��
	public void save(User user);
	
	//�û�������Ϣ
	public User find(int id);
	
	//�޸ĸ�����Ϣ
	public void update(User user);
	
	//У�������Ƿ����
	public boolean checkemail(String email);
	
	//У���û����Ƿ����
	public boolean checkusername(String username);
	
}
