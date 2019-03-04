package org.bigjava.entity;

public class Picture {
	private Integer id;	//图片id
	private String picturename;	//图片名称
	private String url;	//图片
	private String size;	//图片尺寸
	private int state;	//收费状态，0表示不收，1收费
	private int isupload;	//1为用户上传，0为管理员上传
	private int type;	// 属于类型表主键
	
}
