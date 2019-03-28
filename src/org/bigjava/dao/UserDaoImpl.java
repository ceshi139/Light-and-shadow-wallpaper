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
		User user = null;
		Query qy = getSession().createQuery("from User where email=:username and password= :password");
		qy.setParameter("username", username);
		qy.setParameter("password", password);


		if(qy.uniqueResult() != null){
			user = (User) qy.uniqueResult();
			System.out.println("dao里面有没有用户名？"+user.toString());
		}
		return user;
	}
	 
	//用户注册
	public void save(User user) {
		getSession().save(user);
	}	
	
	//用户个人信息
	public User find(int id) {
		User user = null;
		Query qy = getSession().createQuery("from User where id=:id");
		qy.setParameter("id", id);
		if(qy.uniqueResult() != null){
			user = (User) qy.uniqueResult();	
		}
		return user;
	}
	
	//修改个人信息
	public void update(User user){
		getSession().update(user);
	}
	
	//校验邮箱是否存在
	public boolean checkemail(String email) {
		Query qy = getSession().createQuery("from User where email=:email");
		qy.setParameter("email", email);
		if(qy.uniqueResult() == null) {
			return false;
		}
		return true;
	}
	
	//校验用户名是否存在
	public boolean checkusername(String username) {
		Query qy = getSession().createQuery("from User where username=:username");
		qy.setParameter("username", username);
		if(qy.uniqueResult() == null) {
			return false;
		}
		return true;
	}
	
	
	/*
	 * //分页查询 public List<Student> fenye(int pageNow,int pageSize,String shu) {
	 * Query qy =
	 * getSession().createQuery("from Student where name like '"+shu+"%'");
	 * qy.setFirstResult((pageNow-1)*pageSize); qy.setMaxResults(pageSize);
	 * System.out.println("dao"+qy.list()); return qy.list(); }
	 */
	
}
