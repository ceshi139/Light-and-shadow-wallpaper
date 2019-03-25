package org.bigjava.action;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.activation.MailcapCommandMap;

import org.apache.commons.mail.EmailException;
import org.bigjava.biz.UserBiz;
import org.bigjava.biz.UserBizImpl;
import org.bigjava.entity.Picture;
import org.bigjava.entity.Type;
import org.bigjava.entity.User;
import org.bigjava.util.Mail;
import org.bigjava.util.Page;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class UserAction extends ActionSupport{
	Mail ml = new Mail();
	private UserBiz userbiz;
	private User user;
	private String result;
	private List<Picture> pic;
	private int pageNow=1;		//��ǰҳ
	private int pageSize = 5;	//ÿҳ��ʾ������
	private int type_id;	//����id
	private String username;
	private String password;
	private String email;
	private String code;
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Picture> getPic() {
		return pic;
	}

	public void setPic(List<Picture> pic) {
		this.pic = pic;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserbiz(UserBiz userbiz) {
		this.userbiz = userbiz;
	}
	//�õ�type
	public String index() {
	List types = userbiz.ck_type();
	ActionContext.getContext().getSession().put("types", types);
	List<Picture> picList = userbiz.findall_picture(1, 100, 0);
	List pc1_List = new ArrayList();
	List pc2_List = new ArrayList();
	List pc3_List = new ArrayList();
	for(Picture pc : picList) {
		if(pc.getId()%3 == 1) {
			pc1_List.add(pc.getUrl());
		}else if(pc.getId()%3 == 2) {
			pc2_List.add(pc.getUrl());
		}else {
			pc3_List.add(pc.getUrl());
		}
	}
	ActionContext.getContext().getSession().put("pc1", pc1_List);
	ActionContext.getContext().getSession().put("pc2", pc2_List);
	ActionContext.getContext().getSession().put("pc3", pc3_List);
	System.out.println("qqq"+pc1_List);
	return "index";
	}
	
	//�ж��û����������Ƿ�Ϊ��
	public boolean isEmty(String isemty){
		if(isemty.trim().equals("") || isemty == null){
			return true;
		}
		return false;
	}
	
	//�û���½
	public String login() {
		System.out.println("12"+user.getEmail());
		User ur = userbiz.login(user.getEmail(),user.getPassword());
		ActionContext.getContext().getSession().put("user",ur);
		if(isEmty(user.getEmail())|| isEmty(user.getPassword())){
			result = "�˺Ż����벻��Ϊ�գ�";
			ActionContext.getContext().getSession().put("rt",result);
			return "login";
		}else if(ur == null){
			result = "�˺Ż��������";
			ActionContext.getContext().getSession().put("rt",result);
			return "login";
		} else {
			if(ur.getState()==0) {	//�ж��û�״̬�Ƿ�����
				ActionContext.getContext().getSession().put("user",ur);
				ActionContext.getContext().getSession().remove("rt");
				return "index";
			}else {
				return "login";
			}
		}
	}
	
	//��ȡע����
	public String code() throws EmailException{
		String code_a = ml.getcode();
		ActionContext.getContext().getSession().put("code",code_a);
		ml.sendEmail(email,code_a);
		result = "�ѷ��ͣ�";
		return "add";
	}
	//�û�ע��
	public String add() {
		String code_a = (String) ActionContext.getContext().getSession().get("code");
		System.out.println("user"+username+"2"+email+"3"+password);
		if(isEmty(username)|| isEmty(password) || isEmty(email)){
			result = "�˺Ż���������䲻��Ϊ�գ�";
			return "add";
		}else {
			boolean ck = userbiz.checkemail(email);	//У������
			boolean ck_username = userbiz.checkusername(username);
			if(ck == true) {
				result = "��������ע�ᣡ";
				return "add";
			}
			if(ck_username == true) {
				result = "�û����Ѵ��ڣ�";
				return "add";
			}
			if(code.equals(code_a)) {
				User user = new User();
				user.setUsername(username);
				user.setEmail(email);
				user.setPassword(password);
				userbiz.save(user);
				result = "ע��ɹ���";
				return "add";
			}else {
				result = "��֤����󣡣�";
				return "add";
			}
		}
	}
	
	//�޸��û���Ϣ
	public String update() {
		User ur = (User) ActionContext.getContext().getSession().get("user");
		System.out.println(ur.getUsername()+"po");
		System.out.println(user.getUsername()+"pop");
		if(user.getUsername() != ur.getUsername()) {
			boolean ck_username = userbiz.checkusername(username);
			if(ck_username == true) {
				ActionContext.getContext().getSession().put("ck_username","���û����Ѵ��ڣ�");
				return "update";
			}
		}
		userbiz.update(user);
		result ="�޸ĳɹ���";
		ActionContext.getContext().getSession().put("rt",result);
		return "login";
	}
	
	//��ѯĬ��ͼƬ
	public String findPicture() {
		System.out.println("find"+type_id);
		
		pic = userbiz.findall_picture(pageNow, pageSize, type_id);
		
		int totalSize = userbiz.tiaoshu(type_id);
		Page page = new Page(pageNow,pageSize,totalSize);
		ActionContext.getContext().getSession().put("pic",pic);
		ActionContext.getContext().getSession().put("page",page);
		
		return "index";
	}
	
	
}
