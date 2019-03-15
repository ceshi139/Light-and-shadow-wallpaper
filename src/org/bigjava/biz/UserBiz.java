package org.bigjava.biz;

import java.util.List;

import org.bigjava.entity.Picture;
import org.bigjava.entity.UploadPicture;
import org.bigjava.entity.User;

public interface UserBiz {
	//�û���¼
	public User login(String username, String password);
	
	//�û�ע��
	public void save(User user);
	
	//�û�������Ϣ
	public User find(int id);
	
	//�޸ĸ�����Ϣ
	public void update(User user);	
	
	//У���û��Ƿ����
	public boolean checkusername(String username);
	
	//�û��ϴ�ͼƬ
	public void userupload(UploadPicture uploadpicture);
	
	//�û�ɾ���ϴ�ͼƬ
	public void userdelete(int id);

	//�û��ղ�ͼƬ
	public void collect(int id);
	
	//�û�ȡ���ղ�ͼƬ
	public void decollect(int userid,int pictureid);
	
	//��ѯͼƬ�Ƿ����ղ�
	public boolean ckcollect(int userid,int pictureid);
	
	//��ѯĬ��ͼƬ
	public List<Picture> findall_picture(int pageNow,int pageSize,int type_id);
	
	//��ѯ������
	public int tiaoshu(int type_id);
}
