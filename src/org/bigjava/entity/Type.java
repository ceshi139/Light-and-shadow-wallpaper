package org.bigjava.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Type implements Serializable {
	private int id;
	private String picturetype;
	private Set<Picture> set = new HashSet<Picture>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<Picture> getSet() {
		return set;
	}
	public void setSet(Set<Picture> set) {
		this.set = set;
	}
	public String getPicturetype() {
		return picturetype;
	}
	public void setPicturetype(String picturetype) {
		this.picturetype = picturetype;
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", picturetype=" + picturetype ;
	}

}
