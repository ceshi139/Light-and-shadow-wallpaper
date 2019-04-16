package org.bigjava.dao;

import org.bigjava.entity.Admin;
import org.bigjava.entity.Picture;
import org.bigjava.entity.Type;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;


public class AdminDaoImpl implements AdminDao {

	 private SessionFactory sessionFactory;
		

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
	
    //登录
	public Admin login(Admin admin) {
		
		  System.out.println("adminLogin");
		  
	      Query query = sessionFactory.getCurrentSession().createQuery("from Admin where adminName='"+admin.getAdminName()+"' and password= '"+admin.getPassword()+"'");
	           
	      Admin list = (Admin) query.uniqueResult();
	      
	     
	      System.out.println(list); 

	      return list;      
	}

     //模糊+分页查询全部用户
	 public List chaAllUser(int pageNow,int pageSize,String username) {
		 
		  System.out.println("chaAll"+pageNow+pageSize);
		  
		  String hql = "From User where username like '%"+username+"%'";
		  
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
	 //查询总条数
	 public int findTotalSize1(String username) {
		 
		  System.out.println("find");
		  
		  String hql = "From User where username like '%"+username+"%'";
		  
		  int size = sessionFactory.getCurrentSession().createQuery(hql).list().size();
		  
		  System.out.println("zongtiaoshu"+size);
		  return size;
		  
	 }
	 
	 //封禁
	 public void fengjin(int id) {
		 
		 System.out.println(id);
		 
		 String hql = "update user set state='1' where id='"+id+"'"; 
		 
		 sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
		 	  
	 }
	 
	 //解封
	 public void jiefeng(int id) {
		 
         System.out.println(id);
		 
		 String hql = "update user set state='0' where id='"+id+"'"; 
		 
		 sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	 }
	 
	 //查询全部图片
	 public List chaAllPicture(int pageNow, int pageSize,String imgname,String imgsize,String imgtype,String paixu) {
		 

		 String hql;
		 if(paixu.equals("shijian")){
			  hql= "From Picture where picturename like '%"+imgname+"%' and size like '%"+imgsize+"%' and type like '%"+imgtype+"%' order by time desc";

		 }else if (paixu.equals("redu")){
			  hql = "From Picture where picturename like '%"+imgname+"%' and size like '%"+imgsize+"%' and type like '%"+imgtype+"%' order by collectionNumber desc";
		 }else {
			  hql = "From Picture where picturename like '%"+imgname+"%' and size like '%"+imgsize+"%' and type like '%"+imgtype+"%' order by id desc";
		 }
		 System.out.println("hql是"+hql);
		 Query query = sessionFactory.getCurrentSession().createQuery(hql);
		  
		 query.setFirstResult((pageNow-1)*pageSize);
		  
		 query.setMaxResults(pageSize);
		  
		 List list = query.list();
		  
		 System.out.println(list.toString());
		  
		 return list;
		 
	 }
	 
	 public Type cha(String types) {
		 System.out.println(types);

		 String hql = "from Type where picturetype = '"+types+"'";
		 return (Type) sessionFactory.getCurrentSession().createQuery(hql).list();
	 }
	//查询图片的总条数
    public int findTotalSize(String imgsize,String imgtype,String imgname) {
    	
    	String hql = "From Picture where size like '%"+imgsize+"%' and type like '%"+imgtype+"%' and picturename like '%"+imgname+"%'";
    	System.out.println("zongtiaosuhql"+hql);
    	int size = sessionFactory.getCurrentSession().createQuery(hql).list().size();
    	System.out.println("zongtiaoshusize"+size);
    	return size;
    }
    
    //图片类型分页+模糊查询
    public List chaAllType(int pageNow, int pageSize,String typeName) {
    	
    	String hql = "From Type where picturetype like '"+typeName+"%'";
    	
    	Query query = sessionFactory.getCurrentSession().createQuery(hql);
    	
    	query.setFirstResult((pageNow-1)*pageSize);
    	
    	query.setMaxResults(pageSize);
    	
    	List list = query.list();
    	
    	System.out.println("000"+query.list());
    	return list;
    }
    
    //查询图片类型总数
    public int findTypeTotalSize(String typeName) {
    	
    	String hql = "From Type where picturetype like '"+typeName+"%'";
    	
    	int size = sessionFactory.getCurrentSession().createQuery(hql).list().size();
    	
    	System.out.println(size);
    	
    	return size;
    	
    }
    
    public List chaType() {
    	return sessionFactory.getCurrentSession().createQuery("from Type").list();
    }
    
    //通过id查询图片类型信息
    public List findById(int id) {
    	
    	String hql = "from Type where id = '"+id+"'";
    	
    	System.out.println(sessionFactory.getCurrentSession().createQuery(hql).list());
    	
    	return sessionFactory.getCurrentSession().createQuery(hql).list();
    	
    }
    
    //修改图片类型
    public void update(Type type){
    	
    	System.out.println(type);
    	sessionFactory.getCurrentSession().update(type);
    		
    }
    
    public List chaType(String types) {
    	System.out.println("chaType"+types);
    	String hql = "from Type where picturetype = '"+types+"'";
    	return sessionFactory.getCurrentSession().createQuery(hql).list();
    }
    
    //添加类型
  	public void addType(Type type) {
  		
  		System.out.println(type);
  		
  		sessionFactory.getCurrentSession().save(type);
  	}
  	
  //删除图片类型
  	public void delete(int id) {
  		
  		System.out.println("daoimpl"+id);
  		
  		String hql = "from Type where id = '"+id+"'";
  		
  		Type type = (Type) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();

  		sessionFactory.getCurrentSession().delete(type);
  	}
  	
  	//添加图片
  	public void addPicture(Picture picture) {
  		
  		System.out.println("daoImpl"+picture.getSize()+picture.getUrl());
  		
  		sessionFactory.getCurrentSession().save(picture);
  	}
  	
  	//通过id查询类型
  	public Type findByIdType(int id) {
  		
  		System.out.println("chaType");
  		
  		String hql = "from Type where id = '"+id+"'";
  		
  		return (Type) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
  	}
  	
  	//通过id查询图片信息
  	public List findByIdPicture(int id) {
  		
  		System.out.println("findByIdPicture");
  		
        String hql = "from Picture where id = '"+id+"'";
    	
    	System.out.println(sessionFactory.getCurrentSession().createQuery(hql).list());
    	
    	return sessionFactory.getCurrentSession().createQuery(hql).list();
  			
  	}
  	
  	//修改图片信息
  	public void updatePicture(Picture picture) {
  		
  		System.out.println("updatePicture");
  		
  		sessionFactory.getCurrentSession().update(picture);
  	}
  	
  	//删除图片
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
