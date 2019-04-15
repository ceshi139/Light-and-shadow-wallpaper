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

	//登录
	public Admin login(Admin admin) {        //登录
		
		return adminDao.login(admin);
	}
	
	//分页查询
	public List chaAllUser(int pageNow,int pageSize,String username) {
		List list = adminDao.chaAllUser(pageNow,pageSize,username);
		return list;
	}
	
	//查询总条数
	public int findTotalSize1(String username) {
		return adminDao.findTotalSize1(username);
	}
	
	public void fengjin(int id){
		adminDao.fengjin(id);
	}

	public void jiefeng(int id) {
		adminDao.jiefeng(id);
	}
	
	//查询全部的图片
	public List chaAllPicture(int pageNow, int pageSize,String url){
		return adminDao.chaAllPicture(pageNow, pageSize, url);
		
	}
	
	public Type cha(String types) {
	    return (Type) adminDao.cha(types);
	}
	//查询图片的总条数
	public int findTotalSize(String url) {
		
		return adminDao.findTotalSize(url);
	
	}
	
	//图片类型
	public List chaAllType(int pageNow,int pageSize,String typeName) {
		
		return adminDao.chaAllType(pageNow, pageSize, typeName);
		
	}

    //查询图片类型总条数
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
	
	//添加类型
	public void addType(Type type){
		adminDao.addType(type);
	}
	
	//删除图片类型
	public void delete(int id) {
		
		adminDao.delete(id);
	}
	
	public void addPicture(Picture picture) {
		
		 adminDao.addPicture(picture);
			
	}
	
   	public Type findByIdType(int id) {
   		 return (Type) adminDao.findByIdType(id);
   	}
	 //通过id查询图片信息
    public List findByIdPicture(int id) {
    	return adminDao.findByIdPicture(id);
    }
    
    //图片修改
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
