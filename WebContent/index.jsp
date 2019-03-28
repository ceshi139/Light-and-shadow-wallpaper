<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=yes">
    <meta http-equiv="Cache-Control" content="no-transform"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>光影壁纸</title>
    <meta name="renderer" content="webkit">
    <!--ico-->
    <link rel="stylesheet" type="text/css" href="css/base.css"/>
    <link rel="shortcut icon" href="../images/favicon1.ico">
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="css/animate.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/owl.carousel.css"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link rel="stylesheet" type="text/css" href="css/buju.css"/>
    <link type="text/css" href="css/button.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="css/responsive.css"/>
    <script src="js/jquery-1.11.0.min.js"></script>
    <script src="js/texiao.js"></script>
    <script src="js/wow.min_1.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/page.js"></script>
    <base target="_blank">


    <script >

        function type2(id) {
            window.location.href = "User_findPicture?type_id="+id;
        }

    </script >


    <%--//点击爱心--%>
    <script language="JavaScript">

    </script>
</head>
<body>
<s:action name="User_index" namespace="/"></s:action>
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
                        <li> <input type="text" style="border: 0px solid yellow;border-radius:4px;width: 600px;height:40px;padding-left: 12px;"/></li>
                        <li><button class="button button-glow button-border button-rounded button-primary" style="height: 42px;width: 80px;border-radius: 4px;padding: 0px;">搜索</button></li>

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



<div class="page">
    <div class="rowFluid">
        <div class="span12">
            <div class="main">
                <script src="js/login.js"></script>
                <div class="banner">
                    <div class="rowFluid">
                        <div class="span12">
                            <div class="owl-demo  wow fadeInUp">
                                <!--   <div class="item">
                                      <h3 class="banner_title">光影壁纸</h3>

                                      <div class="banner_jianjie">
                                         <input type="text" />
                                      </div>
                                  </div> -->
                            </div>


                            <ul class="platform_advantage_bg">
                                <%--方块特效--%>
                                <%--<li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>--%>
                            </ul>
                        </div>
                    </div>
                    <div id="container" class="mpage">
                        <div id="anitOut" class="anitOut"></div>
                    </div>
                </div>

                <div class="kzf-mod-product">
                    <s:iterator value="#session.types">
                        <input type="button" value="<s:property value="picturetype"/>" onclick="type2(<s:property value="id"/>)" />
                    </s:iterator>
                </div>

                <hr style="width: 80%;margin: 0 auto;">
                <div class="platform_advantage">
                    <div class="bigbig">
                        <div class="big" style="margin-left:4%;">
                            <s:iterator value="#session.pc1">
                                <div class="a"><img src='<s:property value="url"/>' style="width:100%;"/>
                                    <div class="b">
                                        <div class="my_like_div" title="点击爱心收藏">
                                            <img class="my_like_img" title="添加收藏"  src="img/nolike.png" id="my_like" />
                                            <span class="my_like_div_nobr"><s:property value="CollectionNumber"/></span>
                                        </div>
                                        <div class="my_like_div2"  title="下载此图片">
                                            <img class="my_like_img2"  src="img/downloadimg.png" />
                                            <span>下载图片</span>
                                        </div>
                                    </div>
                                </div>
                            </s:iterator>
                        </div>
                        <div class="big">
                            <s:iterator value="#session.pc2">
                                <div class="a">
                                    <img src='<s:property value="url"/>' style="width:100%;"/>
                                    <div class="b">
                                        <div class="my_like_div" title="点击爱心收藏">
                                            <img class="my_like_img" title="添加收藏"  src="img/nolike.png" id="my_like" />
                                            <span><s:property value="CollectionNumber" /></span>
                                        </div>
                                        <div class="my_like_div2"  title="下载此图片">
                                            <img class="my_like_img2"  src="img/downloadimg.png" />
                                            <span>下载图片</span>
                                        </div>
                                    </div>
                                </div>
                            </s:iterator>
                        </div>
                        <div class="big">
                            <s:iterator value="#session.pc3">
                                <div class="a"><img src='<s:property value="url"/>' style="width:100%;"/>
                                    <div class="b">
                                        <div class="my_like_div" title="点击爱心收藏">
                                            <img class="my_like_img" title="添加收藏"  src="img/nolike.png" id="my_like" />
                                            <span><s:property value="CollectionNumber" /> </span>
                                        </div>
                                        <div class="my_like_div2"  title="下载此图片">
                                            <img class="my_like_img2"  src="img/downloadimg.png" />
                                            <span>下载图片</span>
                                        </div>
                                    </div>
                                </div>
                            </s:iterator>
                        </div>
                    </div>
                </div>






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
            </div>
        </div>
    </div>
</div>

<SCRIPT langauge="javasript">document.oncontextmenu = new Function('event.returnValue=false;');
document.onselectstart = new Function('event.returnValue=false;');</SCRIPT>
</body>
</html>
