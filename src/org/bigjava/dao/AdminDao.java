package org.bigjava.dao;
import org.bigjava.entity.Admin;
import org.bigjava.entity.Picture;
import org.bigjava.entity.Type;

import java.util.List;

public interface AdminDao {
    
	//����Ա��¼
	public Admin login(Admin admin);
	
	//��ҳ��ѯȫ��
	public List chaAllUser(int pageNow, int pageSize, String username);
		
	//��ѯ������
	/*public int findTotalSize(); */
	
	//��ѯ������
	public int findTotalSize1(String username);
	
	public void fengjin(int id);
	
	public void jiefeng(int id);
	
	public List chaAllPicture(int pageNow, int pageSize, String imgname,String imgsize,String imgtype,String paixu);
	
	public Type cha(String types);
	//��ѯͼƬ��������
    public int findTotalSize(String imgsize,String imgtype,String imgname);
    
    //ͼƬ����
  	public List chaAllType(int pageNow, int pageSize, String typeName);

  	public List chaType();
  	
  	public List chaType(String types);
  	
  	//��ѯͼƬ����������
  	public int findTypeTotalSize(String typeName);
	
  	public List findById(int id);
  	
  	public void update(Type type);
  	
    //�������
  	public void addType(Type type);
  	
    //ɾ��ͼƬ����
  	public void delete(int id);
  	
  	//�ϴ�ͼƬ
  	public void addPicture(Picture picture);
  	
  	//ͨ��id��ѯ����
  	public Type findByIdType(int id);
  	
  	//ͨ��id��ѯͼƬ��Ϣ
    public List findByIdPicture(int id);
    
    //ͼƬ�޸�
    public void updatePicture(Picture picture);
    
  	public void deletePicture(int id);
  	
  	public void updatePassword(Admin admin);
  	
  	public List check(String oldPassword);
}
