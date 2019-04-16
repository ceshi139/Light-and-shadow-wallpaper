package org.bigjava.biz;

import org.bigjava.entity.Picture;
import org.bigjava.entity.User;

import java.util.List;

public interface UserBiz {
	//用户登录
	public User login(String username, String password);
	
	//用户注册
	public void save(User user);
	
	//用户个人信息
	public User find(int id);
	
	//修改个人信息
	public void update(User user);	
	
	//校验邮箱是否存在
	public boolean checkemail(String email);
	
	//校验用户名是否存在
	public boolean checkusername(String username);
	
	//用户上传图片
	public void userupload(Picture Picture);

	//查看上传图片
	public List<Picture> ck_upload(int user_id);
	
	//用户删除上传图片
	public void userdelete(int id);

	//用户收藏图片
	public void collect(int user_id, int picture_id);
	
	//用户取消收藏图片
	public void decollect(int userid, int pictureid);
	
	//查询收藏
	public List<Picture> find_collect(int pageNow, int pageSize, int user_id);
	
	//查询图片是否已收藏
	public boolean ckcollect(int userid, int pictureid);
	
	//查询默认图片
	public List<Picture> findall_picture(int pageNow, int pageSize, int type_id);
	
	//搜索图片
	public List<Picture> sou(int type,int sech_type ,String cha,int pageNow ,int pageSize);
	
	//搜索图片条数
	public int sou_shu(int type,int sech_type ,String cha);
	
	//查询总条数
	public int tiaoshu(int type_id);
	
	//查询收藏表总条数
	public int shoucang_shu(int user_id);
	
	//查询上传表总条数
	public int upload_shu(int user_id);
	
	//查询图片类型
	public List ck_type();

	//用户添加余额
	public Double  addUserMoney(double money,String username);
	
	//关注
	public void attention(int user_id,int fromuser_id);
	
	//取消关注
	public void de_attention(int user_id,int fromuser_id);
	
	//判断是否关注
	public boolean is_attention(int user_id,int fromuser_id);
	
}
