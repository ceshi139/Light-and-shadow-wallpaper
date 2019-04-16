package org.bigjava.dao;

import org.bigjava.entity.User;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

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
		System.out.println("Userdaoimpl中的user"+user);
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

	//用户添加余额
	public Double addUserMoney(double money,String username){
		double endmoney = 0.00;//最后的余额存进数据库
		Query qy=getSession().createQuery("from User where username=:username");
		qy.setParameter("username",username);
		List<User> list=qy.list();

		for (User u:  list){
			endmoney=u.getMoneyover()+money;
		}
		System.out.println("用户最后余额>>"+endmoney);
		String hql="update user set moneyover='"+endmoney+"' where username='"+username+"'";
		getSession().createSQLQuery(hql).executeUpdate();
		return endmoney;
	}

	//关注
	public void attention(int user_id,int fromuser_id) {
		System.out.println("dao>>"+user_id+"<<"+fromuser_id);
		String hql = "insert into user_fromuser (user_id,fromuser_id) value('"+user_id+"','"+fromuser_id+"')";
		User ur = (User) getSession().get(User.class, user_id);	
		System.out.println("dao"+ur.getFans());
		ur.setFollow(ur.getFollow()+1);		//关注数+1
		User ur_a = (User) getSession().get(User.class, fromuser_id);
		ur_a.setFans(ur_a.getFans()+1);		//fromuser粉丝数+1
			
		System.out.println("关注"+user_id+"成功");
		SQLQuery qy = getSession().createSQLQuery(hql);
		qy.executeUpdate();
	}
	
	//取消关注
	public void de_attention(int user_id,int fromuser_id) {
		String hql = "delete from user_fromuser where user_id='"+user_id+"'and fromuser_id="+fromuser_id;
		User ur = (User) getSession().get(User.class, user_id);	
		System.out.println("dao"+ur.getFans());
		ur.setFollow(ur.getFollow()-1);		//关注数-1
		User ur_a = (User) getSession().get(User.class, fromuser_id);
		ur_a.setFans(ur_a.getFans()-1);		//fromuser粉丝数-1
		
		System.out.println("取消关注"+user_id+"成功");
		SQLQuery qy = getSession().createSQLQuery(hql);
		qy.executeUpdate();
	}
	
	//判断是否关注
	public boolean is_attention(int user_id,int fromuser_id) {
		String hql = "select * from user_fromuser where user_id='"+user_id+"'and fromuser_id="+fromuser_id;
		List list = getSession().createSQLQuery(hql).list();
		if(list.size()<=0) {
		return true;	//没有关注
		}
		return false;
	}

	
	
}
