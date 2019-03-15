package org.bigjava.entity;

public class User {
	private Integer id;		//用户
	private String username; 	//用户姓名
	private String password;	//用户
	private Integer age;	//用户年龄
	private Integer phone;	//用户联系方式
	private int vip;	//是否为vip，“1”属于VIP，“0”不属于
	private int state;	//是否封禁，“0”为正常， “1”为封禁  
	private Integer follow;	//用户关注数
	private Integer fans;	//用户粉丝数
	
	public User(){
		
	}
	public User(Integer id, String username, String password, Integer age, Integer phone, int vip, int state,
			Integer follow, Integer fans) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.phone = phone;
		this.vip = vip;
		this.state = state;
		this.follow = follow;
		this.fans = fans;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public int getVip() {
		return vip;
	}
	public void setVip(int vip) {
		this.vip = vip;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Integer getFollow() {
		return follow;
	}
	public void setFollow(Integer follow) {
		this.follow = follow;
	}
	public Integer getFans() {
		return fans;
	}
	public void setFans(Integer fans) {
		this.fans = fans;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", phone="
				+ phone + ", vip=" + vip + ", state=" + state + ", follow=" + follow + ", fans=" + fans + "]";
	}
}
