package org.bigjava.action;

import org.bigjava.biz.UserBiz;
import org.bigjava.entity.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private UserBiz userbiz;
	private User user;
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserbiz(UserBiz userbiz) {
		this.userbiz = userbiz;
	}
	
	
	//用户登陆
	public String login() {
		User ur = userbiz.login(user.getUsername(),user.getPassword());
		ActionContext.getContext().getSession().put("user",ur);
		
		return "login";
	}
	//用户注册
	public String save() {
		
		return null;
	}
	//修改用户信息
	public String update() {
		
		return null;
	}
}
