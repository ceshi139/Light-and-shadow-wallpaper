package org.bigjava.biz;

import org.bigjava.dao.UserDao;
import org.bigjava.entity.User;

public class UserBizImpl implements UserBiz {
	
	private UserDao userdao;

	
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	//�û���¼
	public User login(String username, String password) {
		return userdao.login(username, password);
	}

	//�û�ע��
	public void save(User user) {
		userdao.save(user);
	}

	//�û�������Ϣ
	public User find(int userid) {
		return userdao.find(userid);
	}

	//�޸ĸ�����Ϣ
	public void update(User user) {
		userdao.update(user);
	}

}
