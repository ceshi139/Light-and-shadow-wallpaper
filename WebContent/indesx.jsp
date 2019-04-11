<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" %>
<html>
<head>
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
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <base target="_blank">
  <script>
  	
  </script>
  <style type="text/css">

  </style>
</head>

<body style="background-color: #253242">
		 <div class="platform_advantage" style="background:#253242;">
                    <div class="bigbig">
                        <div class="big" style="margin-left:4%;">
                       <input type="hidden" id="user_id" value="${user.id}"/>
                            <s:iterator value="#session.pc1" >
               
                                <div class="a">
                                    <img src='<s:property value="url"/>' style="width:100%;"/>
                                    <div class="b">
                                        <div class="my_like_div" title="点击爱心收藏">
                                            <img class="my_like_img" title="添加收藏"  src="img/nolike.png" id="my_like" name='<s:property value="id"/>' />
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
                                            <img class="my_like_img" title="添加收藏"  src="img/nolike.png" id="my_like" name='<s:property value="id"/>' />
                                            <span><s:property value="CollectionNumber" /></span>
                                        </div>
                                        <div class="my_like_div2"  title="下载此图片">
                                            <img class="my_like_img2"  src="img/downloadimg.png"  />
                                            <span>下载图片</span>
                                        </div>
                                    </div>
                                </div>
                            </s:iterator>
                        </div>
                        <div class="big">
                            <s:iterator value="#session.pc3">
                                <div class="a">
                                    <img src='<s:property value="url"/>' style="width:100%;"/>


                                    <div class="b">
                                        <div class="my_like_div" title="点击爱心收藏">
                                            <img class="my_like_img" title="添加收藏"  src="img/nolike.png" id="my_like" name='<s:property value="id"/>' />
                                            <span><s:property value="CollectionNumber" /> </span>
                                        </div>
                                        <div class="my_like_div2"  title="下载此图片">
                                            <img class="my_like_img2"  src="img/downloadimg.png" />
                                            <span>下载图片</span>
                                        </div>

                                        <img style="position:relative;top: 90%;left: 10px; width: 60px;height: 60px;border-radius: 50%;" src="http://q.qlogo.cn/headimg_dl?bs=qq&dst_uin=<s:property value="#session.user.email" />&src_uin=qq.zy7.com&fid=blog&spec=640" />
                                    </div>
                                </div>
                            </s:iterator>
                        </div>
                    </div>
                </div>
</body>
</html>
