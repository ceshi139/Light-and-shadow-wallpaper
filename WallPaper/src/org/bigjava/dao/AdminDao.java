package org.bigjava.dao;

import java.util.List;

public interface AdminDao {
    
	//管理员登录
	public boolean login(String adminName , String password);
	
	//查询全部信息
	/*public List chaAllUser();*/
	
}
