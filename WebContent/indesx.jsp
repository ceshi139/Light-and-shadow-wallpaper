<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  	$(function(){
		$("#shoucang").click(function(){
			alert(user_id);
		});


  	});
  </script>
  <style type="text/css">

  </style>
</head>

<body>
	     <div class="platform_advantage">
                    <div class="bigbig">
                        <div class="big" style="margin-left:4%;">
                         <s:iterator value="#session.pc1">            
                         	<div class="a"><img src='<s:property value="url"/>' style="width:100%;"/><div class="b">
                         	<form method="post" action="User_collect">
                         		<input type="hidden" name="user_id" value="${user.id}" />
                         		<input type="hidden" name="pic_id" value='<s:property value="id" /> '/>
                                <button id="shoucang">添加收藏</button> 
                            </form>
                            <button>图片信息</button>
                            </div></div>             	
                   		</s:iterator>
                        </div>
                        <div class="big">
                        <s:iterator value="#session.pc2">          
                         	  <div class="a"><img src='<s:property value="url"/>' style="width:100%;"/><div class="b">
                         	 	<input type="hidden" name="user_id" value="#session.user.id" />
                         		<input type="hidden" name="pic_id" value='<s:property value="id" /> '/>
                                <button>添加收藏</button>
                                <button>图片信息</button>
                            </div></div>            	
                   		</s:iterator>
                        </div>
                        <div class="big">
  						<s:iterator value="#session.pc3">          
                         	 <div class="a"><img src='<s:property value="url"/>' style="width:100%;"/><div class="b">
                         	 	<input type="hidden" name="user_id" value="#session.user.id" />
                         		<input type="hidden" name="pic_id" value='<s:property value="id" /> '/>
                                <button>添加收藏</button>
                                <button>图片信息</button>
                            </div></div>            	
                   		</s:iterator>
                  
                        </div>
                    </div>
                </div>

</body>
</html>
