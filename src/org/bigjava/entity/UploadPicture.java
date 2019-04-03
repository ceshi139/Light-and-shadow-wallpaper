package org.bigjava.entity;

public class UploadPicture {
	private Integer id;	//ͼƬid
	private String picturename;	//ͼƬ����
	private String url;	//ͼƬ
	private String size;	//ͼƬ�ߴ�
	private int type;	// �������ͱ�����
	private int userid;	//�����û�������
	private User user;
	
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
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
