package org.bigjava.entity;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Picture implements Serializable {
	private int id;	//图片id
	private String picturename;
	private String url;	//图片
	private String size;	//图片尺寸
	private int state;	//收费状态，0表示不收，1收费
	private int CollectionNumber;//用户收藏数
	private Type type;
	private Set<User> set_user = new HashSet<User>();
	private User user;
	
	public Picture() {}
	public Picture(int id,String url, String size, int state) {
		this.id = id;
		this.url = url;
		this.size = size;
		this.state = state;
	}
	
	
	public String getPicturename() {
		return picturename;
	}
	public void setPicturename(String picturename) {
		this.picturename = picturename;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<User> getSet_user() {
		return set_user;
	}
	public void setSet_user(Set<User> set_user) {
		this.set_user = set_user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
   public int getCollectionNumber() {
        return CollectionNumber;
    }

    public void setCollectionNumber(int collectionNumber) {
        CollectionNumber = collectionNumber;
    }
	@Override
	public String toString() {
		return "Picture [id=" + id + ", picturename=" + picturename + ", url=" + url + ", size=" + size + ", state="
				+ state + ", CollectionNumber=" + CollectionNumber + ", type=" + type 
				+ ", user=" + user + "]";
	}
	
	
}
