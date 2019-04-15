package org.bigjava.action;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.bigjava.biz.AdminBiz;
import org.bigjava.entity.Admin;
import org.bigjava.entity.Picture;
import org.bigjava.entity.Type;
import org.bigjava.entity.User;
import org.bigjava.util.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class AdminAction extends ActionSupport{
	
    private AdminBiz adminbiz;	
    private Admin admin;
    private Type type;
    private String result;
    private Picture picture;
    private String username="";
    private int pageNow = 1;// 动态改变 页面取得
	private int pageSize = 7;// 固定不变
	private int id;
	private String pictureName=""; 
	private String typeName="";
	/*private File file;*/
	private String fileFileName;
	private String url="";
	private int num;
	private File[] file;
	private String lei;
	private String oldPassword;
	private String password1;
	private String name;
	private String types;

	

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getLei() {
		return lei;
	}

	public void setLei(String lei) {
		this.lei = lei;
	}


	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	//管理登录
	public String login() {
		
		System.out.println("action"+admin);
		
		Admin admin1 = adminbiz.login(admin);
		
		if(admin1!=null){
			Map session = ActionContext.getContext().getSession();
			session.put("admin", admin1);
			
			return "login";
		}else{

            HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("no", "用户名或密码错误！");
			return "no";
		}
	}
    
	//分页查询全部用户
	public String chaAllUser() {
		 
		 System.out.println("action"+pageNow);
		 System.out.println(num);
		 if(num<=0){
    		 num=1;
    	 }
    	 int b = new Page(pageNow,adminbiz.findTotalSize(url),pageSize).getTotalPage();
    	 System.out.println("bbb"+b);
    	 if(num>b){
    		 pageNow=b;
    	 }
		List list = adminbiz.chaAllUser(pageNow, pageSize,username);
		
			Map session = ActionContext.getContext().getSession();
			
			Map request = (Map) ActionContext.getContext().get("request");
			
			session.put("list", list);
			
			Page page = new Page(pageNow, adminbiz.findTotalSize1(username),pageSize);
			
			request.put("page", page);
			
			return "chaAllUser";					    
	}
	
	//封禁
	public String fengjin() {
		
		System.out.println("id"+id);
		
		adminbiz.fengjin(id);
		
		return "fengjin";
	}

	//解封
     public String jiefeng() {
		
		System.out.println("id"+id);
		
		adminbiz.jiefeng(id);
		
		return "jiefeng";
	}
     
     //查询全部图片
     public String chaAllPicture() {
    	 
    	 System.out.println(url);
    	 System.out.println(num);
    	 if(num<=0){
    		 num=1;
    	 }
    	 int b = new Page(pageNow,adminbiz.findTotalSize(url),pageSize).getTotalPage();
    	 System.out.println("bbb"+b);
    	 if(num>b){
    		 pageNow=b;
    	 }
    	
    	 List list = adminbiz.chaAllPicture(pageNow, pageSize, url);
    	 
    	 Map session = ActionContext.getContext().getSession();
			
		 Map request = (Map) ActionContext.getContext().get("request");
		 	
		 session.put("list", list);
 	
		 Page page = new Page(pageNow, adminbiz.findTotalSize(url),pageSize);
			
		 request.put("page", page);
		 
		 return "chaAllPicture";
    	
     }
	    
     //查询全部类型
     public String chaAllType() {
    	 
    	 System.out.println("type");
    	 System.out.println(num);
    	 if(num<=0){
    		 num=1;
    	 }
    	 int b = new Page(pageNow,adminbiz.findTotalSize(url),pageSize).getTotalPage();
    	 System.out.println("bbb"+b);
    	 if(num>b){
    		 pageNow=b;
    	 }
    	 
    	 List list = adminbiz.chaAllType(pageNow, pageSize, typeName);
    	 
    	 Map session = ActionContext.getContext().getSession();
			
		 Map request = (Map) ActionContext.getContext().get("request");
		 	
		 session.put("list", list);
		 	
		 Page page = new Page(pageNow, adminbiz.findTypeTotalSize(typeName),pageSize);
			
		 request.put("page", page);
		 
		 return "chaAllType";
     }
     
     //通过id查询图片信息
     public String findById() {
    	 
    	 System.out.println(id);
    	 
    	 List list = adminbiz.findById(id);
    	 
    	 Map session = ActionContext.getContext().getSession();
    	 
    	 session.put("list", list);
    	 
    	 System.out.println(list);
    	 
    	 return "findById";
    	  
     }
     
     //图片类型修改
     public String update() {
    	 
    	 System.out.println(type);
    	 
    	 adminbiz.update(type);
    	 
    	 return "update";
     }
     
     //添加类型
     public String addType() {
    	 List list = adminbiz.chaType(types);
    	 if(list.size()>0){
    		HttpServletRequest request = ServletActionContext.getRequest();
 			request.setAttribute("no", "类型已存在！");  
    	 }else if(types!=""){
    	 Type type = new Type();
    	 type.setPictureType(types);
    	 adminbiz.addType(type);
    	 }   
    	 return "addType";
     }
     
     //图片的删除
     public String delete() {
    	 
    	 System.out.println("dele" + id);
    	 
    	 adminbiz.delete(id);
    	 
    	 return "delete";
     }
     
     //上传图片
     public String upload() throws Exception {
   	  
    	 System.out.println(id);
    	 System.out.println(file);
    	 System.out.println(fileFileName);
    	 System.out.println(picture);    	 
    	  
    	 
    	 String[] fileFileName1 = fileFileName.split(",");
	 
    	 if(file!= null) {
    		 for(int i = 0; i<fileFileName1.length;i++){
    		 Random rand = new Random();  //生成随机数
    		 int random = rand.nextInt();
    		 random = random > 0 ? random : (-1)*random; //随机负数转为正数
    		 
    		 //获得当前时间
    		 Date date = new Date();
    		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    		 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
    		 //将当前时间装转换为yyyyMMddHHmmss格式
    		 String currentTime = sdf.format(date);
    		 String currentTime1 = sf.format(date);   //获得上传时间 
    		 //设置文件名（新文件名 + 随机数+上传文件的后缀名）
    		 String imageFileName = currentTime + random;
    		 String newName = imageFileName + fileFileName1[i].substring(fileFileName1[i].lastIndexOf("."));
    		 
    		 String format = fileFileName1[i].substring(fileFileName1[i].lastIndexOf(".")+1);   // 文件格式
    		 
    		 //获得web服务器工作路径
    		 String realPath = ServletActionContext.getServletContext().getRealPath("/"); 
 
    		 //文件的存放位置 = web服务器中的项目的image路径 + 新文件名
    		 File destinationFile = new File("F:/image/"+ newName);
    		 
    		 System.out.println(realPath);
    		 System.out.println(destinationFile);
    		 System.out.println("imageFileName"+imageFileName);
    		 System.out.println();
    		 
    		 try {
				FileUtils.copyFile(this.file[i], destinationFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		 
    		 //图片的url
    		 String pt ="image/" + imageFileName+fileFileName1[i].substring(fileFileName1[i].lastIndexOf("."));
    		 System.out.println(pt);
    		 
    		 Type type = adminbiz.findByIdType(id);
    		 System.out.println(type);
    		 
    		 picture.setTime(currentTime1);
    		 picture.setPictureName(imageFileName);
    		 picture.setType(type);
    		 picture.setFormat(format);
    		 picture.setUrl(pt);
    	     System.out.println("111"+picture);
    	     adminbiz.addPicture(picture);
    	    }
    	     return "upload";
    	 }
    	     return "flase";
     }
     
   //上传图片
   /*  public String upload() throws Exception {
	  
    	 System.out.println(id);
    	 System.out.println(file);
    	 System.out.println(fileFileName);
    	 System.out.println(picture);
    	 if(file!= null) {
    		 
    		 Random rand = new Random();  //生成随机数
    		 int random = rand.nextInt();
    		 random = random > 0 ? random : (-1)*random; //随机负数转为正数
    		 
    		 //获得当前时间
    		 Date date = new Date();
    		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    		 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
    		 //将当前时间装转换为yyyyMMddHHmmss格式
    		 String currentTime = sdf.format(date);
    		 String currentTime1 = sf.format(date);   //获得上传时间 
    		 //设置文件名（新文件名 + 随机数+上传文件的后缀名）
    		 String imageFileName = currentTime + random;
    		 String newName = imageFileName + fileFileName.substring(fileFileName.lastIndexOf("."));
    		 
    		 String format = fileFileName.substring(fileFileName.lastIndexOf(".")+1);   // 文件格式
    		 
    		 //获得web服务器工作路径
    		 String realPath = ServletActionContext.getServletContext().getRealPath("/"); 
 
    		 //文件的存放位置 = web服务器中的项目的image路径 + 新文件名
    		 File destinationFile = new File("F:/image/"+ newName);
    		 
    		 System.out.println(realPath);
    		 System.out.println(destinationFile);
    		 System.out.println("imageFileName"+imageFileName);
    		 System.out.println();
    		 
    		 try {
				FileUtils.copyFile(this.file, destinationFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		 
    		 //图片的url
    		 String pt ="image/" + imageFileName+fileFileName.substring(fileFileName.lastIndexOf("."));
    		 System.out.println(pt);
    		 
    		 Type type = adminbiz.findByIdType(id);
    		 System.out.println(type);
    		 
    		 picture.setTime(currentTime1);
    		 picture.setPictureName(imageFileName);
    		 picture.setType(type);
    		 picture.setFormat(format);
    		 picture.setUrl(pt);
    	     System.out.println("111"+picture);
    	     adminbiz.addPicture(picture);
    	     return "upload";
    	 }
    	     return "flase";
     }*/
     
     //通过id查询图片信息
     public String findByIdPicture() {
    	  System.out.println(id);
    	  List list = adminbiz.findByIdPicture(id); 
    	  Map session = ActionContext.getContext().getSession();
     	  session.put("list", list);
     	  
     	  List list1 = adminbiz.chaType();
     	  Map session1 = ActionContext.getContext().getSession();
    	  session1.put("type", list1);
     	  
     	  System.out.println(list);
    	  return "findByIdPicture";
     }
     
     //修改图片信息
     public String updatePicture() {
    	  System.out.println(picture);
    	  System.out.println(id);
    	  Type type = adminbiz.findByIdType(id);
 		  System.out.println(type);
 		  picture.setType(type);
    	  adminbiz.updatePicture(picture);
    	  return "updatePicture";
     }

     //图片删除
     public String de() {
    	  System.out.println(id);
    	  adminbiz.deletePicture(id); 	
    	  return "deletePicture";
     }
     
     //修改密码
     public String updatePassword() {
    	 System.out.println(password1+oldPassword+name+id);
    	 List list = adminbiz.check(oldPassword);
    	 System.out.println(list.size());
    	 Admin admin = new Admin();
    	 System.out.println(admin);
    	 if(list.size()>0) {
    	   admin.setId(id);
    	   admin.setAdminName(name);
    	   admin.setPassword(password1);
    	   System.out.println(admin);
    	   adminbiz.updatePassword(admin);
    	
    	   this.result = "true";
    	  
    	 }else{
    	  
 		   this.result = "false";
    	   
    	 } 
    	  return "success";
     }
     
 	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public AdminBiz getAdminbiz() {
		return adminbiz;
	}
	
	public void setAdminbiz(AdminBiz adminbiz) {
		this.adminbiz = adminbiz;
	}
	
	public Admin getAdmin() {
		return admin;
	}
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
