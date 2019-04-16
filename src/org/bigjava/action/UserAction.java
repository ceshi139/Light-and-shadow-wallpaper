package org.bigjava.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.sun.mail.imap.protocol.ID;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.EmailException;
import org.apache.struts2.ServletActionContext;
import org.bigjava.biz.UserBiz;
import org.bigjava.entity.Picture;
import org.bigjava.entity.Type;
import org.bigjava.entity.User;
import org.bigjava.util.Mail;
import org.bigjava.util.Page;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class UserAction extends ActionSupport {
	Mail ml = new Mail();
	private UserBiz userbiz;
	private User user;
	private String result;
	private String result_a;
	private List<Picture> pic;
	private double money;//用户充值实际金额
	private String addmoneyuser; //充值用户名



	private Double usernowmoney; //用户现在money


	private int pageNow = 1; // 当前页

	private int pageSize = 6; // 每页显示多少条
	private int type_id = 0; // 类型id


	private String username;
	private String password;
	private String email;
	private String code;
	private int user_id;
	private int pic_id;
	private File[] file;
	private String fileFileName;
	private Picture picture;
	private int type;
	private String cha;
	private int sech_type;
	private int fromuser_id;
	
	
	public String getResult_a() {
		return result_a;
	}

	public void setResult_a(String result_a) {
		this.result_a = result_a;
	}

	public int getFromuser_id() {
		return fromuser_id;
	}

	public void setFromuser_id(int fromuser_id) {
		this.fromuser_id = fromuser_id;
	}

	public int getSech_type() {
		return sech_type;
	}

	public void setSech_type(int sech_type) {
		this.sech_type = sech_type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getCha() {
		return cha;
	}

	public void setCha(String cha) {
		this.cha = cha;
	}


	public Double getUsernowmoney() {
		return usernowmoney;
	}

	public void setUsernowmoney(Double usernowmoney) {
		this.usernowmoney = usernowmoney;
	}
	public String getAddmoneyuser() {
		return addmoneyuser;
	}

	public void setAddmoneyuser(String addmoneyuser) {
		this.addmoneyuser = addmoneyuser;
	}
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}


	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}



	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getPic_id() {
		return pic_id;
	}

	public void setPic_id(int pic_id) {
		this.pic_id = pic_id;
	}

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

	// 判断用户名或密码是否为空
	public boolean isEmty(String isemty) {
		if (isemty.trim().equals("") || isemty == null) {
			return true;
		}
		return false;
	}

     public String removeSession(){
	  	ServletActionContext.getRequest().getSession().removeAttribute("user");
	    System.out.println("删除session");
	    return "remove_success";
    }

	//用户登陆
	public String login() {
		System.out.println("12" + user.getEmail());
		User ur = userbiz.login(user.getEmail(), user.getPassword());
		if (isEmty(user.getEmail()) || isEmty(user.getPassword())) {
			result = "账号或密码不能为空！";
			ActionContext.getContext().getSession().put("rt", result);
			return "user-login";
		} else if (ur == null) {
			result = "账号或密码错误！";
			ActionContext.getContext().getSession().put("rt", result);
			return "user-login";
		} else {
			if (ur.getState() == 0) { // 判断用户状态是否正常
				ActionContext.getContext().getSession().put("user", ur);
    				//格式化金额
				DecimalFormat df=new DecimalFormat("0.00");
				df.format(ur.getMoneyover());
				ActionContext.getContext().getSession().put("usernowmoney",df.format(ur.getMoneyover()));
				ActionContext.getContext().getSession().remove("rt");
				return "index";
			} else {
				result = "此用户已被封禁";
				ActionContext.getContext().getSession().put("rt",result);
				return "user-login";
			}
		}
	}

	//获取注册码
	public String code() throws EmailException {
		String code_a = ml.getcode();
		ActionContext.getContext().getSession().put("code", code_a);
		ml.sendEmail(email, code_a);
		result = "已发送！";
		return "add";
	}

	// 注册
	public String add() {
		String code_a = (String) ActionContext.getContext().getSession().get("code");
		System.out.println("user" + username + "2" + email + "3" + password);
		if (isEmty(username) || isEmty(password) || isEmty(email)) {
			result = "账号或密码或邮箱不能为空！";
			return "add";
		} else {
			boolean ck = userbiz.checkemail(email); // 校验用户

			boolean ck_username = userbiz.checkusername(username);
			if (ck == true) {
				result = "该邮箱已注册！";
				return "add";
			}

			if (ck_username == true) {
				result = "用户名已存在！";

				return "add";
			}
			if (code.equals(code_a)) {
				User user = new User();
				user.setUsername(username);
				user.setEmail(email);
				user.setPassword(password);
				user.setMoneyover(0.00);
				userbiz.save(user);

				result = "注册成功！";
				return "add";
			} else {
				result = "验证码错误！！";

				return "add";
			}
		}
	}


	// 修改用户信息

	public String user_update() {
		User ur = (User) ActionContext.getContext().getSession().get("user");


		/*ur.setSet_picture(userbiz.ck_upload(ur.getId()));*/
		if (user.getUsername() != ur.getUsername()) {
			boolean ck_username = userbiz.checkusername(username);
			if (ck_username == true) {
				ActionContext.getContext().getSession().put("ck_username", "该用户名已存在！");
				return "update";
			}
		}
		System.out.println("useraction修改用户信息中的user>>>"+user);
		userbiz.update(user);

		result = "修改成功！";
		ActionContext.getContext().getSession().put("rt", result);
		return "login";
	}

	// 查询默认图片
	public String findPicture() {
		System.out.println("进来查询默认图片!");
		System.out.println("type_id是:"+type_id);
		System.out.println("pagesize++"+pageSize);
		if(type_id == 0){
			pageSize+=10;
			ActionContext.getContext().getSession().put("type_id", type_id);
		}else {
			ActionContext.getContext().getSession().put("type_id", type_id);
		}
		int type_id = (int) ActionContext.getContext().getSession().get("type_id");
		List types = userbiz.ck_type();
		ActionContext.getContext().getSession().put("types", types);
		int totalSize = userbiz.tiaoshu(type_id);
		ActionContext.getContext().getSession().put("totalSize", totalSize);

		if(pageNow<=0) {
			pageNow = 1;
		}
		int zong = new Page(pageNow,pageSize,totalSize).getTotalPage();
		if(pageNow>zong) {
			pageNow = zong;
		}
		Page page = new Page(pageNow, pageSize, totalSize);
		pic = userbiz.findall_picture(pageNow, pageSize, type_id);
		List<Picture> pc1_List = new ArrayList<Picture>();
		List<Picture> pc2_List = new ArrayList<Picture>();
		List<Picture> pc3_List = new ArrayList<Picture>();
		int i=1;
		for (Picture pc : pic) {
			if (i % 3 == 1) {
				pc1_List.add(pc);
				i++;
			} else if (i % 3 == 2) {
				pc2_List.add(pc);
				i++;
			} else {
				pc3_List.add(pc);
				i++;
			}
		}
		ActionContext.getContext().getSession().put("pc1", pc1_List);
		ActionContext.getContext().getSession().put("pc2", pc2_List);
		ActionContext.getContext().getSession().put("pc3", pc3_List);
		ActionContext.getContext().getSession().put("page", page);
		return "index";
	}

	// 收藏&取消收藏
	public String collect() {
		System.out.println("user_id" + user_id + "pic_id" + pic_id);
		boolean ck_collect = userbiz.ckcollect(user_id, pic_id);	//校验是否已收藏
		System.out.println(ck_collect);
		if(ck_collect == true) {
			userbiz.collect(user_id, pic_id);
			result = "1";
			return "collect";
		}else {
			userbiz.decollect(user_id, pic_id);
			result = "0";
			return "collect";
		}
	}
	
	//判断图片收藏和关注是被关注和收藏
	public String collectpic() {
		boolean ck_collect = userbiz.ckcollect(user_id, pic_id);
		boolean ck_attention = userbiz.is_attention(user_id, fromuser_id);
		
		System.out.println(ck_collect+"pp"+pic_id);
		if(ck_collect == true) {
			result = "1";
		}else if(ck_collect == false) {
			result = "0";
		}
		if(ck_attention == true) {
			result_a = "2";
		}else if(ck_attention == false){
			result_a = "3";
		}
		return "collect";
	}

	//查看收藏
	public String ckshoucang() {
		User ur = (User) ActionContext.getContext().getSession().get("user");
		int user_id = ur.getId();
		System.out.println("user_id" + user_id);

		int totalSize = userbiz.shoucang_shu(user_id);
		ActionContext.getContext().getSession().put("totalSize", totalSize);
		System.out.println("action"+pageNow);
		if(pageNow<=0) {
			pageNow = 1;
		}
		int zong = new Page(pageNow,pageSize,totalSize).getTotalPage();
		if(pageNow>zong) {
			pageNow = zong;
		}
		Page page = new Page(pageNow, pageSize, totalSize);
		pic = userbiz.find_collect(pageNow, pageSize, user_id);
		System.out.println("pic" + pic);
		List<Picture> pc1_List = new ArrayList<Picture>();
		List<Picture> pc2_List = new ArrayList<Picture>();
		List<Picture> pc3_List = new ArrayList<Picture>();
		int i=1;
		for (Picture pc : pic) {
			if (i % 3 == 1) {
				pc1_List.add(pc);
				i++;
			} else if (i % 3 == 2) {
				pc2_List.add(pc);
				i++;
			} else {
				pc3_List.add(pc);
				i++;
			}
		}
		ActionContext.getContext().getSession().put("pc4", pc1_List);
		ActionContext.getContext().getSession().put("pc5", pc2_List);
		ActionContext.getContext().getSession().put("pc6", pc3_List);
		ActionContext.getContext().getSession().put("page", page);
		return "shoucang";
	}

	//取消收藏
	public String deletecollect() {
		System.out.println("user_id" + user_id + "pic_id" + pic_id);
		userbiz.decollect(user_id, pic_id);

		return  "index";
	}

	// 图片上传
	public String up() throws Exception {
		User ur = (User) ActionContext.getContext().getSession().get("user");
		username = ur.getUsername();
		String[] filename = fileFileName.split(",");
		if (file != null) {
		for(int i = 0; i<filename.length;i++) {
			Random rand = new Random(); // 生成随机数
			int random = rand.nextInt();
			random = random > 0 ? random : (-1) * random; //  随机负数转为正数

			// 获得当前时间
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
			// 将当前时间装转换为yyyyMMddHHmmss格式
			String currentTime = sdf.format(date);
			String currentTime1=sf.format(date);
			// 设置文件名（新文件名 + 随机数+上传文件的后缀名）
			String imageFileName = currentTime + random;
			String newName = imageFileName + filename[i].substring(filename[i].lastIndexOf("."));
			System.out.println("filename是"+filename[i]);
			String format=filename[0].substring(filename[0].lastIndexOf(".")+1);

			// 获得web服务器工作路径
		//	String realPath = ServletActionContext.getServletContext().getRealPath("/");

			String realPath = "E:\\userimg\\image";
			// 文件的存放位置 = web服务器中的项目的image路径 + 新文件名
			File destinationFile = new File(realPath +"/"+username+"/" + newName);

			FileUtils.copyFile(this.file[i], destinationFile);
				/*
				 * try { FileUtils.copyFile(this.file[i], destinationFile); } catch (Exception
				 * e) { e.printStackTrace(); }
				 */

			// 图片的url
			String pt = "image/" +username+"/" + imageFileName + filename[i].substring(filename[i].lastIndexOf("."));

			Type type = new Type();
			type.setId(type_id);

			System.out.println("用户上传的选择的类型id是>>"+type_id);
			picture.setUser(ur);
			picture.setUrl(pt);
			picture.setType(type);
			picture.setTime(currentTime1);
			picture.setFormat(format);
			 userbiz.userupload(picture);
		}
			return "success";
		}
		return "false";
	}
	//查看上传
	public String ckupload() {
		User ur = (User) ActionContext.getContext().getSession().get("user");
		int user_id = ur.getId();

		System.out.println("user_id"+user_id);

		int totalSize = userbiz.upload_shu(user_id);
		ActionContext.getContext().getSession().put("totalSize", totalSize);
		if(pageNow<=0) {
			pageNow = 1;
		}
		int zong = new Page(pageNow,pageSize,totalSize).getTotalPage();
		if(pageNow>zong) {
			pageNow = zong;
		}
		Page page = new Page(pageNow, pageSize, totalSize);
		List<Picture> pic  = userbiz.ck_upload(user_id);

		List<Picture> pc1_List = new ArrayList<Picture>();
		List<Picture> pc2_List = new ArrayList<Picture>();
		List<Picture> pc3_List = new ArrayList<Picture>();
		int i=1;
		for (Picture pc : pic) {
			if (i % 3 == 1) {
				pc1_List.add(pc);
				i++;
			} else if (i % 3 == 2) {
				pc2_List.add(pc);
				i++;
			} else {
				pc3_List.add(pc);
				i++;
			}
		}
		ActionContext.getContext().getSession().put("pc7", pc1_List);
		ActionContext.getContext().getSession().put("pc8", pc2_List);
		ActionContext.getContext().getSession().put("pc9", pc3_List);
		ActionContext.getContext().getSession().put("page", page);

		return "upload";
	}

	//用户余额添加
	public String addmoney(){
		System.out.println("实际充值金额:"+money+"充值用户名为？"+addmoneyuser);
		usernowmoney=userbiz.addUserMoney(money,addmoneyuser);
		DecimalFormat df=new DecimalFormat("0.00");
		System.out.println("格式化后..."+df.format(usernowmoney));
		usernowmoney= Double.valueOf(df.format(usernowmoney));
		ActionContext.getContext().getSession().put("usernowmoney",df.format(usernowmoney));
		return "addsuccess";
	}
	
	//图片搜索
	public String cha() {
		System.out.println("嗖嗖嗖"+sech_type+">>>"+type+">>"+cha);
		
		int totalSize = userbiz.sou_shu(type,sech_type, cha);
		ActionContext.getContext().getSession().put("totalSize", totalSize);
		if(pageNow<=0) {
			pageNow = 1;
		}
		int zong = new Page(pageNow,pageSize,totalSize).getTotalPage();
		if(pageNow>zong) {
			pageNow = zong;
		}
		Page page = new Page(pageNow, pageSize, totalSize);
		List<Picture> pic  = userbiz.sou(type,sech_type , cha, pageNow, pageSize);
		
		List<Picture> pc1_List = new ArrayList<Picture>();
		List<Picture> pc2_List = new ArrayList<Picture>();
		List<Picture> pc3_List = new ArrayList<Picture>();
		int i=1;
		for (Picture pc : pic) {
			if (i % 3 == 1) {
				pc1_List.add(pc);
				i++;
			} else if (i % 3 == 2) {
				pc2_List.add(pc);
				i++;
			} else {
				pc3_List.add(pc);
				i++;
			}
		}
		ActionContext.getContext().getSession().put("pc1", pc1_List);
		ActionContext.getContext().getSession().put("pc2", pc2_List);
		ActionContext.getContext().getSession().put("pc3", pc3_List);
		ActionContext.getContext().getSession().put("page", page);
		
		return "index";
	}
	
	//重定向首页
	public String index() {
		return "index";
	}
	
	//关注
	public String attention(){
		User ur = (User) ActionContext.getContext().getSession().get("user");
		int user_id = ur.getId();
		System.out.println("attention"+user_id);
		System.out.println(">>>>>>"+user_id+">>>>>>>"+fromuser_id);
		boolean ck_att = userbiz.is_attention(user_id, fromuser_id);	//判断是否关注
		if(user_id!=0 && fromuser_id!=0) {
			if(ck_att == true) {
				userbiz.attention(user_id, fromuser_id);	//关注
				result = "1";	//成功
			}else {
				userbiz.de_attention(user_id, fromuser_id);
				result="2";		//取消关注！
			}
		}else {
			result ="3";		//请登陆
		}
		return "attention";
	}
	
	//查询是否关注了
	public String isattention(){
		
		return "";
	}
}
