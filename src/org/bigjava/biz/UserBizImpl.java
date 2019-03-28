package org.bigjava.biz;

import org.bigjava.dao.PictureDao;
import org.bigjava.dao.UserDao;
import org.bigjava.entity.Picture;
import org.bigjava.entity.UploadPicture;
import org.bigjava.entity.User;

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
	public void userupload(UploadPicture uploadpicture) {
		picturedao.userupload(uploadpicture);
	}
	
	//删除用户上传图片
	public void userdelete(int id) {
		picturedao.userdelete(id);
	}
	
	//用户收藏图片
	public void collect(int id) {
		picturedao.collect(id);
	}
	
	//用户取消收藏图片
	public void decollect(int userid,int pictureid) {
		picturedao.decollect(userid, pictureid);
	}
	
	//查询图片是否已收藏
	public boolean ckcollect(int userid,int pictureid) {
		return picturedao.ckcollect(userid, pictureid);
	}
	
	//查询默认图片
	public List<Picture> findall_picture(int pageNow,int pageSize,int type_id) {
		return picturedao.findall_picture(pageNow, pageSize, type_id);
	}
	
	//查询总条数
	public int tiaoshu(int type_id) {
		return picturedao.tiaoshu(type_id);
	}
	
	//查询图片类型
	public List ck_type() {
		return picturedao.ck_type();
	}
	
}
