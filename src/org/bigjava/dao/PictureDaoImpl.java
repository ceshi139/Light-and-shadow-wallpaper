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
	
	//�û��ղ�ͼƬ
	public void collect(int user_id,int picture_id) {
		String hql = "insert into user_picture (user_id,picture_id) value('"+user_id+"','"+picture_id+"')";
		System.out.println("daodao"+user_id);
		SQLQuery qy = getSession().createSQLQuery(hql);
		qy.executeUpdate();
	}
	
	
	//�û�ȡ���ղ�ͼ
	public void decollect(int userid,int pictureid) {
		String hql = "delete from user_picture where user_id='"+userid+"'and picture_id="+pictureid;
		SQLQuery qy = getSession().createSQLQuery(hql);
		System.out.println("daodao2"+userid);
		qy.executeUpdate();	
	}
	
	//��ѯ�ղ�
	public List<Picture> find_collect(int pageNow,int pageSize,int user_id) {
			User ur = (User) getSession().get(User.class,user_id);
			Query qy;
			qy = getSession().createFilter(ur.getSet_picture(), "order by this.id asc");
			qy.setFirstResult((pageNow-1)*pageSize);
			qy.setMaxResults(pageSize);
			System.out.println("dao"+qy.list());
			return qy.list();
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
				 qy =	getSession().createQuery("from Picture where type="+type_id);
				 System.out.println("pppp"+qy.list());
			}
		qy.setFirstResult((pageNow-1)*pageSize);
		qy.setMaxResults(pageSize);
		System.out.println("dao"+qy.list());
		return qy.list();
	}
	
	//��ѯͼƬ����
	public List ck_type() {;
		Query qy = getSession().createQuery("from Type");
		List list = qy.list();
		return list;
	}
}
