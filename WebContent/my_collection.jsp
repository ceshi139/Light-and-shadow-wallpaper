<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/buju.css"/>

    <script src="js/jquery-3.3.1.min.js"/>
    <script src="js/texiao.js"></script>
    <%@ taglib prefix="s" uri="/struts-tags" %>
</head>
<body>
<div>

  <div>
      <div style="width:100%;height:120px;border: 0px solid red;">
          <img src="images/22.jpg" style="width: 100px;height: 100px;border-radius:50%;margin-left: 47%;"/>
          <p style="text-align: center"><s:property value="#session.user.username" />的收藏夹</p>
      </div>
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
</div>

</body>
</html>
