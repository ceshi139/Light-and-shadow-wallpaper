package org.bigjava.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import com.opensymphony.xwork2.ActionContext;

import java.util.Random;
import java.util.Scanner;

public class Mail{
	
	
	private String HostName = "smtp.163.com";
	private  String fromName = "光影壁纸";
	private String fromMail ="light_shadow_paper@163.com";
	private String shouquan = "abc987654321";
    
    //得到随机码
    public static String getcode() {
    	StringBuffer buffer=new StringBuffer();
        Random random=new Random();
        for(int i=0;i<6;i++){
            buffer.append(random.nextInt(6)+"");
        } 
        return buffer.toString();
	}
    //发送邮件
    public void sendEmail(String toMail,String code)throws EmailException{
    	HtmlEmail email=new HtmlEmail();
        email.setHostName(HostName);
        //email.setSmtpPort(587);
        email.setCharset("UTF-8");
        //设置收件人
        System.out.println(toMail);
        email.addTo(toMail);
        //和发送人的邮箱和用户名
        System.out.println("sad");
        email.setFrom(fromMail,fromName);
      
        //设置邮箱地址和授权码
        email.setAuthentication(fromMail, shouquan);
        //设置发送标题
        email.setSubject("注册码");
        
        //邮箱内容
        String content = "<html><head></head><body><h1>这是一封注册邮件,注册码为:</h1><h3><span style=\"color:red\">"+code+"</span></h3><br/>(如非本人操作,请忽略此操作!)</body></html>";
        email.setContent(content,"text/html;charset=UTF-8");
        email.setMsg("1111");
        System.out.println(code+"222");
        email.send();
    }

}