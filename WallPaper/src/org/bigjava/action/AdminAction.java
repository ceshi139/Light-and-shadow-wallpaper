package org.bigjava.action;

import org.bigjava.biz.AdminBiz;
import org.bigjava.entity.Admin;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport{
	
    private AdminBiz adminbiz;	
    private Admin admin;
    private String adminName;
    private String password;
    private String result;
    
    
     
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdminBiz getAdminbiz() {
		return adminbiz;
	}
	
	public void setAdminbiz(AdminBiz adminbiz) {
		this.adminbiz = adminbiz;
	}
	
	public Admin getAdmin() {
		return admin;
	}
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	//¹ÜÀíµÇÂ¼
	public String loginAdmin() {
		
		Boolean flag =adminbiz.login(adminName, password);
		
		if(flag) {
			this.result = "true";
		}else{
			this.result = "false";
		}
		
		return "success";
		
	}
     
      

}
