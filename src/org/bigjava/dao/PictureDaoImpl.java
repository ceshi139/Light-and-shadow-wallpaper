package org.bigjava.dao;

import java.util.List;

import org.bigjava.entity.Picture;
import org.bigjava.entity.UploadPicture;
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
	public void userupload(UploadPicture uploadpicture) {
		getSession().save(uploadpicture);
	}
	
	//删除用户上传图片
	public void userdelete(int id) {
		getSession().delete(id);
	}
	
	//上传默认图片
	public void adminupload(Picture picture) {
		getSession().save(picture);
	}
	
	//删除默认图片
	public void admindelete(Picture picture) {
		getSession().delete(picture);
	}
	
	//用户收藏图片
	public void collect(int id) {
		String hql = "insert into collect select * from picture where id=:id";
		SQLQuery qy = getSession().createSQLQuery(hql);
		qy.setParameter("id", id); 
		qy.executeUpdate();
	}
	
	//用户取消收藏图
	public void decollect(int userid,int pictureid) {
		String hql = "delete from collect where id=:pictureid and userid=:userid";
		SQLQuery qy = getSession().createSQLQuery(hql);
		qy.setParameter("userid", userid);
		qy.setParameter("pictureid", pictureid);
		qy.executeUpdate();
		
	}
	
	//查询图片是否已收藏
	public boolean ckcollect(int userid,int pictureid) {
		String hql = "select from collect where id=:pictureid and userid=:userid";
		Query qy = getSession().createSQLQuery(hql);
		qy.setParameter("userid", userid);
		qy.setParameter("pictureid", pictureid);
		qy.executeUpdate();
		if(qy.uniqueResult()==null) {
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
	
	//查询默认图片
	public List<Picture> findall_picture(int pageNow,int pageSize,int type_id) {
		Query qy;
			if(type_id == 0) {  //等于0全查
				 qy =	getSession().createQuery("from Picture");
			}else {
				 qy =	getSession().createQuery("from Picture where id=:type_id");
				 qy.setParameter("type_id", type_id);
			}
		qy.setFirstResult((pageNow-1)*pageSize);
		qy.setMaxResults(pageSize);
		
		System.out.println("dao"+qy.list());
		return qy.list();
	}
	
	
	//查询用户上传图片
	
}
