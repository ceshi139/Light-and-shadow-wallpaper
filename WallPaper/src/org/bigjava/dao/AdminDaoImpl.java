package org.bigjava.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class AdminDaoImpl implements AdminDao {

	 private SessionFactory sessionFactory;
		

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
	
    //µÇÂ¼
	@Override
	public boolean login(String adminName, String password) {
		
	      Query query = sessionFactory.getCurrentSession().createQuery("from admin where adminName=? and password=?");
	      
	      query.setString(0, adminName);
	      
	      query.setString(1, password);
	      
	      List list = query.list();
	      
	      Boolean flag = false;
	    	
	    	if(list.size()>0){
	    		
	    		flag = true;
	    	}
	    	
	    	    return flag;
	      
	}

	/*@Override
	public List chaAllUser() {
		
		return null;
	}*/

}
