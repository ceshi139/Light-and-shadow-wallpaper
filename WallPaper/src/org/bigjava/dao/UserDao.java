package org.bigjava.dao;

import org.bigjava.entity.User;

public interface UserDao {
	//�û���¼
	public User login(String username, String password);
}
