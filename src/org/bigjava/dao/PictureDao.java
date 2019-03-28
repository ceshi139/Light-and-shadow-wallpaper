package org.bigjava.dao;

import java.util.List;

import org.bigjava.entity.Picture;
import org.bigjava.entity.Type;
import org.bigjava.entity.UploadPicture;
import org.hibernate.Query;

public interface PictureDao {
	//涓婁紶鐢ㄦ埛鍥剧墖
	public void userupload(UploadPicture uploadpicture);
	
	//鍒犻櫎鐢ㄦ埛涓婁紶鍥剧墖
	public void userdelete(int id);


	//用户收藏图片

	public void collect(int id);
	
	//鐢ㄦ埛鍙栨秷鏀惰棌鍥剧墖
	public void decollect(int userid, int pictureid);
	
	//鏌ヨ鍥剧墖鏄惁宸叉敹钘�
	public boolean ckcollect(int userid, int pictureid);
	
	//鏌ヨ榛樿鍥剧墖
	public List<Picture> findall_picture(int pageNow, int pageSize, int type_id);
	
	//鏌ヨ鎬绘潯鏁�
	public int tiaoshu(int type_id);
	

	//查询图片类型

	public List ck_type();
}
