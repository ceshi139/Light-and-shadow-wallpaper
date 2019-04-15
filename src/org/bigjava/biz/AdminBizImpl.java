package org.bigjava.biz;

import java.util.List;

import org.bigjava.dao.AdminDao;
import org.bigjava.entity.Admin;
import org.bigjava.entity.Picture;
import org.bigjava.entity.Type;


public class AdminBizImpl implements AdminBiz {

	private AdminDao adminDao;
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	//��¼
	public Admin login(Admin admin) {        //��¼
		
		return adminDao.login(admin);
	}
	
	//��ҳ��ѯ
	public List chaAllUser(int pageNow,int pageSize,String username) {
		List list = adminDao.chaAllUser(pageNow,pageSize,username);
		return list;
	}
	
	//��ѯ������
	public int findTotalSize1(String username) {
		return adminDao.findTotalSize1(username);
	}
	
	public void fengjin(int id){
		adminDao.fengjin(id);
	}

	public void jiefeng(int id) {
		adminDao.jiefeng(id);
	}
	
	//��ѯȫ����ͼƬ
	public List chaAllPicture(int pageNow, int pageSize,String url){
		return adminDao.chaAllPicture(pageNow, pageSize, url);
		
	}
	
	public Type cha(String types) {
	    return (Type) adminDao.cha(types);
	}
	//��ѯͼƬ��������
	public int findTotalSize(String url) {
		
		return adminDao.findTotalSize(url);
	
	}
	
	//ͼƬ����
	public List chaAllType(int pageNow,int pageSize,String typeName) {
		
		return adminDao.chaAllType(pageNow, pageSize, typeName);
		
	}

    //��ѯͼƬ����������
	public int findTypeTotalSize(String typeName) {
		
		return adminDao.findTypeTotalSize(typeName);
	}
	
	public List findById(int id) {
		
	   return adminDao.findById(id);
		
	}
	
	public List chaType() {
		return adminDao.chaType();
	}
	
	public void update(Type type) {
		
		adminDao.update(type);
		
	}
	
	public List chaType(String types) {
		return adminDao.chaType(types);
		
	}
	
	//�������
	public void addType(Type type){
		adminDao.addType(type);
	}
	
	//ɾ��ͼƬ����
	public void delete(int id) {
		
		adminDao.delete(id);
	}
	
	public void addPicture(Picture picture) {
		
		 adminDao.addPicture(picture);
			
	}
	
   	public Type findByIdType(int id) {
   		 return (Type) adminDao.findByIdType(id);
   	}
	 //ͨ��id��ѯͼƬ��Ϣ
    public List findByIdPicture(int id) {
    	return adminDao.findByIdPicture(id);
    }
    
    //ͼƬ�޸�
    public void updatePicture(Picture picture) {
    	adminDao.updatePicture(picture);
    }
    
	public void deletePicture(int id) {
		adminDao.deletePicture(id);
	}
	
	public void updatePassword(Admin admin) {
		
		adminDao.updatePassword(admin);
	}
	
	 public List check(String oldPassword) {
		 return adminDao.check(oldPassword);
	 }
}
