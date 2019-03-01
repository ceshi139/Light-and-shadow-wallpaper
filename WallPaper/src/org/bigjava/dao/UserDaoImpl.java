package org.bigjava.dao;

import org.bigjava.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDaoImpl implements UserDao{

private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//得到session
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//用户登陆
		public User login(String username, String password) {
			System.out.println("username:"+username+",password:"+password);
			System.out.println("username:"+username+",password:"+password);
			User user = null;
			Query qy = getSession().createQuery("from Student where username=:username and password= :password");
			qy.setParameter("username", username);
			qy.setParameter("password", password);
			if(qy.uniqueResult() != null){
				user = (User) qy.uniqueResult();	
			}
			return user;
		}
	
}
