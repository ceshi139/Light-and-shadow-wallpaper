package org.bigjava.biz;

import org.bigjava.dao.PictureDao;
import org.bigjava.dao.UserDao;
import org.bigjava.entity.Picture;
import org.bigjava.entity.Type;
import org.bigjava.entity.UploadPicture;
import org.bigjava.entity.User;
import org.hibernate.Query;

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

	
	//鐢ㄦ埛鐧诲綍
	public User login(String username, String password) {
		return userdao.login(username, password);
	}

	//鐢ㄦ埛娉ㄥ唽
	public void save(User user) {
		userdao.save(user);
	}

	//鐢ㄦ埛涓汉淇℃伅
	public User find(int userid) {
		return userdao.find(userid);
	}

	//淇敼涓汉淇℃伅
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
	
	//涓婁紶鐢ㄦ埛鍥剧墖
	public void userupload(UploadPicture uploadpicture) {
		picturedao.userupload(uploadpicture);
	}
	
	//鍒犻櫎鐢ㄦ埛涓婁紶鍥剧墖
	public void userdelete(int id) {
		picturedao.userdelete(id);
	}
	
	//鐢ㄦ埛鏀惰棌鍥剧墖
	public void collect(int id) {
		picturedao.collect(id);
	}
	
	//鐢ㄦ埛鍙栨秷鏀惰棌鍥剧墖
	public void decollect(int userid,int pictureid) {
		picturedao.decollect(userid, pictureid);
	}
	
	//鏌ヨ鍥剧墖鏄惁宸叉敹钘�
	public boolean ckcollect(int userid,int pictureid) {
		return picturedao.ckcollect(userid, pictureid);
	}
	
	//鏌ヨ榛樿鍥剧墖
	public List<Picture> findall_picture(int pageNow,int pageSize,int type_id) {
		return picturedao.findall_picture(pageNow, pageSize, type_id);
	}
	
	//鏌ヨ鎬绘潯鏁�
	public int tiaoshu(int type_id) {
		return picturedao.tiaoshu(type_id);
	}
	

	//查询图片类型

	public List ck_type() {
		return picturedao.ck_type();
	}
	
}
