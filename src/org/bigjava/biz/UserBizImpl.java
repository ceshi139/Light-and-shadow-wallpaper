package org.bigjava.biz;

import org.bigjava.dao.PictureDao;
import org.bigjava.dao.UserDao;
import org.bigjava.entity.Picture;
import org.bigjava.entity.User;


import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.List;

public class UserBizImpl implements UserBiz {
	
	private UserDao userdao;
	private PictureDao picturedao;
	
	public void setPicturedao(PictureDao picturedao) {
		this.picturedao = picturedao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	
	//用户登录
	public User login(String username, String password) {
		return userdao.login(username, password);
	}

	//用户注册
	public void save(User user) {
		userdao.save(user);
	}

	//用户个人信息
	public User find(int userid) {
		return userdao.find(userid);
	}

	//修改个人信息
	public void update(User user) {
		userdao.update(user);
	}

	//校验邮箱是否存在
	public boolean checkemail(String email) {
		return userdao.checkemail(email);
	}
	
	//校验用户是否存在
	public boolean checkusername(String username) {
		return userdao.checkusername(username);
	}
	
	//上传用户图片
	public void userupload(Picture picture) {
		picturedao.userupload(picture);
	}
	
	//查看上传图片

	public List<Picture> ck_upload(int user_id){
		return picturedao.ck_upload(user_id);
	}
	
	
	//删除用户上传图片
	public void userdelete(int id) {
		picturedao.userdelete(id);
	}
	
	//用户收藏图片
	public void collect(int user_id,int picture_id) {
		picturedao.collect(user_id, picture_id);
	}
	
	//用户取消收藏图片

	public void decollect(int userid,int pictureid) {
		picturedao.decollect(userid, pictureid);
	}
	

	//查询收藏
	public List<Picture> find_collect(int pageNow,int pageSize,int user_id){
		return picturedao.find_collect(pageNow, pageSize, user_id);
	}
	
	//查询图片是否已收藏
	public boolean ckcollect(int userid,int pictureid) {
		return picturedao.ckcollect(userid, pictureid);
	}
	
	//查询默认图片
	public List<Picture> findall_picture(int pageNow,int pageSize,int type_id) {
		return picturedao.findall_picture(pageNow, pageSize, type_id);
	}
	
	//搜索图片
	public List<Picture> sou(int type,int sech_type ,String cha,int pageNow ,int pageSize) {
		return picturedao.sou(type,sech_type, cha, pageNow, pageSize);
	}
	
	//搜索图片条数
	public int sou_shu(int type,int sech_type ,String cha) {
		return picturedao.sou_shu(type,sech_type, cha);
	}
	
	//查询总条数

	public int tiaoshu(int type_id) {
		return picturedao.tiaoshu(type_id);
	}
	
	//查询收藏表总条数
	public int shoucang_shu(int user_id) {
		return picturedao.shoucang_shu(user_id);
	}
	
	//查询上传表总条数
	public int upload_shu(int user_id) {
		return picturedao.upload_shu(user_id);
	}
	
	//查询图片类型

	public List ck_type() {
		return picturedao.ck_type();
	}

	//用户添加余额
	public Double addUserMoney(double money,String username){
		return userdao.addUserMoney(money,username);
	}

	
	//关注
	public void attention(int user_id,int fromuser_id) {
		userdao.attention(user_id, fromuser_id);
	}
	
	//取消关注
	public void de_attention(int user_id,int fromuser_id) {
		userdao.de_attention(user_id, fromuser_id);
	}
	
	//判断是否关注
	public boolean is_attention(int user_id,int fromuser_id) {
		return userdao.is_attention(user_id, fromuser_id);
	}
	
	}
