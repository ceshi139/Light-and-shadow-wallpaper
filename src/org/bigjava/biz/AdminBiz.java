package org.bigjava.biz;

import java.util.List;

import org.bigjava.entity.Admin;
import org.bigjava.entity.Picture;
import org.bigjava.entity.Type;


public interface AdminBiz {
	
	//��¼
	public Admin login(Admin admin);
	
	//��ҳ��ѯȫ��
	public List chaAllUser(int pageNow,int pageSize,String username);
	
	//��ѯ������
	/*public int findTotalSize(); */
	
	//��ѯ������
	public int findTotalSize1(String username);
	
	//���
	public void fengjin(int id);
	
	//���
	public void jiefeng(int id);
	
	//��ѯȫ��ͼƬ
	public List chaAllPicture(int pageNow, int pageSize,String url);
	
	public Type cha(String types);
	
	//��ѯͼƬ��������
	public int findTotalSize(String url);
	
	//ͼƬ����
	public List chaAllType(int pageNow,int pageSize,String typeName);

	public List chaType();
	//��ѯͼƬ����������
	public int findTypeTotalSize(String typeName);
	
	//�޸�ͼƬ����
	public List findById(int id);
	
	//�޸�ͼƬ����
	public void update(Type type);
	
	//�������
	public void addType(Type type);
	
	//��ѯȫ������
	public List chaType(String types);
	
	//ɾ��ͼƬ����
    public void delete(int id);
    
    //�ϴ�ͼƬ
    public void addPicture(Picture picture);
    
    //ͨ��id��ѯ����
    public Type findByIdType(int id);
    
    //ͼƬ��ɾ��
    public void deletePicture(int id);
    
    //ͨ��id��ѯͼƬ��Ϣ
    public List findByIdPicture(int id);
    
    //ͼƬ�޸�
    public void updatePicture(Picture picture);
    
    //�޸�����
    public void updatePassword(Admin admin);
    
    
    public List check(String oldPassword);
}
