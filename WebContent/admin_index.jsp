<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- Bootstrap core CSS     -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    
    <!--  Material Dashboard CSS    -->
    <link href="css/material-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="css/demo.css" rel="stylesheet" />

    <!--     Fonts and icons     -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href='css/2d7207a20f294df196f3a53cae8a0def.css' rel='stylesheet' type='text/css'>
	<%@ taglib prefix="s" uri="/struts-tags" %>
	<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/material.min.js" type="text/javascript"></script>
	<script src="js/chartist.min.js"></script>
	<script src="js/material-dashboard.js"></script>
	<script type="text/javascript" src="myplugs/js/plugs.js"></script>
	<script type="text/javascript">
		//添加编辑弹出层
		function updatePwd(title, id) {
			$.jq_Panel({
				title: title,
				iframeWidth: 500,
				iframeHeight: 300,
				url: "updatePwd.html"
			});
		}
		
    	$(document).ready(function(){
			$(".nav li").click(function(){
				$(".nav li").removeClass("active");
				$(this).addClass("active");
		})
    		});
	</script>
  </head>
  <body>
  		<div class="wrapper">
	    <div class="sidebar" data-color="purple">
			<div class="logo">
				<a href="index.html#" class="simple-text">
					<b>网站管理后台</b>
				</a>
			</div>

	    	<div class="sidebar-wrapper">
	            <ul class="nav">
	                <li class="active">
	                    <a href="product.html" target="right">
	                        <p><b>产品管理</b></p>
	                    </a>
	                </li>
	                <li>
	                    <a href="newsType.html" target="right" >
	                        <p><b>资讯类别管理</b></p>
	                    </a>
	                </li>
	                <li>
	                    <a href="news.html"target="right" >
	                        <p><b>资讯管理</b></p>
	                    </a>
	                </li>
	                <li>
	                    <a href="link.html" target="right" >
	                        <p><b>友情链接</b></p>
	                    </a>
	                </li>
	                <li>
	                    <a href="user.html" target="right" >
	                        <p><b>用户管理</b></p>
	                    </a>
	                </li>
	                <li>
	                    <a href="javascript:void(0)" onclick="updatePwd('修改密码',5)">
	                        <p><b>密码修改</b></p>
	                    </a>
	                </li>
	                 <li>
	                    <a href="404.html" target="right" >
	                        <p><b>404错误页面</b></p>
	                    </a>
	                </li>
	              
	            </ul>
	    	</div>
	    </div>

	    <div class="main-panel">
			<nav class="navbar navbar-transparent navbar-absolute" style="background-color: #fff;">
				<div class="container-fluid">
					<div class="navbar-header">
						
					</div>
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav navbar-right">
							<li>
								<a href="index.html#pablo" class="dropdown-toggle" data-toggle="dropdown">
									Dashboard
								</a>
							</li>
							<li class="dropdown">
								<a href="index.html#" class="dropdown-toggle" data-toggle="dropdown">
									Notifications
								</a>
								<ul class="dropdown-menu">
									<li><a href="index.html#">退出</a></li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</nav>

		<div class="content">
			<div class="container-fluid">
				<div class="row" style="margin-top: -15px;">
					<iframe src="product.html" width="100%" height="900" name="right" style="border: none;"></iframe>
				</div>
			</div>
		</div>
		
	</div>

</body>
</html>
