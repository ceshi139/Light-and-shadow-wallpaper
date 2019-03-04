package org.bigjava.biz;

import org.bigjava.dao.AdminDao;

public class AdminBizImpl implements AdminBiz {

	private AdminDao adminDao;
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	
	@Override
	public boolean login(String adminName, String password) {        //µÇÂ¼
		
		return adminDao.login(adminName,password);
	}

}
