<%--
  Created by IntelliJ IDEA.
  User: 七月。。
  Date: 2019-03-29
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
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
    <link rel="shortcut icon" href="../images/favicon1.ico">


    <link rel="stylesheet" type="text/css" href="css/buju.css"/>

    <script src="js/jquery-1.11.0.min.js"></script>
    <script src="js/texiao.js"></script>

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="js/boxImg.js" />
    <link rel="stylesheet" type="text/css" href="css/boxImg.css" />
    <%--<link rel="stylesheet" type="text/css" href="css/lightbox.css"/>
    <script type="text/javascript" src="js/lightBox.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function($) {
            $.LightBox({speed:500})
        });
    </script>--%>
</head>
<body>
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
                            <img class="my_like_img " title="添加收藏"  src="img/nolike.png" id="my_like" />
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
</body>
</html>
