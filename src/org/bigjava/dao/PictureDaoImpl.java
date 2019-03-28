package org.bigjava.dao;

import org.bigjava.entity.Picture;
import org.bigjava.entity.UploadPicture;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PictureDaoImpl implements PictureDao {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//寰楀埌session
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//涓婁紶鐢ㄦ埛鍥剧墖
	public void userupload(UploadPicture uploadpicture) {
		getSession().save(uploadpicture);
	}
	
	//鍒犻櫎鐢ㄦ埛涓婁紶鍥剧墖
	public void userdelete(int id) {
		getSession().delete(id);
	}
	
	public void collect(int id) {
		String hql = "insert into collect select * from picture where id=:id";
		SQLQuery qy = getSession().createSQLQuery(hql);
		qy.setParameter("id", id); 
		qy.executeUpdate();
	}
	
	//鐢ㄦ埛鍙栨秷鏀惰棌鍥�
	public void decollect(int userid,int pictureid) {
		String hql = "delete from collect where id=:pictureid and userid=:userid";
		SQLQuery qy = getSession().createSQLQuery(hql);
		qy.setParameter("userid", userid);
		qy.setParameter("pictureid", pictureid);
		qy.executeUpdate();
		
	}
	
	//鏌ヨ鍥剧墖鏄惁宸叉敹钘�
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
	
	
	//鏌ヨ鎬绘潯鏁�
	public int tiaoshu(int type_id){
		int totalSize;
			if(type_id == 0) {	//绛変簬0鍏ㄦ煡
				totalSize = getSession().createQuery("from Picture").list().size();
			}else {
				totalSize = getSession().createQuery("from Picture where id='"+type_id+"'").list().size();
			}
		return totalSize;
	}
	
	//鏌ヨ榛樿鍥剧墖
	public List<Picture> findall_picture(int pageNow,int pageSize,int type_id) {
		Query qy;
			if(type_id == 0) {  //绛変簬0鍏ㄦ煡
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
	
	public List ck_type() {;
		Query qy = getSession().createQuery("from Type");
		List list = qy.list();
		return list;
	}
}
