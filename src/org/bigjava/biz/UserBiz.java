package org.bigjava.biz;

import org.bigjava.entity.Picture;
import org.bigjava.entity.Type;
import org.bigjava.entity.UploadPicture;
import org.bigjava.entity.User;
import org.hibernate.Query;

import java.util.List;

public interface UserBiz {
	//鐢ㄦ埛鐧诲綍
	public User login(String username, String password);

	//鐢ㄦ埛娉ㄥ唽
	public void save(User user);

	//鐢ㄦ埛涓汉淇℃伅
	public User find(int id);

	//修改个人信息
	public void update(User user);	
	
	//校验邮箱是否存在
	public boolean checkemail(String email);
	
	//校验用户名是否存在

	public boolean checkusername(String username);

	//鐢ㄦ埛涓婁紶鍥剧墖
	public void userupload(UploadPicture uploadpicture);

	//鐢ㄦ埛鍒犻櫎涓婁紶鍥剧墖
	public void userdelete(int id);

	//鐢ㄦ埛鏀惰棌鍥剧墖
	public void collect(int id);

	//鐢ㄦ埛鍙栨秷鏀惰棌鍥剧墖
	public void decollect(int userid,int pictureid);

	//鏌ヨ鍥剧墖鏄惁宸叉敹钘�
	public boolean ckcollect(int userid,int pictureid);

	//鏌ヨ榛樿鍥剧墖
	public List<Picture> findall_picture(int pageNow,int pageSize,int type_id);

	//鏌ヨ鎬绘潯鏁�
	public int tiaoshu(int type_id);

	
	//查询图片类型

	public List ck_type();
}
