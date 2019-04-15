package org.bigjava.dao;
import java.util.List;
import org.bigjava.entity.Admin;
import org.bigjava.entity.Picture;
import org.bigjava.entity.Type;

public interface AdminDao {
    
	//管理员登录
	public Admin login(Admin admin);
	
	//分页查询全部
	public List chaAllUser(int pageNow,int pageSize,String username);
		
	//查询总条数
	/*public int findTotalSize(); */
	
	//查询总条数
	public int findTotalSize1(String username);
	
	public void fengjin(int id);
	
	public void jiefeng(int id);
	
	public List chaAllPicture(int pageNow, int pageSize,String url);
	
	public Type cha(String types);
	//查询图片的总条数
    public int findTotalSize(String url);
    
    //图片类型
  	public List chaAllType(int pageNow,int pageSize,String typeName);

  	public List chaType();
  	
  	public List chaType(String types);
  	
  	//查询图片类型总条数
  	public int findTypeTotalSize(String typeName);
	
  	public List findById(int id);
  	
  	public void update(Type type);
  	
    //添加类型
  	public void addType(Type type);
  	
    //删除图片类型
  	public void delete(int id);
  	
  	//上传图片
  	public void addPicture(Picture picture);
  	
  	//通过id查询类型
  	public Type findByIdType(int id);
  	
  	//通过id查询图片信息
    public List findByIdPicture(int id);
    
    //图片修改
    public void updatePicture(Picture picture);
    
  	public void deletePicture(int id);
  	
  	public void updatePassword(Admin admin);
  	
  	public List check(String oldPassword);
}
