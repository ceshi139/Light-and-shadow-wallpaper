package org.bigjava.entity;

import java.util.HashSet;
import java.util.Set;
public class Type{

	private int id;
	private String pictureType;
	private Set<Picture> set = new HashSet<Picture>();
	
	public Set<Picture> getSet() {
		return set;
	}
	public void setSet(Set<Picture> set) {
		this.set = set;
	}
	public String getPictureType() {
		return pictureType;
	}
	public void setPictureType(String pictureType) {
		this.pictureType = pictureType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "Type [id=" + id + ", pictureType=" + pictureType + "]";
	}
	
}
