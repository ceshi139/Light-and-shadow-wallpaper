package org.bigjava.entity;

public class Picture {
	private Integer id;	//ͼƬid
	private String url;	//ͼƬ
	private String size;	//ͼƬ�ߴ�
	private int state;	//�շ�״̬��0��ʾ���գ�1�շ�
	private Type type;
	private String time;           //�ϴ�ʱ��
	private String pictureName;    //ͼƬ����
	private int CollectionNumber;  //�ղ���
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
