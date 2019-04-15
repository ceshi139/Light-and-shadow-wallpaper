package org.bigjava.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminCheckInterceptor extends AbstractInterceptor{
	
	 public String intercept(ActionInvocation invocation) throws Exception {
	        //拿到当前执行的方法名：判断，只要当前方法名不是login,就进行验证
	        System.out.println("aaaa");
	        //获取ActionContext对象
	        ActionContext ac = invocation.getInvocationContext();
	        
	        //获取Action的代理对象
	        ActionProxy proxy = invocation.getProxy();
	        //获取当前执行的方法名
	        String methodName = proxy.getMethod();
	        //判断
	        if(!"login".equals(methodName)){
	            //先获取当前登陆的用户
	            Object obj = ac.getSession().get("admin");
	            System.out.println(obj);
	            if(obj == null){
	            	System.out.println("bbb");
	                //没有登陆
	                return "nologin";
	            }else{
	                //当前用户已经登陆
	            	System.out.println("ccc");
	                return invocation.invoke();
	            }
	        }else{
	            //当前用户正在登陆
	        	System.out.println("ddd");
	            return invocation.invoke();
	        }
	    }
}
