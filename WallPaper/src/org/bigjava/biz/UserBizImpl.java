package org.bigjava.biz;

import org.bigjava.dao.UserDao;
import org.bigjava.entity.User;

public class UserBizImpl implements UserBiz {
	
	private UserDao userdao;

	
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	//用户登录
	public User login(String username, String password) {
		return userdao.login(username, password);
	}

	//用户注册
	public void save(User user) {
		userdao.save(user);
	}

	//用户个人信息
	public User find(int userid) {
		return userdao.find(userid);
	}

	//修改个人信息
	public void update(User user) {
		userdao.update(user);
	}

}
