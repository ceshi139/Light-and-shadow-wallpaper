package org.bigjava.entity;

public class User {
	private Integer id;		//�û�
	private String username; 	//�û�����
	private String email;
	private String password;	//�û�����
	private Integer age;	//�û�����
	private char sex;
	private Integer phone;	//�û���ϵ��ʽ
	private int vip;	//�Ƿ�Ϊvip����1������VIP����0��������
	private int state;	//�Ƿ�������0��Ϊ������ ��1��Ϊ���  
	private Integer follow;	//�û���ע��
	private Integer fans;	//�û���˿��
	
	public User(){
		
	}
	public User(Integer id, String username, String email, String password, Integer age, char sex,Integer phone, int vip, int state,
			Integer follow, Integer fans) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.age = age;
		this.sex = sex;
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
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
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", age="
				+ age + ", sex=" + sex + ", phone=" + phone + ", vip=" + vip + ", state=" + state + ", follow=" + follow
				+ ", fans=" + fans + "]";
	}
	
	
	
}
