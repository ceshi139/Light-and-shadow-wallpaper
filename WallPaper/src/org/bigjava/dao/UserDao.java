package org.bigjava.dao;

import org.bigjava.entity.User;

public interface UserDao {
	//ÓÃ»§µÇÂ¼
	public User login(String username, String password);
}
