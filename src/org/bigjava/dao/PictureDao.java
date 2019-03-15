package org.bigjava.dao;

import java.util.List;

import org.bigjava.entity.Picture;
import org.bigjava.entity.UploadPicture;

public interface PictureDao {
	//上传用户图片
	public void userupload(UploadPicture uploadpicture);
	
	//删除用户上传图片
	public void userdelete(int id);
	
	//上传管理图片
	public void adminupload(Picture picture);
	
	//删除管理图片
	public void admindelete(Picture picture);
	
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
