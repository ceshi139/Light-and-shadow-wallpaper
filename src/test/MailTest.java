package test;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.util.Random;
import java.util.Scanner;



public class MailTest{

    public static void main(String [] args) throws EmailException{

        StringBuffer buffer=new StringBuffer();
        Random random=new Random();
        for(int i=0;i<6;i++){
            buffer.append(random.nextInt(6)+"");

        }

        //snedEmail("hxf1376134288@163.com", buffer.toString());
        snedEmail("2034063966@qq.com", buffer.toString());
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入您接收的验证码:");
        String yzm=scanner.next();
        if(yzm.equals(buffer.toString())){
            System.out.println("输入正确！");
        }else{
            System.out.println("验证码有误!");
        }
    }
    public static void snedEmail(String emailaddress,String code)throws EmailException{
        HtmlEmail email=new HtmlEmail();
        email.setHostName("smtp.163.com");
        //email.setHostName("SMTP.qq.com");
        //email.setSmtpPort(587);

        email.setCharset("UTF-8");
        //收件地址
        email.addTo(emailaddress);
        //邮件的发送人与地址
        email.setFrom("hxf1376134288@163.com","验证码邮件");
        //email.setFrom("1376134288@qq.com","验证码邮件");
        //账户授权码用于登录邮箱服务器
        email.setAuthentication("hxf1376134288@163.com","qq3206234353");
        //email.setAuthentication("1376134288@qq.com", "yrdmmuaxbzgefhha");//账户+授权码
        //邮箱的标题
        email.setSubject("光影壁纸");
        //邮箱内容
        email.setMsg("您的的验证码是:"+code+"如非本人操作,请忽略此操作!");
        email.send();
    }
}