package org.bigjava.dao;

import java.util.List;

import org.bigjava.entity.Picture;
import org.bigjava.entity.User;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PictureDaoImpl implements PictureDao {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//得到session
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//上传用户图片
	public void userupload(Picture picture) {
		getSession().save(picture);
	}

	//查看上传图片
	public List<Picture> ck_upload(int user_id) {
		User ur = (User) getSession().get(User.class,user_id);
		Query qy;
		qy = getSession().createFilter(ur.getSet_upload(), "order by id asc");
			System.out.println("shang"+qy.list());
		return qy.list();
	}
	//删除用户上传图片
	public void userdelete(int id) {
		getSession().delete(id);
	}
	
	//用户收藏图片
	public void collect(int user_id,int picture_id) {
		String hql = "insert into user_picture (user_id,picture_id) value('"+user_id+"','"+picture_id+"')";
		Picture picture = (Picture) getSession().get(Picture.class,picture_id);
	
		picture.setCollectionNumber(picture.getCollectionNumber()+1);	//图片收藏数加1
		
		System.out.println("daodao"+user_id);
		SQLQuery qy = getSession().createSQLQuery(hql);
		qy.executeUpdate();
	}
	
	
	//用户取消收藏图
	public void decollect(int userid,int pictureid) {
		String hql = "delete from user_picture where user_id='"+userid+"'and picture_id="+pictureid;
		Picture picture = (Picture) getSession().get(Picture.class,pictureid);
		picture.setCollectionNumber(picture.getCollectionNumber()-1);	//图片收藏数减1
		SQLQuery qy = getSession().createSQLQuery(hql);
		System.out.println("daodao2"+userid);
		qy.executeUpdate();	
	}
	
	//查询收藏
	public List<Picture> find_collect(int pageNow,int pageSize,int user_id) {
			User ur = (User) getSession().get(User.class,user_id);
			Query qy;
			qy = getSession().createFilter(ur.getSet_picture(), "order by CollectionNumber asc");
			qy.setFirstResult((pageNow-1)*pageSize);
			qy.setMaxResults(pageSize);
			System.out.println("dao"+qy.list());
			return qy.list();
		}
	
	//查询图片是否已收藏
	public boolean ckcollect(int userid,int pictureid) {
		String hql = "select * from user_picture where user_id='"+userid+"'and picture_id="+pictureid;
		List list = getSession().createSQLQuery(hql).list();
		if(list.size()<=0) {
		return true;
		}
		return false;
	}
	
	
	//查询总条数
	public int tiaoshu(int type_id){
		int totalSize;
			if(type_id == 0) {	//等于0全查
				totalSize = getSession().createQuery("from Picture").list().size();
			}else {
				totalSize = getSession().createQuery("from Picture where id='"+type_id+"'").list().size();
			}
		return totalSize;
	}
	
	//查询收藏总条数
	public int shoucang_shu(int user_id) {
		User ur = (User) getSession().get(User.class,user_id);
		Query qy;
		qy = getSession().createFilter(ur.getSet_picture(),"");
		System.out.println("dao9999"+qy.list());
		return qy.list().size();
	}
	
	//查询上传表总条数
	public int upload_shu(int user_id) {
		Query qy = getSession().createQuery("from UploadPicture");
		System.out.println("dao9999"+qy.list());
		return qy.list().size();
	}
	
	//查询默认图片
	public List<Picture> findall_picture(int pageNow,int pageSize,int type_id) {
		
		Query qy;
		System.out.println("dao"+type_id);
			if(type_id == 0) {  //等于0全查
				 qy =	getSession().createQuery("from Picture");
			}else {
				 qy =	getSession().createQuery("from Picture where type="+type_id);
				 System.err.println("www");
			}
		qy.setFirstResult((pageNow-1)*pageSize);
		qy.setMaxResults(pageSize);
		return qy.list();	
	}
	

	//查询图片类型
	public List ck_type() {;
		Query qy = getSession().createQuery("from Type");
		List list = qy.list();
		return list;
	}
}
