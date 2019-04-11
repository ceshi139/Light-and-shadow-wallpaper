<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/buju.css"/>
 	<link rel="stylesheet" type="text/css" href="css/base.css"/>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/texiao.js"></script>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
   <script type="text/javascript">
   		$(function(){
   			//分页跳转
   			$("#fenye").click(function(){
   	     		var pageNow = $("#tiao").val().trim();
   	     	    location.href="User_ckupload?pageNow="+pageNow;
   	     	});
   		});
   		function deng(){
   		 if(<%=session.getAttribute("totalSize") %>==0){
   		 	document.getElementById("deng").innerHTML="<div style='margin-left:45%;margin-top:15%'><h1><b>暂无作品</b></h1></br>(快点击上方分享吧)</div>";
   		 }
   		}
   	
   </script>
  <style type="text/css">
	.fenye{
		width:90px;
		height:34px;
		line-height: 34px;
		margin-right: 6px;
		padding: 0 15px;
		border: 1px solid #e1e2e3;
		background: #fff;
	}
	.fenye:hover{
		border: 1px solid #2828FF;
		background: #ECF5FF;
	}
</style>
</head>
<body onload="deng()">
<div>
  			<div id="deng">
                  <div class="bigbig">
                        <div class="big" style="margin-left:4%;">
                       <input type="hidden" id="user_id" value="${user.id}"/>
                            <s:iterator value="#session.pc7">
                 				
                                <div class="a"><img src='/img/<s:property value="url"/>' style="width:100%;"/>
                                    <div class="b">
                                        <div class="my_like_div" title="点击爱心收藏">
                                            <img class="my_like_img" title="添加收藏"  src="img/nolike.png" id="my_like" name='<s:property value="id"/>' />
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
                            <s:iterator value="#session.pc8">
                                <div class="a">
                                    <img src='/img/<s:property value="url"/>' style="width:100%;"/>
                                    <div class="b">
                                        <div class="my_like_div" title="点击爱心收藏">
                                            <img class="my_like_img" title="添加收藏"  src="img/nolike.png" id="my_like" name='<s:property value="id"/>' />
                                            <span class="my_like_div_nobr"><s:property value="CollectionNumber"/></span>
                                        </div>
                                        <div class="my_like_div2"  title="下载此图片">
                                            <img class="my_like_img2"  src="img/downloadimg.png"  />
                                            <span>下载图片</span>
                                        </div>
                                    </div>
                                </div>
                            </s:iterator>
                        </div>
                        <div class="big">
                            <s:iterator value="#session.pc9">
                                <div class="a"><img src='/img/<s:property value="url"/>' style="width:100%;"/>
                                    <div class="b">
                                        <div class="my_like_div" title="点击爱心收藏">
                                            <img class="my_like_img" title="添加收藏"  src="img/nolike.png" id="my_like" name='<s:property value="id"/>' />
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
                    </div>
                    
                    <div style="float:left;width:45%;margin:50px 0px 50px 30%;">
                    	<s:set name="page" value="#session.page" />
    				<b>当前页为第<s:property value="#page.pageNow" />页 共<s:property value="#page.TotalPage"/>页</b>
    				<s:if test="#page.hasFirst">
    					<a href="User_ckupload?pageNow=1"><input type="button" value="首页" class="fenye"/></a>
    				</s:if>
    				<s:if test="#page.hasPre">
    					<a href="User_ckupload?pageNow=<s:property value="#page.pageNow-1" />"><input type="button" value="上一页" class="fenye"/></a>
    				</s:if>
    				<s:if test="#page.hasNext">
    					<a href="User_ckupload?pageNow=<s:property value="#page.pageNow+1" />"><input type="button" value="下一页" class="fenye"/></a>
    				</s:if>
    				<s:if test="#page.hasLast">
    					<a href="User_ckupload?pageNow=<s:property value="#page.totalPage" />"><input type="button" value="尾页" class="fenye"/></a>
    				</s:if>
    				<input type="text" id="tiao" class="fenye"/><input type="button" value="跳转" class="fenye" id="fenye"/>
                 </div >
           </div>      
  </div>
 </body>
 </html>