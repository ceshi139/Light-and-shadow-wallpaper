package org.bigjava.dao;

import java.util.List;

import org.bigjava.entity.Picture;
import org.bigjava.entity.UploadPicture;
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
	public void userupload(UploadPicture uploadpicture) {
		getSession().save(uploadpicture);
	}
	
	//删除用户上传图片
	public void userdelete(int id) {
		getSession().delete(id);
	}
	
	//用户收藏图片
	public void collect(int user_id,int picture_id) {
		String hql = "insert into user_picture (user_id,picture_id) value('"+user_id+"','"+picture_id+"')";
		System.out.println("daodao"+user_id);
		SQLQuery qy = getSession().createSQLQuery(hql);
		qy.executeUpdate();
	}
	
	
	//用户取消收藏图
	public void decollect(int userid,int pictureid) {
		String hql = "delete from user_picture where user_id='"+userid+"'and picture_id="+pictureid;
		SQLQuery qy = getSession().createSQLQuery(hql);
		System.out.println("daodao2"+userid);
		qy.executeUpdate();	
	}
	
	//查询收藏
	public List<Picture> find_collect(int pageNow,int pageSize,int user_id) {
			User ur = (User) getSession().get(User.class,user_id);
			Query qy;
			qy = getSession().createFilter(ur.getSet_picture(), "order by this.id asc");
			qy.setFirstResult((pageNow-1)*pageSize);
			qy.setMaxResults(pageSize);
			System.out.println("dao"+qy.list());
			return qy.list();
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
				 qy =	getSession().createQuery("from Picture where type="+type_id);
				 System.out.println("pppp"+qy.list());
			}
		qy.setFirstResult((pageNow-1)*pageSize);
		qy.setMaxResults(pageSize);
		System.out.println("dao"+qy.list());
		return qy.list();
	}
	
	//查询图片类型
	public List ck_type() {;
		Query qy = getSession().createQuery("from Type");
		List list = qy.list();
		return list;
	}
}
