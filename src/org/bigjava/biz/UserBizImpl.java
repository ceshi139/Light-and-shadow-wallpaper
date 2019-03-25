package org.bigjava.biz;

import org.bigjava.dao.UserDao;

import java.util.List;

import org.bigjava.dao.PictureDao;
import org.bigjava.entity.Picture;
import org.bigjava.entity.Type;
import org.bigjava.entity.UploadPicture;
import org.bigjava.entity.User;
import org.hibernate.Query;

public class UserBizImpl implements UserBiz {
	
	private UserDao userdao;
	private PictureDao picturedao;
	
	public void setPicturedao(PictureDao picturedao) {
		this.picturedao = picturedao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	
	//�û���¼
	public User login(String username, String password) {
		return userdao.login(username, password);
	}

	//�û�ע��
	public void save(User user) {
		userdao.save(user);
	}

	//�û�������Ϣ
	public User find(int userid) {
		return userdao.find(userid);
	}

	//�޸ĸ�����Ϣ
	public void update(User user) {
		userdao.update(user);
	}

	//У�������Ƿ����
	public boolean checkemail(String email) {
		return userdao.checkemail(email);
	}
	
	//У���û��Ƿ����
	public boolean checkusername(String username) {
		return userdao.checkusername(username);
	}
	
	//�ϴ��û�ͼƬ
	public void userupload(UploadPicture uploadpicture) {
		picturedao.userupload(uploadpicture);
	}
	
	//ɾ���û��ϴ�ͼƬ
	public void userdelete(int id) {
		picturedao.userdelete(id);
	}
	
	//�û��ղ�ͼƬ
	public void collect(int id) {
		picturedao.collect(id);
	}
	
	//�û�ȡ���ղ�ͼƬ
	public void decollect(int userid,int pictureid) {
		picturedao.decollect(userid, pictureid);
	}
	
	//��ѯͼƬ�Ƿ����ղ�
	public boolean ckcollect(int userid,int pictureid) {
		return picturedao.ckcollect(userid, pictureid);
	}
	
	//��ѯĬ��ͼƬ
	public List<Picture> findall_picture(int pageNow,int pageSize,int type_id) {
		return picturedao.findall_picture(pageNow, pageSize, type_id);
	}
	
	//��ѯ������
	public int tiaoshu(int type_id) {
		return picturedao.tiaoshu(type_id);
	}
	
	//��ѯͼƬ����
	public List ck_type() {
		return picturedao.ck_type();
	}
	
}
