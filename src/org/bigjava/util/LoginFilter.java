package org.bigjava.util;

import org.bigjava.entity.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginFilter extends AbstractInterceptor{
	
	public void init() {
		System.out.println("开始：");
	}
	public String intercept(ActionInvocation arg0) throws Exception {
		ActionContext ac = arg0.getInvocationContext();
		ActionProxy proxy = arg0.getProxy();
		String methodName = proxy.getMethod();
		String result = "";
		/*
		 * if(!"User_login".equals(methodName) ||
		 * !"User_findPicture".equals(methodName)) { User ur = (User)
		 * ActionContext.getContext().getSession().get("user"); if(ur == null) {
		 * System.out.println("非法访问！"); return "error_login"; } }
		 */
		result = arg0.invoke();
		System.out.println("成功！");
		return result;
		
	}
	public void destroy() {
	System.out.println("结束：");
	}
}
