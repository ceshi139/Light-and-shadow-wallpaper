<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" >

<head>
<meta charset="UTF-8">
<title>登陆/注册</title>

<!--图标样式-->
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.7.2/css/all.min.css'>

<link rel="stylesheet" href="css/loginstyle.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<%@ taglib prefix="s" uri="/struts-tags" %>
	
	<script type="text/javascript">
		$(function(){
		$("#regiest").click(function(){		//注册
				var u_v = $(".username").val();
				var p_v = $(".password").val();
				var m_v = $(".email").val();
				var c_v = $(".code").val();
				if(""==u_v){
					alert("名称不能为空！");
					return false;
				}
				if(""==p_v){
					alert("密码不能为空!");
					return false;
				}
				if(""==m_v){
					alert("邮箱不能为空!");
					return false;
				}
				if(""==c_v){
					alert("验证码不能为空!");
					return false;
				}
				var params = {
						username : u_v,
						password : p_v,
						email : m_v,
						code : c_v
				}
				$.ajax({
					url: "User_add",
					type: "post",
					data: params,
					datatype: "json",
					success:function(data,textStatus){
						alert(data.result);
						$("#tips").html(data.result);
					},
					errar:function(data,textStatus){
						alert("失败！");
						return false;
					}
			});	
		});
		var wait = 60;
		$("#code").removeAttr("disabled");
		$("#code").click(function(){		//获取验证码
			var m_v = $(".email").val();
			 $.cookie("key",1);
			if(m_v == ""){
				alert("邮箱不能为空！");
				return false;
			}
			var params = {
					email : m_v
			}
			$.ajax({
				url: "User_code",
				type: "post",
				data: params,
				datatype: "json",
				success:function(data,textStatus){
					alert(data.result);
					wait = 60;
					time(this);
				//	$("#tips").html(data.result);
				} 
		});
		});
		//验证码倒计时
		if($.cookie("key") == 1){
			wait = $.cookie("cookie");
			time(this);
		}
		function time(obj) {
	        if(wait==0) {
	            $("#code").removeAttr("disabled");
	            $("#code").val("重新获取");
	        }else {
	            $("#code").attr("disabled","true");
	            $("#code").val(wait+"秒后重试");
	            wait--;
	            $.cookie("cookie",wait);
	            setTimeout(function() {     //倒计时方法
	                time(obj);
	            },1000);    //间隔为1s
	        }
	    }
	});
	</script>
</head>

<body>
  <h2>登录/注册</h2>
<div class="container" id="container">
	<div class="form-container sign-up-container">
		<form>
			<h1>注册</h1>
			<div class="social-container">
				<a href="login_regiest.jsp#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="login_regiest.jsp#" class="social"><i class="fab fa-google-plus-g"></i></a>
				<a href="login_regiest.jsp#" class="social"><i class="fab fa-linkedin-in"></i></a>
			</div>
			<span>第三方账号注册</span>
			<input type="text" placeholder="名称" class="username" />
			<input type="email" placeholder="邮箱"  class="email"/>
			<input type="password" placeholder="密码" class="password"/>
			<div>
			<input type="text" placeholder="验证码" class="code" style="width:180px;float:left"" />
			<input id="code" type="button" value="获取验证码" style="width:100px;height:40px;float:left">
			</div>
			<span style="color:red;margin-bottom:3px" id="tips"></span>
			<button type="button" id="regiest">注册</button>
		</form>
	</div>
	<div class="form-container sign-in-container">
		<form action="User_login" method="post">
			<h1>登录</h1>
			<div class="social-container">
				<a href="login_regiest.jsp#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="login_regiest.jsp#" class="social"><i class="fab fa-google-plus-g"></i></a>
				<a href="login_regiest.jsp#" class="social"><i class="fab fa-linkedin-in"></i></a>
			</div>
			<span>第三方账号登录</span>
			<input type="email" placeholder="邮箱" name="user.email"/>
			<input type="password" placeholder="密码" name="user.password"/>
			<span style="color:red"><s:property value="#session.rt"/></span>
			<a href="login_regiest.jsp#">忘记密码？</a>
			<button type="submit" id="login">登录</button>
		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>欢迎回来！</h1>
				<p>请您先登录的个人信息，进行操作。</p>
				<button class="ghost" id="signIn">登录</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1>你好朋友！</h1>
				<p>输入您的个人信息注册成为会员。</p>
				<button class="ghost" id="signUp">注册</button>
			</div>
		</div>
	</div>
</div>

<footer>
	<p>
		版权声明
	</p>
</footer>
<script  src="js/index.js"></script>
</body>
</html>
