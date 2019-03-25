package org.bigjava.dao;

import java.util.List;

import org.bigjava.entity.Picture;
import org.bigjava.entity.Type;
import org.bigjava.entity.UploadPicture;
import org.hibernate.Query;

public interface PictureDao {
	//�ϴ��û�ͼƬ
	public void userupload(UploadPicture uploadpicture);
	
	//ɾ���û��ϴ�ͼƬ
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
	
	//��ѯͼƬ����
	public List ck_type();
}
