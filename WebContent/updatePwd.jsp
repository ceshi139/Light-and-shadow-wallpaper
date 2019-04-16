<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updatePwd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script>
        $(function() {
        	 $('#rePwd').blur(function(){
        		  var rep = $(this).val();
        		  var str = $('#password').val();
        			 if(str != rep ){
        				 $('#sp4').html("密码不一致，请重新输入！")
        			 }
        		 });
        	 }); 
        
        $(function(){
        	 $('#submit').click(function(){
        		 var oldPwd = $("#oldPassword").val();
        		 var newPwd = $("#password").val();
        		 var rePwd = $("#rePwd").val();
        		 var name = $("#name").val();
        		 var id = $("#id").val();
        		 
        		 if(""== oldPwd) {
        			 $("#sp1").html("旧密码不能为空!");
        			 return false;
        		 }
        		 if("" == newPwd) {
        			 $("#sp2").html("新密码不能为空!");
        			 return false;
        		 }
        		 if("" == rePwd) {
        			 $("#sp3").html("确认密码不能为空");
        			 return false;
        		 }
        		 
        		 var params = {
        			  oldPassword:oldPwd,
        			  password1:newPwd,
        			  name:name,
        			  id : id
        		 };
        		 
        		 $.ajax({
        			  url:"updatePassword",
        			  type:"post",
        			  data:params,
        			  dataType:"json",
        			  
        			  success:function(data){
        				  if(data.result == "false"){
        					   $("#sp4").html("修改失败！")
        				  }else if(data.result == "true"){
        					  parent.location.href = "login.jsp";
        				  }  
        			  },
        			  
        			  error:function(data,textStatus) {
        				  alert(data);
        				  return false;
        			  }
        		 });
        	 });
        });
    </script>


  </head>
      <style>
           input{
             border-radius:6px;
             width:250px;
             height:40px;      
             filter:alpha(Opacity=80);-moz-opacity:0.8;opacity: 0.8;  
        }
      </style>
      
  
  
  <body>
    <div style="margin-left:100px;margin-top:30px;">
    
      <!-- <form action="updatePassword" method="post" target="_parent"> -->
                      
                     <input type="hidden" name="admin.id" value="${admin.id }" id="id"/> 
                     
                     <input type="hidden" name="admin.adminName" value="${admin.adminName }" id="name"/> 
                     
                     <input type="password" placeholder="请输入旧的的密码"/ name="oldPassword" id="oldPassword"><span id="sp1">${requestScope.error}</span><br/><br/>
                         
                     <input type="password" placeholder="请输入新的密码" name="admin.password" id="password"/><span id="sp2"></span><br/><br/>
                         
                     <input type="password" placeholder=" 请确认新的密码" id="rePwd"/><span id="sp3"></span><br/><br/>
                     
                     <span style="color:red;text-align:center; font-size:12px;" id="sp4"></span>
                         
                     <input type="submit" id="submit"/>                                 
           
     <!--  </form> -->
    </div>  
  </body>
</html>
