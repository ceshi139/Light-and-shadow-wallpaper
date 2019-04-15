package org.bigjava.entity;

public class Picture {
	private Integer id;	//图片id
	private String url;	//图片
	private String size;	//图片尺寸
	private int state;	//收费状态，0表示不收，1收费
	private Type type;
	private String time;           //上传时间
	private String pictureName;    //图片名称
	private int CollectionNumber;  //收藏数
	private String format;
	


	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public int getCollectionNumber() {
		return CollectionNumber;
	}

	public void setCollectionNumber(int collectionNumber) {
		CollectionNumber = collectionNumber;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return "Picture [id=" + id + ", url=" + url + ", size=" + size + ", state=" + state + ", type=" + type
				+ ", time=" + time + ", pictureName=" + pictureName + ", CollectionNumber=" + CollectionNumber
				+ ", format=" + format + "]";
	}

}
