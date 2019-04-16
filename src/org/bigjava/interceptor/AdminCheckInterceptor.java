package org.bigjava.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminCheckInterceptor extends AbstractInterceptor{
	
	 public String intercept(ActionInvocation invocation) throws Exception {
	        //�õ���ǰִ�еķ��������жϣ�ֻҪ��ǰ����������login,�ͽ�����֤
	        System.out.println("aaaa");
	        //��ȡActionContext����
	        ActionContext ac = invocation.getInvocationContext();
	        
	        //��ȡAction�Ĵ������
	        ActionProxy proxy = invocation.getProxy();
	        //��ȡ��ǰִ�еķ�����
	        String methodName = proxy.getMethod();
	        //�ж�
	        if(!"login".equals(methodName)){
	            //�Ȼ�ȡ��ǰ��½���û�
	            Object obj = ac.getSession().get("admin");
	            System.out.println(obj);
	            if(obj == null){
	            	System.out.println("bbb");
	                //û�е�½
	                return "nologin";
	            }else{
	                //��ǰ�û��Ѿ���½
	            	System.out.println("ccc");
	                return invocation.invoke();
	            }
	        }else{
	            //��ǰ�û����ڵ�½
	        	System.out.println("ddd");
	            return invocation.invoke();
	        }
	    }
}
