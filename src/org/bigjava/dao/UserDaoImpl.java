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

	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public User login(String username, String password) {
		System.out.println("username:"+username+",password:"+password);
		User user = null;
		Query qy = getSession().createQuery("from User where email=:username and password= :password");
		qy.setParameter("username", username);
		qy.setParameter("password", password);


		if(qy.uniqueResult() != null){
			user = (User) qy.uniqueResult();
			System.out.println(""+user.toString());
		}
		return user;
	}
	 

	public void save(User user) {
		getSession().save(user);
	}	
	

	public User find(int id) {
		User user = null;
		Query qy = getSession().createQuery("from User where id=:id");
		qy.setParameter("id", id);
		if(qy.uniqueResult() != null){
			user = (User) qy.uniqueResult();	
		}
		return user;
	}
	

	public void update(User user){
		getSession().update(user);
	}
	public boolean checkemail(String email) {
		Query qy = getSession().createQuery("from User where email=:email");
		qy.setParameter("email", email);
		if(qy.uniqueResult() == null) {
			return false;
		}
		return true;
	}
	public boolean checkusername(String username) {
		Query qy = getSession().createQuery("from User where username=:username");
		qy.setParameter("username", username);
		if(qy.uniqueResult() == null) {
			return false;
		}
		return true;
	}
	
	

	
}
