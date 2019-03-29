package org.bigjava.dao;

import java.util.List;

import org.bigjava.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDaoImpl implements UserDao{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//�õ�session
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//�û���½
	public User login(String username, String password) {
		System.out.println("username:"+username+",password:"+password);
		User user = null;
		Query qy = getSession().createQuery("from User where email=:username and password= :password");
		qy.setParameter("username", username);
		qy.setParameter("password", password);
		if(qy.uniqueResult() != null){
			user = (User) qy.uniqueResult();	
		}
		return user;
	}
	 
	//�û�ע��
	public void save(User user) {
		getSession().save(user);
	}	
	
	//�û�������Ϣ
	public User find(int id) {
		User user = null;
		Query qy = getSession().createQuery("from User where id=:id");
		qy.setParameter("id", id);
		if(qy.uniqueResult() != null){
			user = (User) qy.uniqueResult();	
		}
		return user;
	}
	
	//�޸ĸ�����Ϣ
	public void update(User user){
		getSession().update(user);
	}
	
	//У�������Ƿ����
	public boolean checkemail(String email) {
		Query qy = getSession().createQuery("from User where email=:email");
		qy.setParameter("email", email);
		if(qy.uniqueResult() == null) {
			return false;
		}
		return true;
	}
	
	//У���û����Ƿ����
	public boolean checkusername(String username) {
		Query qy = getSession().createQuery("from User where username=:username");
		qy.setParameter("username", username);
		if(qy.uniqueResult() == null) {
			return false;
		}
		return true;
	}
	
	
	/*
	 * //��ҳ��ѯ public List<Student> fenye(int pageNow,int pageSize,String shu) {
	 * Query qy =
	 * getSession().createQuery("from Student where name like '"+shu+"%'");
	 * qy.setFirstResult((pageNow-1)*pageSize); qy.setMaxResults(pageSize);
	 * System.out.println("dao"+qy.list()); return qy.list(); }
	 */
	
}
