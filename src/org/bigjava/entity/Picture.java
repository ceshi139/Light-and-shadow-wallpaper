package org.bigjava.entity;

public class Picture {
	private Integer id;	//图片id
	private String picturename;	//图片名称
	private String url;	//图片
	private String size;	//图片尺寸
	private int state;	//收费状态，0表示不收，1收费
	private int type;	// 属于类型表主键
	
	public Picture() {}
	public Picture(Integer id, String picturename, String url, String size, int state, int type) {
		super();
		this.id = id;
		this.picturename = picturename;
		this.url = url;
		this.size = size;
		this.state = state;
		this.type = type;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Picture [id=" + id + ", picturename=" + picturename + ", url=" + url + ", size=" + size + ", state="
				+ state + ", type=" + type + "]";
	}
	
}
