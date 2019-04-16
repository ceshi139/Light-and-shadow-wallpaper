package org.bigjava.dao;

import org.bigjava.entity.Picture;
import org.bigjava.entity.Type;
import org.bigjava.entity.User;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.sun.jndi.toolkit.url.Uri;

import java.util.List;

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
		qy = getSession().createFilter(ur.getSet_upload(), "order by id desc");


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
		System.out.println("dao"+pageSize);
			User ur = (User) getSession().get(User.class,user_id);
			Query qy;
			qy = getSession().createFilter(ur.getSet_picture(), "order by CollectionNumber desc");
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
				totalSize = getSession().createQuery("from Picture where type='"+type_id+"'").list().size();
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

		User ur = (User) getSession().get(User.class,user_id);
		Query qy;
		qy = getSession().createFilter(ur.getSet_upload(),"");
		return qy.list().size();
	}
	
	//查询默认图片
	public List<Picture> findall_picture(int pageNow,int pageSize,int type_id) {
			Query qy;
			if(type_id ==0) {  //等于0全查
				 qy =	getSession().createQuery("from Picture order by id desc ");
				qy.setFirstResult(0);
				qy.setMaxResults(pageSize);
			}else {
				 qy =	getSession().createQuery("from Picture where type="+type_id);
				qy.setFirstResult((pageNow-1)*pageSize);
				qy.setMaxResults(pageSize);
			}

		return qy.list();

	}
	
	//搜索图片
	public List<Picture> sou(int type,int sech_type ,String cha,int pageNow ,int pageSize) {
		Query qy;
		System.out.println("sou"+cha+type+sech_type);
		if(sech_type == 0) {	//sech_type为类型
			if(type == 1) {	// 全部
				qy = getSession().createQuery("from Picture where picturename like '%"+cha+"%'");	
				}else if(type == 2) {	//通过尺寸
					qy = getSession().createQuery("from Picture where size like '"+cha+"%'");
					System.out.println("soso"+qy.list().size());
				}else {		//通过
					qy = null;
					System.out.println("错误！");
				}
		}else {
			Type ty = (Type) getSession().get(Type.class,sech_type);
			if(type == 1) {	// 全部
				qy = getSession().createFilter(ty.getSet(),"where picturename like '%"+cha+"%' order by id desc");
				
			}else if(type == 2) {	//通过尺寸
				qy = getSession().createFilter(ty.getSet(),"where size like '"+cha+"%' order by id desc");
				System.out.println("soso"+qy.list().size());
			}else {		//通过
				qy = null;
				System.out.println("错误！");
			}
		}
		qy.setFirstResult((pageNow-1)*pageSize);
		qy.setMaxResults(pageSize);
		return qy.list();
	}
	
	//搜索图片条数
	public int sou_shu(int type,int sech_type ,String cha) {
		System.out.println(sech_type+">>>>"+type);
		Query qy;
		if(sech_type == 0) {	//sech_type为类型
			if(type == 1) {	// 全部
				qy = getSession().createQuery("from Picture where picturename like '%"+cha+"%'");	
				}else if(type == 2) {	//通过尺寸
					qy = getSession().createQuery("from Picture where size like '"+cha+"%'");
					System.out.println("soso"+qy.list().size());
				}else {		//通过
					qy = null;
					System.out.println("错误！");
				}
		}else {
			Type ty = (Type) getSession().get(Type.class,sech_type);
			if(type == 1) {	// 全部
				qy = getSession().createFilter(ty.getSet(),"where picturename like '%"+cha+"%' order by id desc");
				
			}else if(type == 2) {	//通过尺寸
				qy = getSession().createFilter(ty.getSet(),"where size like '"+cha+"%' order by id desc");
				System.out.println("soso"+qy.list().size());
			}else {		//通过
				qy = null;
				System.out.println("错误！");
			}
		}
		return qy.list().size();
	}
	
	//查询图片类型
	public List ck_type() {;
		Query qy = getSession().createQuery("from Type");
		List list = qy.list();
		return list;
	}
	
}
