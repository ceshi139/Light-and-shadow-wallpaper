package org.bigjava.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.IOException;

public class RechargeAction extends ActionSupport {
     String token = "O7Mp9DKB0ExHD4Z4bcahJk7J8WlnjdGm"; //记得更改 http://codepay.fateqq.com 后台可设置
     String codepay_id ="205789" ;//记得更改 http://codepay.fateqq.com 后台可获得
     String notify_url="";//通知地址
     String return_url="http://localhost:8080/demo.jsp";//支付后同步跳转地址
     public String price;
     public String pay_id;
     public String type;
     public String param;



    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPay_id() {
        return pay_id;
    }

    public void setPay_id(String pay_id) {
        this.pay_id = pay_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCodepay_id() {
        return codepay_id;
    }

    public void setCodepay_id(String codepay_id) {
        this.codepay_id = codepay_id;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    String url="http://codepay.fateqq.com:52888/creat_order?id="+codepay_id+"&pay_id="+pay_id+"&price="+price+"&type="+type+"&token="+token+"&param="+param+"&notify_url="+notify_url+"&return_url="+return_url;


    public String GetMoney() throws IOException {
        System.out.println("内容有"+price+pay_id+type+param);
        System.out.println(url);
        return SUCCESS;
    }
}
