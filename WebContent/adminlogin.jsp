<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>管理员登录</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" /> 

	<link rel="stylesheet" type="text/css" href="../css/util.css">
	<link rel="stylesheet" type="text/css" href="../css/main.css">
	
	<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
	<%@ taglib prefix="s" uri="/struts-tags" %>
	
	<script type="text/javascript">
		$(function(){
			$("#login").click(function(){
				var u_v = $("input[name='username']").val();
				var p_v = $(":password").val();
			
				if(""==p_v || ""==u_v){
					$('#check').html("用户名或密码不能为空!");
					alert("密码不能为空!");
					return false;
				}
			});
		});
		
		/* 清空login传来的session值 */
		$(function() {
		    $("#name").click(function() {
		         $("#check").html(""); 
		    });
		  
		});
	</script>
</head>

<body>
	<div class="limiter">
		<div class="container-login100" style="background-image: url('../img/login1.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54" style="margin-left:45%;">
				<form class="login100-form validate-form" method="post" action="/admin/adminlogin.action" >
					<span class="login100-form-title p-b-49">管理员登录</span>

					<div class="wrap-input100 validate-input m-b-23" data-validate="请输入用户名">
						<span class="label-input100">用户名</span>
						<input class="input100" type="text"  placeholder="请输入用户名" name="admin.adminName" autocomplete="off" id="name">
						<span class="focus-input100" data-symbol="&#xf206;" id="name"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="请输入密码">
						<span class="label-input100">密码</span>
						<input class="input100" type="password" name="admin.password" placeholder="请输入密码">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					

                  
					<div class="text-right p-t-8 p-b-31">
					    

						<a href="javascript:">忘记密码？</a>
					</div>
					<div style="height: 50px;border:0px solid red;">
						<span id="check" style="margin-left: 166px;color:red;line-height: 50px;"> ${requestScope.no}</span>
						<span style="color:red""><s:property value="#session.rt"/></span>
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
							<i class="fa fa-wechat"><img src="../img/weixin.png" style="width:45px;height:45px;"/></i>

						</a>

						<a href="#" class="login100-social-item bg2">
							<i class="fa fa-qq"><img src="../img/qq.png" style="width:45px;height:45px;"/></i>
						</a>

						<a href="#" class="login100-social-item bg3">
							<i class="fa fa-weibo"><img src="../img/weibo.png" style="width:45px;height:45px;"/></i>
						</a>
				    </div>

				</form>
			</div>
		</div>
	</div>
</body>

</html>