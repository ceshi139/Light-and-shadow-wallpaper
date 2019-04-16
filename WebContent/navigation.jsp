<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>光影壁纸个人中心</title>
    <link rel="stylesheet" type="text/css" href="css/buju.css"/>
    <link rel="stylesheet" type="text/css" href="css/navigation.css"/>
    <link rel="stylesheet" type="text/css" href="css/base.css"/>
    <link rel="stylesheet" type="text/css" href="css/animate.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/owl.carousel.css"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link type="text/css" href="css/button.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="css/responsive.css"/>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/texiao.js"></script>
    <script src="js/wow.min_1.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script type="text/javascript" src="js/page.js"></script>
    <script type="text/javascript">
        $(function () {


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
                        <s:if test="#session.user.username!=''">
                            <li><img title="<s:property value="#session.user.username"/>" class="Avatar" src="http://q.qlogo.cn/headimg_dl?bs=qq&dst_uin=<s:property value="#session.user.email" />&src_uin=qq.zy7.com&fid=blog&spec=640" /> </li>
                        </s:if>
                        <s:else>
                            <li><a href="login_regiest.jsp">登录/注册</a></li>
                        </s:else>
                        <div class="info">
                            <div>
                                <i class="fa fa-address-card-o" style="font-size:18px;color:#1E98F4;margin-right: 8px;"></i><a href="Personal_center.jsp"  target="text_nav">个人信息</a>
                            </div>
                            <hr>
                            <div>
                                <i class="fa fa-jsfiddle" style="font-size:18px;color:#1E98F4;margin-right: 8px;"></i> <a href="my_collection.jsp" target="text_nav">我的收藏</a>
                            </div>
                            <hr>
                            <div>
                                <i class="fa fa-leanpub" style="font-size:18px;color:#1E98F4;margin-right: 8px;"></i><a href="my_upload.jsp"  target="text_nav">我的作品</a>
                            </div>
                            <hr>
                            <div>
                                <i class="fa fa-upload" style="font-size:18px;color:#1E98F4;margin-right: 8px;"></i><a href="upload_picture.jsp" name="upload_picture.jsp" target="text_nav">上传图片</a>
                            </div>
                            <hr>
                            <div>
                                <i class="fa fa-dollar" style="font-size:18px;color:#1E98F4;margin-right: 8px;"></i><a href="demo.jsp"  target="text_nav">充值中心</a>
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
<%--背景图片设置区--%>
<div style="width: 100%;height: 300px;border: 0px solid red;background-image: url(images/1.jpg);background-size:cover;background-position: 0px -200px;">

</div>


<div class="daohang">
    <ul id="test_ul">

        <li><a  href="Personal_center.jsp" target="text_nav">个人中心</a></li>
        <li><a  href="User_ckshoucang?user_id=${user.id}"  target="text_nav">我的收藏</a></li>
        <li><a href="User_ckupload?user_id=${user.id}" target="text_nav">我的作品</a></li>
        <li><a href="upload_picture.jsp" target="text_nav">上传图片</a></li>
        <li><a href="member.jsp" target="text_nav">VIP中心</a></li>
        <li><a href="demo.jsp" target="text_nav">充值中心</a></li>
    </ul>
</div>
<%--<div id="show"style="width: 400px;height: 30px;position: fixed;top: 300px;left: 20px;color: red;">测试滚动条</div>--%>

    <iframe id="iframe"  frameborder="0" scrolling="yes"  class="iframe_c" src="Personal_center.jsp" name="text_nav">
					
   	</iframe>
</body>
</html>
