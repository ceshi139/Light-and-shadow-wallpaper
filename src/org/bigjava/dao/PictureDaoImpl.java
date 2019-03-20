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
	//�õ�session
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//�ϴ��û�ͼƬ
	public void userupload(UploadPicture uploadpicture) {
		getSession().save(uploadpicture);
	}
	
	//ɾ���û��ϴ�ͼƬ
	public void userdelete(int id) {
		getSession().delete(id);
	}
	
	//�ϴ�Ĭ��ͼƬ
	public void adminupload(Picture picture) {
		getSession().save(picture);
	}
	
	//ɾ��Ĭ��ͼƬ
	public void admindelete(Picture picture) {
		getSession().delete(picture);
	}
	
	//�û��ղ�ͼƬ
	public void collect(int id) {
		String hql = "insert into collect select * from picture where id=:id";
		SQLQuery qy = getSession().createSQLQuery(hql);
		qy.setParameter("id", id); 
		qy.executeUpdate();
	}
	
	//�û�ȡ���ղ�ͼ
	public void decollect(int userid,int pictureid) {
		String hql = "delete from collect where id=:pictureid and userid=:userid";
		SQLQuery qy = getSession().createSQLQuery(hql);
		qy.setParameter("userid", userid);
		qy.setParameter("pictureid", pictureid);
		qy.executeUpdate();
		
	}
	
	//��ѯͼƬ�Ƿ����ղ�
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
	
	
	//��ѯ������
	public int tiaoshu(int type_id){
		int totalSize;
			if(type_id == 0) {	//����0ȫ��
				totalSize = getSession().createQuery("from Picture").list().size();
			}else {
				totalSize = getSession().createQuery("from Picture where id='"+type_id+"'").list().size();
			}
		return totalSize;
	}
	
	//��ѯĬ��ͼƬ
	public List<Picture> findall_picture(int pageNow,int pageSize,int type_id) {
		Query qy;
			if(type_id == 0) {  //����0ȫ��
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
	
	
	//��ѯ�û��ϴ�ͼƬ
	
}
