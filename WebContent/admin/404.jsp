<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP '404.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	 <link rel="stylesheet" href="css/404.css">

    <script src="js/jquery.3.1.1.min.js"></script>
    <script src="js/scriptalizer.js" type="text/javascript"></script>
    
    <script type="text/javascript">
        $(function(){
            $('#parallax').jparallax({});
        });
    </script>
	
  </head>
  
<body>

  <div id="parallax">
     <div class="error1">
        <img src="img/wand.jpg" alt="Mauer" />
     </div>
     
     <div class="error2">
        <img src="img/licht.png" alt="Licht" />
     </div>
     
     <div class="error3">
        <img src="img/halo1.png" alt="Halo1" />
     </div>
     
     <div class="error4">
        <img src="img/halo2.png" alt="Halo2" />
     </div>
     
     <div class="error5">
        <img src="img/batman-404.png" alt="Batcave 404" />
     </div>
  </div>
   
</body>
</html>
