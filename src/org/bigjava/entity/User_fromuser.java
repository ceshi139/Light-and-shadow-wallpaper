package org.bigjava.entity;

import java.util.HashSet;
import java.util.Set;

public class User_fromuser {
	private int id;
	private int fromuser_id;
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFromuser_id() {
		return fromuser_id;
	}
	public void setFromuser_id(int fromuser_id) {
		this.fromuser_id = fromuser_id;
	}
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "User_fromuser [id=" + id + ", fromuser_id=" + fromuser_id +  "]";
	}
	
	
	
}
