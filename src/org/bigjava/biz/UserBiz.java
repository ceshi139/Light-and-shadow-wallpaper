package org.bigjava.biz;

import java.util.List;

import org.bigjava.entity.Picture;
import org.bigjava.entity.UploadPicture;
import org.bigjava.entity.User;

public interface UserBiz {
	//用户登录
	public User login(String username, String password);
	
	//用户注册
	public void save(User user);
	
	//用户个人信息
	public User find(int id);
	
	//修改个人信息
	public void update(User user);	
	
	//校验用户是否存在
	public boolean checkusername(String username);
	
	//用户上传图片
	public void userupload(UploadPicture uploadpicture);
	
	//用户删除上传图片
	public void userdelete(int id);

	//用户收藏图片
	public void collect(int id);
	
	//用户取消收藏图片
	public void decollect(int userid,int pictureid);
	
	//查询图片是否已收藏
	public boolean ckcollect(int userid,int pictureid);
	
	//查询默认图片
	public List<Picture> findall_picture(int pageNow,int pageSize,int type_id);
	
	//查询总条数
	public int tiaoshu(int type_id);
}
