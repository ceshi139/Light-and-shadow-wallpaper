package org.bigjava.action;

import java.io.*;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import org.bigjava.biz.UserBiz;
import org.bigjava.entity.Picture;
import org.bigjava.entity.User;
import org.bigjava.util.Page;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class UserAction extends ActionSupport{
	private UserBiz userbiz;
	private User user;
	private String result;
	private List<Picture> pic;
	private int pageNow=1;		//��ǰҳ
	private int pageSize = 5;	//ÿҳ��ʾ������
	private int type_id;	//����id
	
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
	
	//�ж��û����������Ƿ�Ϊ��
	public boolean isEmty(String isemty){
		
		if(isemty.trim().equals("") || isemty == null){
			return true;
		}
		return false;
	}
	
	//�û���½
	public String login() {
		User ur = userbiz.login(user.getUsername(),user.getPassword());
		if(isEmty(user.getUsername())|| isEmty(user.getPassword())){
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
	
	//�û�ע��
	public String add() {
		System.out.println("user"+user);
		
		if(isEmty(user.getUsername())|| isEmty(user.getPassword())){
			result = "�˺Ż����벻��Ϊ�գ�";
			return "add";
		}else {
			boolean ck = userbiz.checkusername(user.getUsername());	//У���û�
			if(ck == true) {
				result = "���û��Ѵ���";
				return "add";
			}
			userbiz.save(user);
			return "login";
		}
	}
	
	//�޸��û���Ϣ
	public String update() {
		System.out.println("udate"+user);
		
		userbiz.update(user);
		return "update";
	}
	
	//��ѯĬ��ͼƬ
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
	
	private String des;//���ϴ����ļ���Ҫ���浽����ȥ
	private String filePath;//���ϴ����ļ���Ҫ���浽des�ļ����µ��Ǹ��ļ���ȥ(ʹ������ע���һ���ַ���)

	private File file;//���ϴ����ļ�����

	        //������Ҫע������������������ʽ  �������ļ�������ļ���+ContentType,�ļ������ļ���+FileName��ֻ�������������ϴ�ͼƬ��ͬʱ��ͼƬ���ļ����Ӻ�׺���ļ����͸�ֵ��ȥ
	private String fileContentType; // �ϴ��ļ�����
	private String fileFileName; // �ϴ��ļ�����ʵ����

	       //ʡ��get/set����

	      public String fileUp()
	{ 
	des=ServletActionContext.getServletContext().getRealPath(this.filePath)+"\\"+this.fileFileName;//��Ҫ���浽���������ļ�·��
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
	    * BufferedInputStream����ΪFileInputStream(from)�������һЩ���ܣ�����ʵBufferedInputStream����װ����InputStream����
	    * BufferedInputStream����Ĵ����ᴴ��һ���ڲ����������飬�ὫFileInputStream(from)�Ӵ��̶�ȡ��ָ��������䵽�û�����
	    * BufferedOutputStreamͬ��
	    *//*
	    BufferedInputStream bis=new BufferedInputStream(new FileInputStream(from));
	    BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(des));
	    byte[] b=new byte[1024*4];//ÿ�δ�FileInputStream��ȡ�ļ����ֽ���
	    int length;
	    while((length=bis.read(b))!=-1)
	    {
	    //����ȡ��������д�뵽ָ�����ļ�·����
	    bos.write(b);
	    }
	    *//**
	    * �������Ҫ�ر����룬�����
	    * 
	    *//*
	    if(null!=bis)
	    {
	    bis.close();//�������ĵ����ǹر�FileInputStream(from)��������
	    }
	    if(null!=bos)
	    {
	    bos.close();//�������ĵ����ǹر�FileOutStream(des)��������
	    }
	    }*/
	
}
