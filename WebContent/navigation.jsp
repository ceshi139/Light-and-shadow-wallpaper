<%--
  Created by IntelliJ IDEA.
  User: 七月。。
  Date: 2019-03-13
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/buju.css"/>
    <link rel="stylesheet" type="text/css" href="css/navigation.css"/>
    <link rel="stylesheet" type="text/css" href="css/base.css"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="css/animate.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/owl.carousel.css"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link type="text/css" href="css/button.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="css/responsive.css"/>
    <script src="js/jquery-1.11.0.min.js"></script>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/texiao.js"></script>
    <script src="js/wow.min_1.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/page.js"></script>

    <script type="text/javascript">
        $(function(){



        });
    </script>
</head>
<body>
<div class="header">
    <div class="container">
        <div class="rowFluid">
            <div class="span3 col-md-12">
                <div class="logo"><a href="index.jsp#" title="光影"> <img src="images/logo_me.png" style="width: 220px;height: 60px;margin-left: 10%;" alt="光影"/></a></div>
            </div>
            <div class="span9">
                <div class="mobileMenuBtn"><span class="span1"></span><span class="span2"></span><span
                        class="span3"></span></div>
                <div class="mobileMenuBtn_shad"></div>
                <div class="header_menu">
                    <ul id="menu">

                        <li>
                            <form  action="">

                            </form>
                            <input type="text" style="border: 0px solid yellow;border-radius:4px;width: 600px;height:40px;padding-left: 12px;"/>
                            <button class="button button-glow button-border button-rounded button-primary" style="height: 42px;width: 80px;border-radius: 4px;padding: 0px;">搜索</button>
                        </li>

                        <s:if test="#session.user.username!='www'">
                            <li><img title="<s:property value="#session.user.username"/>" class="Avatar" src="http://q.qlogo.cn/headimg_dl?bs=qq&dst_uin=<s:property value="#session.user.email" />&src_uin=qq.zy7.com&fid=blog&spec=640" /> </li>
                        </s:if>
                        <s:else>
                            <li><a href="login_regiest.jsp">登录/注册</a></li>
                        </s:else>

                        <div class="info">
                            <div>
                                <i class="fa fa-address-card-o" style="font-size:18px;color:#1E98F4;margin-right: 8px;"></i><a href="navigation.jsp" target="_self ">个人信息</a>
                            </div>
                            <hr>
                            <div>
                                <i class="fa fa-jsfiddle" style="font-size:18px;color:#1E98F4;margin-right: 8px;"></i> <a href="#">我的收藏</a>
                            </div>
                            <hr>
                            <div>
                                <i class="fa fa-leanpub" style="font-size:18px;color:#1E98F4;margin-right: 8px;"></i><a href="#">我的作品</a>
                            </div>
                            <hr>
                            <div>
                                <i class="fa fa-upload" style="font-size:18px;color:#1E98F4;margin-right: 8px;"></i><a href="#">上传图片</a>
                            </div>
                            <hr>
                            <div>
                                <i class="fa fa-dollar" style="font-size:18px;color:#1E98F4;margin-right: 8px;"></i><a href="#">我的余额</a>
                            </div>

                            <hr>
                            <div>
                                <i class="fa fa-sign-out" style="font-size:18px;color:#1E98F4;margin-right: 8px;"></i><a target="_self" href="User_removeSession">退出登录</a>
                            </div>

                        </div>
                    </ul>
                </div>
            </div>
            <div class="span2"></div>
        </div>
    </div>
</div>
<div class="main">
    <script src="js/login.js"></script>

    <div id="container" class="mpage">
        <div id="anitOut" class="anitOut"></div>
    </div>
</div>

<div style="width: 100%;height: 200px;border: 0px solid red;background-image: url(images/2.jpg);">

</div>


<div class="daohang">
    <ul id="test_ul">
        <li><a  href="Personal_center.jsp" target="text">个人中心</a></li>
        <li><a href="my_collection.jsp" target="text">我的收藏</a></li>
        <li><a href="my_collection.jsp" target="text">我的作品</a></li>

        <li><a href="upload_picture.jsp" target="text">上传图片</a></li>
        <li><a href="my_collection.jsp" target="text">我的余额</a></li>
        <li><a href="member.jsp" target="text">VIP中心</a></li>

    </ul>
</div>



   <iframe class="iframe_c" id="m_iframe"  src="upload_picture.jsp" name="text" frameborder="0" >

   </iframe>
    <%--框架无边框架构--%>
    <%--<script language="JavaScript">
        $(function(){
            $("#test_ul > li").click(function(){

                var heighta = $("#m_iframe").contents().find("body").height()+40;
               // alert(heighta);
                $("#m_iframe").height(heighta);
            });

        });

    </script>--%>



<div class="footer ">
    <div class="rowFluid">
        <div class="span12">
            <div class="container">
                <div class="footer_content">
                    <!--<div class="lianxi">全国分支机构</div>-->
                    <div class="span4 col-xm-6 col-xs-12 text_align">
                        <div class="footer_list">
                            <div class="footer_cotact">
                                <div class="footer_cotact_title text_align">某某服务</div>
                                <ul>
                                    <li class="span6"><a href="index.jsp">注册公司</a></li>
                                    <li class="span6"><a href="index.jsp">代理记账</a></li>
                                    <li class="span6"><a href="index.jsp">商标注册</a></li>
                                    <li class="span6"><a href="index.jsp">公司变更</a></li>
                                    <li class="span6"><a href="index.jsp">公司注销</a></li>
                                    <li class="span6"><a href="index.jsp">常见问题</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="span4 col-xm-6 col-xs-12 text_align">
                        <div class="footer_list">
                            <div class="footer_cotact">
                                <div class="footer_cotact_title text_align">某某财务（合肥）</div>
                                <ul>
                                    <li><span
                                            class="footer_cotact_content">地址：安徽省合肥市</span>
                                    </li>
                                    <li><span class="footer_cotact_content">电话：<a href="index.jsp#" class="call">400-0000-000</a></span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="span4 col-xm-6 col-xs-12 text_align">
                        <div class="footer_list">
                            <div class="footer_cotact">
                                <div class="footer_cotact_title"></div>
                                <ul>
                                    <li class="">
                                        <img src="images/xzapp.jpg" alt=""/>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="copyright">某某财务版权所有 抄袭必究</div>
            <div class="jiqiren">
                <div class="copyright">友情链接：
                    <span class="STYLE3">
                     <a href='index.jsp#'>合肥网站建设</a>
                  </span>
                    <span class="STYLE3">
                     <a href='index.jsp#'>网站建设</a>
                  </span>
                    <span class="STYLE3">
                     <a href='index.jsp#'>欧乐美网站建设</a>
                  </span>
                    <span class="STYLE3">
                     <a href='index.jsp#'>某某注册公司</a>
                  </span>
                    <span class="STYLE3">
                     <a href='index.jsp#'>公司注册</a>
                  </span>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
