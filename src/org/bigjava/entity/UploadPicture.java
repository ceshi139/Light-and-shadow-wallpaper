package org.bigjava.entity;

public class UploadPicture {
	private Integer id;	//图片id
	private String picturename;	//图片名称
	private String url;	//图片
	private String size;	//图片尺寸
	private int type;	// 属于类型表主键
	private int userid;	//属于用户表主键
	
	public UploadPicture() {}
	public UploadPicture(Integer id, String picturename, String url, String size, int type, int userid) {
		super();
		this.id = id;
		this.picturename = picturename;
		this.url = url;
		this.size = size;
		this.type = type;
		this.userid = userid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPicturename() {
		return picturename;
	}
	public void setPicturename(String picturename) {
		this.picturename = picturename;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "UploadPicture [id=" + id + ", picturename=" + picturename + ", url=" + url + ", size=" + size
				+ ", type=" + type + ", userid=" + userid + "]";
	}
	
	
	
}
