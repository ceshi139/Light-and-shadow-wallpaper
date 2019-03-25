<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>TEST</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" /> 

	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<%@ taglib prefix="s" uri="/struts-tags" %>
	
	<script type="text/javascript">
		$(function(){
			$("#login").click(function(){
				var u_v = $("input[name='username']").val();
				var p_v = $(":password").val();
				if(""==u_v){
					alert("用户名不能为空！");
					return false;
				}
				if(""==p_v){
					alert("密码不能为空!");
					return false;
				}
			});
		});
	</script>
</head>

<body>
	<div class="limiter">
		<div class="container-login100" style="background-image: url('img/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" method="post" action="User_login">
					<span class="login100-form-title p-b-49">登录</span>

					<div class="wrap-input100 validate-input m-b-23" data-validate="请输入用户名">
						<span class="label-input100">用户名</span>
						<input class="input100" type="text"  placeholder="请输入用户名" name="user.username" autocomplete="off">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="请输入密码">
						<span class="label-input100">密码</span>
						<input class="input100" type="password" name="user.password" placeholder="请输入密码">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>

					<div class="text-right p-t-8 p-b-31">
						<span style="color:red"><s:property value="#session.rt"/></span>
						<a href="javascript:">忘记密码？</a>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" type="submit" id="login">登 录</button>
						</div>
					</div>

					<div class="txt1 text-center p-t-54 p-b-20">
						<span>第三方登录</span>
					</div>

					<div class="flex-c-m">
						<a href="#" class="login100-social-item bg1">
							<i class="fa fa-wechat"></i>
						</a>

						<a href="#" class="login100-social-item bg2">
							<i class="fa fa-qq"></i>
						</a>

						<a href="#" class="login100-social-item bg3">
							<i class="fa fa-weibo"></i>
						</a>
					</div>

					<div class="flex-col-c p-t-25">
						<a href="registered.jsp" class="txt2">立即注册</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>