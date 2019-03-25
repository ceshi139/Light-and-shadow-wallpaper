package org.bigjava.entity;

public class Picture {
	private Integer id;	//ͼƬid
	private String url;	//ͼƬ
	private String size;	//ͼƬ�ߴ�
	private int state;	//�շ�״̬��0��ʾ���գ�1�շ�
	private Type type;
	
	public Picture() {}
	public Picture(Integer id,String url, String size, int state) {
		this.id = id;
		this.url = url;
		this.size = size;
		this.state = state;
		
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
	@Override
	public String toString() {
		return "Picture [id=" + id + ", url=" + url + ", size=" + size + ", state=" + state + ", type=" + type + "]";
	}
	
}
