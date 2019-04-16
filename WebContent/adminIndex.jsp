<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link type="text/css" rel="apple-touch-icon" sizes="76x76" href="http://www.17sucai.com/preview/81082/2019-02-09/assets/img/apple-icon.png" />
	<link type="text/css" rel="icon" type="image/png" href="http://www.17sucai.com/preview/81082/2019-02-09/assets/img/favicon.png" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>后台管理主页</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
	<meta name="viewport" content="width=device-width" />

	<!-- Bootstrap core CSS     -->
	<link type="text/css" href="../css/bootstrap.min.css" rel="stylesheet" />

	<!--  Material Dashboard CSS    -->
	<link type="text/css" href="../css/material-dashboard.css" rel="stylesheet"/>

	<!--  CSS for Demo Purpose, don't include it in your project     -->
	<link type="text/css" href="../css/demo.css" rel="stylesheet" />

	<!--     Fonts and icons     -->
	<link type="text/css" href="../css/font-awesome.min.css" rel="stylesheet">
	<link href='../css/2d7207a20f294df196f3a53cae8a0def.css' rel='stylesheet' type='text/css'>
	<!--   Core JS Files   -->
	<script src="../js/jquery-3.1.0.min.js" type="text/javascript"></script>
	<script src="../js/bootstrap.min.js" type="text/javascript"></script>
	<script src="../js/material.min.js" type="text/javascript"></script>

	<!--  Charts Plugin -->
	<script type="text/javascript" src="../js/chartist.min.js"></script>
	<script type="text/javascript" src="../js/material-dashboard.js"></script>

	<!-- Material Dashboard DEMO methods, don't include it in your project! -->

	<script type="text/javascript" src="../myplugs/js/plugs.js">
	</script>
	<script type="text/javascript">
		//添加编辑弹出层
		function updatePwd(title, id) {
			$.jq_Panel({
				title: title,
				iframeWidth: 500,
				iframeHeight: 300,
				url: "updatePwd.jsp"
			});
		}
	</script>

	<script type="text/javascript">
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

	<div class="sidebar" data-color="purple" data-image="../assets/img/sidebar-1.jpg">

		<div class="logo">
			<a href="javascript:void (0);" class="simple-text">
				网站管理后台
			</a>
		</div>

		<div class="sidebar-wrapper">
			<ul class="nav">
				<li class="active">
					<a href="chaAllPicture" target="right">
						<p>图片管理</p>
					</a>
				</li>
				<li>
					<a href="chaAllType" target="right" >
						<p>图片类型管理</p>
					</a>
				</li>

				<li>
					<a href="chaAllUser" target="right" >

						<p>用户管理</p>
					</a>
				</li>
				<li>
					<a href="javascript:void(0)" onclick="updatePwd('修改密码',5)">

						<p>密码修改</p>
					</a>
				</li>
				<li>
					<a href="404.jsp" target="right" >

						<p>404错误页面</p>
					</a>
				</li>
				<li>
					<a href="news.html"target="right" >

						<p>资讯管理</p>
					</a>
				</li>
				<li>
					<a href="admin/links.jsp" target="right" >

						<p>友情链接</p>
					</a>
				</li>

			</ul>
		</div>
	</div>

	<div class="main-panel">
		<nav class="navbar navbar-transparent navbar-absolute" style="background-color: #fff;">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>

				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="index.html#pablo" class="dropdown-toggle" data-toggle="dropdown">
								<i class="material-icons">欢迎您，<s:property value="#session.admin.adminName"/></i>
								<p class="hidden-lg hidden-md">Dashboard</p>
							</a>
						</li>
						<li class="dropdown">
							<a href="index.html#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="material-icons"></i>
								<p class="hidden-lg hidden-md">Notifications</p>
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

					<iframe src="picture.jsp" width="100%" height="900" name="right" style="border: none;"></iframe>
				</div>
			</div>
		</div>
	</div>

</div>
</body>
</html>
