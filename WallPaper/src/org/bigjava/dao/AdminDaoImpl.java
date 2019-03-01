package org.bigjava.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class AdminDaoImpl implements AdminDao{

	 private SessionFactory sessionFactory;
		

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		
		  //µÇÂ¼
			public boolean login(String adminName , String password) {
				
				System.out.println("login");
				
				Query query = sessionFactory.getCurrentSession().createQuery("from User where adminName=? and password=?");
				
				query.setString(0,adminName);
				
				query.setString(1,password);
				
				List u=query.list();
				
		    	Boolean flag = false;
		    	
		    	if(u.size()>0){
		    		
		    		flag = true;
		    	}
		    	
		    	    return flag;
		    
			}
}
