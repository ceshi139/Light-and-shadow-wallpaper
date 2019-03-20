package org.bigjava.action;

import java.io.*;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.bigjava.biz.UserBiz;
import org.bigjava.entity.Picture;
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
	private int pageNow=1;		//当前页
	private int pageSize = 5;	//每页显示多少条
	private int type_id;	//类型id
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
	
	//判断用户名或密码是否为空
	public boolean isEmty(String isemty){
		if(isemty.trim().equals("") || isemty == null){
			return true;
		}
		return false;
	}
	
	//用户登陆
	public String login() {
		System.out.println("12"+user.getEmail());
		User ur = userbiz.login(user.getEmail(),user.getPassword());
		ActionContext.getContext().getSession().put("user",ur);
		if(isEmty(user.getEmail())|| isEmty(user.getPassword())){
			result = "账号或密码不能为空！";
			ActionContext.getContext().getSession().put("rt",result);
			return "login";
		}else if(ur == null){
			result = "账号或密码错误！";
			ActionContext.getContext().getSession().put("rt",result);
			return "login";
		} else {
			if(ur.getState()==0) {	//判断用户状态是否正常
				ActionContext.getContext().getSession().put("user",ur);
				ActionContext.getContext().getSession().remove("rt");
				return "index";
			}else {
				return "login";
			}
		}
	}
	
	//获取注册码
	public String code() throws EmailException{
		String code_a = ml.getcode();
		ActionContext.getContext().getSession().put("code",code_a);
		ml.sendEmail(email,code_a);
		result = "已发送！";
		return "add";
	}
	//用户注册
	public String add() {
		String code_a = (String) ActionContext.getContext().getSession().get("code");
		System.out.println("user"+username+"2"+email+"3"+password);
		if(isEmty(username)|| isEmty(password) || isEmty(email)){
			result = "账号或密码或邮箱不能为空！";
			return "add";
		}else {
			boolean ck = userbiz.checkemail(email);	//校验用户
			if(ck == true) {
				System.out.println("yyyyy");
				result = "该用户已存在";
				return "add";
			}
			if(code.equals(code_a)) {
				User user = new User();
				user.setUsername(username);
				user.setEmail(email);
				user.setPassword(password);
				userbiz.save(user);
				result = "注册成功！";
				return "add";
			}else {
				result = "验证码错误！！";
				return "add";
			}
		}
	}
	
	//修改用户信息
	public String update() {
		System.out.println("udate"+user);
		
		userbiz.update(user);
		return "update";
	}
	
	//查询默认图片
	public String findPicture() {
		System.out.println("find"+type_id);
		
		pic = userbiz.findall_picture(pageNow, pageSize, type_id);
		
		int totalSize = userbiz.tiaoshu(type_id);
		Page page = new Page(pageNow,pageSize,totalSize);
		ActionContext.getContext().getSession().put("pic",pic);
		ActionContext.getContext().getSession().put("page",page);
		
		return "picture";
	}
			
/*	
	
	private String des;//待上传的文件将要保存到哪里去
	private String filePath;//待上传的文件将要保存到des文件夹下的那个文件中去(使用依赖注入的一个字符串)

	private File file;//待上传的文件对象

	        //下面需要注意的是这个属性命名格式  必须是文件对象的文件名+ContentType,文件对象文件名+FileName。只有这样才能在上传图片的同时将图片的文件名加后缀，文件类型赋值上去
	private String fileContentType; // 上传文件类型
	private String fileFileName; // 上传文件的真实名字

	       //省阅get/set方法

	      public String fileUp()
	{ 
	des=ServletActionContext.getServletContext().getRealPath(this.filePath)+"\\"+this.fileFileName;//将要保存到服务器的文件路径
	try {
	moveTo(des, this.file.getPath());
	} catch (IOException e) {
	e.printStackTrace();
	}
	return SUCCESS;
	}
	  public void moveTo(String des,String from) throws IOException
	    {
	    *//**
	    * BufferedInputStream对象为FileInputStream(from)对象添加一些功能，（其实BufferedInputStream对象装饰了InputStream对象）
	    * BufferedInputStream对象的创建会创建一个内部缓冲区数组，会将FileInputStream(from)从磁盘读取的指定数据填充到该缓冲区
	    * BufferedOutputStream同理
	    *//*
	    BufferedInputStream bis=new BufferedInputStream(new FileInputStream(from));
	    BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(des));
	    byte[] b=new byte[1024*4];//每次从FileInputStream读取文件的字节数
	    int length;
	    while((length=bis.read(b))!=-1)
	    {
	    //将读取到的数据写入到指定的文件路径中
	    bos.write(b);
	    }
	    *//**
	    * 读完后，需要关闭输入，输出流
	    * 
	    *//*
	    if(null!=bis)
	    {
	    bis.close();//本方法的调用是关闭FileInputStream(from)的输入流
	    }
	    if(null!=bos)
	    {
	    bos.close();//本方法的调用是关闭FileOutStream(des)的输入流
	    }
	    }*/
	
}
