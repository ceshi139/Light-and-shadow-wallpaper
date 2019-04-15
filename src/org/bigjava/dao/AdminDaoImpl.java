package org.bigjava.dao;

import java.util.List;
import org.bigjava.entity.Admin;
import org.bigjava.entity.Picture;
import org.bigjava.entity.Type;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class AdminDaoImpl implements AdminDao {

	 private SessionFactory sessionFactory;
		

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
	
    //��¼
	public Admin login(Admin admin) {
		
		  System.out.println("adminLogin");
		  
	      Query query = sessionFactory.getCurrentSession().createQuery("from Admin where adminName='"+admin.getAdminName()+"' and password= '"+admin.getPassword()+"'");
	           
	      Admin list = (Admin) query.uniqueResult();
	      
	     
	      System.out.println(list); 

	      return list;      
	}

     //ģ��+��ҳ��ѯȫ���û�
	 public List chaAllUser(int pageNow,int pageSize,String username) {
		 
		  System.out.println("chaAll"+pageNow+pageSize);
		  
		  String hql = "From User where username like '"+username+"%'";
		  
		  Query query = sessionFactory.getCurrentSession().createQuery(hql);
		  
		  query.setFirstResult((pageNow-1)*pageSize);
		  
		  query.setMaxResults(pageSize);
		  
		  List list = query.list();
		  
		  System.out.println(list.toString());
		  
		  return list;
		  	  
	 }
	 
	 /*public int findTotalSize() {
		 
		  System.out.println("find");
		  
		  String hql = "From User";
		  
		  int size = sessionFactory.getCurrentSession().createQuery(hql).list().size();
		  
		  return size;
		  
	 }
 */
	 //��ѯ������
	 public int findTotalSize1(String username) {
		 
		  System.out.println("find");
		  
		  String hql = "From User where username like '"+username+"%'";
		  
		  int size = sessionFactory.getCurrentSession().createQuery(hql).list().size();
		  
		  System.out.println(size);
		  return size;
		  
	 }
	 
	 //���
	 public void fengjin(int id) {
		 
		 System.out.println(id);
		 
		 String hql = "update user set state='1' where id='"+id+"'"; 
		 
		 sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
		 	  
	 }
	 
	 //���
	 public void jiefeng(int id) {
		 
         System.out.println(id);
		 
		 String hql = "update user set state='0' where id='"+id+"'"; 
		 
		 sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	 }
	 
	 //��ѯȫ��ͼƬ
	 public List chaAllPicture(int pageNow, int pageSize,String url) {
		 
		 System.out.println("daoImp"+url);
		 
		 String hql = "From Picture where size like '"+url+"%'";
		 
		 Query query = sessionFactory.getCurrentSession().createQuery(hql);
		  
		 query.setFirstResult((pageNow-1)*pageSize);
		  
		 query.setMaxResults(pageSize);
		  
		 List list = query.list();
		  
		 System.out.println(list.toString());
		  
		 return list;
		 
	 }
	 
	 public Type cha(String types) {
		 System.out.println(types);
		 String hql = "from Type where picturnType = '"+types+"'";
		 return (Type) sessionFactory.getCurrentSession().createQuery(hql).list();
	 }
	//��ѯͼƬ��������
    public int findTotalSize(String url) {
    	
    	String hql = "From Picture where size like '"+url+"%'";
    	
    	int size = sessionFactory.getCurrentSession().createQuery(hql).list().size();
    	
    	return size;
    }
    
    //ͼƬ���ͷ�ҳ+ģ����ѯ
    public List chaAllType(int pageNow, int pageSize,String typeName) {
    	
    	String hql = "From Type where pictureType like '"+typeName+"%'";
    	
    	Query query = sessionFactory.getCurrentSession().createQuery(hql);
    	
    	query.setFirstResult((pageNow-1)*pageSize);
    	
    	query.setMaxResults(pageSize);
    	
    	List list = query.list();
    	
    	System.out.println("000"+query.list());
    	return list;
    }
    
    //��ѯͼƬ��������
    public int findTypeTotalSize(String typeName) {
    	
    	String hql = "From Type where pictureType like '"+typeName+"%'";
    	
    	int size = sessionFactory.getCurrentSession().createQuery(hql).list().size();
    	
    	System.out.println(size);
    	
    	return size;
    	
    }
    
    public List chaType() {
    	return sessionFactory.getCurrentSession().createQuery("from Type").list();
    }
    
    //ͨ��id��ѯͼƬ������Ϣ
    public List findById(int id) {
    	
    	String hql = "from Type where id = '"+id+"'";
    	
    	System.out.println(sessionFactory.getCurrentSession().createQuery(hql).list());
    	
    	return sessionFactory.getCurrentSession().createQuery(hql).list();
    	
    }
    
    //�޸�ͼƬ����
    public void update(Type type){
    	
    	System.out.println(type);
    	sessionFactory.getCurrentSession().update(type);
    		
    }
    
    public List chaType(String types) {
    	System.out.println("chaType");
    	String hql = "from Type where pictureType = '"+types+"'";
    	return sessionFactory.getCurrentSession().createQuery(hql).list();
    }
    
    //�������
  	public void addType(Type type) {
  		
  		System.out.println(type);
  		
  		sessionFactory.getCurrentSession().save(type);
  	}
  	
  //ɾ��ͼƬ����
  	public void delete(int id) {
  		
  		System.out.println("daoimpl"+id);
  		
  		String hql = "from Type where id = '"+id+"'";
  		
  		Type type = (Type) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();

  		sessionFactory.getCurrentSession().delete(type);
  	}
  	
  	//���ͼƬ
  	public void addPicture(Picture picture) {
  		
  		System.out.println("daoImpl"+picture.getSize()+picture.getUrl());
  		
  		sessionFactory.getCurrentSession().save(picture);
  	}
  	
  	//ͨ��id��ѯ����
  	public Type findByIdType(int id) {
  		
  		System.out.println("chaType");
  		
  		String hql = "from Type where id = '"+id+"'";
  		
  		return (Type) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
  	}
  	
  	//ͨ��id��ѯͼƬ��Ϣ
  	public List findByIdPicture(int id) {
  		
  		System.out.println("findByIdPicture");
  		
        String hql = "from Picture where id = '"+id+"'";
    	
    	System.out.println(sessionFactory.getCurrentSession().createQuery(hql).list());
    	
    	return sessionFactory.getCurrentSession().createQuery(hql).list();
  			
  	}
  	
  	//�޸�ͼƬ��Ϣ
  	public void updatePicture(Picture picture) {
  		
  		System.out.println("updatePicture");
  		
  		sessionFactory.getCurrentSession().update(picture);
  	}
  	
  	//ɾ��ͼƬ
  	public void deletePicture(int id) {
  		System.out.println("deletepicture");
  		String hql = "from Picture where id = '"+id+"'";
  		Picture picture = (Picture) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
  		sessionFactory.getCurrentSession().delete(picture);
  	}
  	
  	public void updatePassword(Admin admin) {
  		System.out.println("admin");
  		sessionFactory.getCurrentSession().update(admin);	
  	}
  	
  	public List check(String oldPassword) {
  		System.out.println(oldPassword);
  		String hql = "from Admin where password = '"+oldPassword+"'";
  		return sessionFactory.getCurrentSession().createQuery(hql).list(); 
  	}
}
