<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>我的收藏...</title>
    <%--<script type="text/javascript" src="js/jquery.min.js" ></script>
    <script src="js/message.js" ></script>--%>
    <%--<link rel="stylesheet" type="text/css" href="css/message.css"  />
       <link rel="stylesheet" type="text/css" href="css/bootstrap.css"  />--%>
    <link rel="stylesheet" href="css/screen.css">
    <link rel="stylesheet" href="css/lightbox.css">
    <link rel="stylesheet" type="text/css" href="css/base.css"/>
    <link rel="stylesheet" type="text/css" href="css/buju.css"/>


    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/jquery-1.11.0.min.js"></script>
    <script src="js/lightbox.min.js"></script>
    <script src="js/texiao.js"></script>

</head>
<body onload="deng()">
<div>

  <div style="width:100%" id="deng">
      <div style="width:100%;height:120px;border: 0px solid red;">
          <p style="text-align: center"><img style="width: 100px;height: 100px;border-radius:50%;margin-left: 10%;" title="<s:property value="#session.user.username"/>" class="Avatar" src="http://q.qlogo.cn/headimg_dl?bs=qq&dst_uin=<s:property value="#session.user.email" />&src_uin=qq.zy7.com&fid=blog&spec=640" /><s:property value="#session.user.username" />的收藏夹</p>
      </div>
                  <div class="bigbig">
                        <div class="big" style="margin-left:4%;">
                       <input type="hidden" id="user_id" value="${user.id}"/>
                            <s:iterator value="#session.pc4">
                                <div class="a">
                                        <%--显示图片--%>
                                    <img src='/userimg/<s:property value="url"/>' style="width:100%;"/>

                                        <%--设置灯箱--%>
                                        <div class="b">
                                            <div class="my_like_div" title="点击爱心收藏">
                                                <img class="my_like_img" title="添加收藏"  src="img/nolike.png" id="my_like" name='<s:property value="id"/>' />
                                                <span class="my_like_div_nobr"><s:property value="CollectionNumber"/></span>
                                            </div>
                                            <div class="my_like_div2"  title="下载此图片">
                                                <img class="my_like_img2"  src="img/downloadimg.png" />
                                                <span>下载图片</span>
                                            </div>
                                            <a class="example-image-link" href="/userimg/<s:property value="url"/>" data-lightbox="example-set" data-title="<s:property value='picturename' />">
                                                <div class="lookimg">
                                                    <span>查看图片</span>
                                                </div>
                                            </a>
                                                <%--上传者头像--%>
                                            <img class="up_userimg" src="http://q.qlogo.cn/headimg_dl?bs=qq&dst_uin=<s:property value="user.email" />&src_uin=qq.zy7.com&fid=blog&spec=640" />
                                                <%--上传者输出--%>
                                            <div class="up_username">上传者:<s:property value="user.username" /></div>
                                                <%--图片标题--%>
                                            <div class="up_biaoti">标题:<s:property value="picturename" />(<s:property value="size"/> ) </div>
                                        </div>
                                        <%--灯箱结束--%>
                                </div>
                            </s:iterator>
                        </div>
                        <div class="big">
                            <s:iterator value="#session.pc5">
                                <div class="a">
                                        <%--显示图片--%>
                                    <img src='/userimg/<s:property value="url"/>' style="width:100%;"/>

                                        <%--设置灯箱--%>
                                        <div class="b">
                                            <div class="my_like_div" title="点击爱心收藏">
                                                <img class="my_like_img" title="添加收藏"  src="img/nolike.png" id="my_like" name='<s:property value="id"/>' />
                                                <span class="my_like_div_nobr"><s:property value="CollectionNumber"/></span>
                                            </div>
                                            <div class="my_like_div2"  title="下载此图片">
                                                <img class="my_like_img2"  src="img/downloadimg.png" />
                                                <span>下载图片</span>
                                            </div>
                                            <a class="example-image-link" href="/userimg/<s:property value="url"/>" data-lightbox="example-set" data-title="<s:property value='picturename' />">
                                                <div class="lookimg">
                                                    <span>查看图片</span>
                                                </div>
                                            </a>
                                                <%--上传者头像--%>
                                            <img class="up_userimg" src="http://q.qlogo.cn/headimg_dl?bs=qq&dst_uin=<s:property value="user.email" />&src_uin=qq.zy7.com&fid=blog&spec=640" />
                                                <%--上传者输出--%>
                                            <div class="up_username">上传者:<s:property value="user.username" /></div>
                                                <%--图片标题--%>
                                            <div class="up_biaoti">标题:<s:property value="picturename" />(<s:property value="size"/> ) </div>
                                        </div>
                                        <%--灯箱结束--%>
                                </div>
                            </s:iterator>
                        </div>
                        <div class="big">
                            <s:iterator value="#session.pc6">
                                <div class="a">
                                        <%--显示图片--%>
                                    <img src='/userimg/<s:property value="url"/>' style="width:100%;"/>

                                        <%--设置灯箱--%>
                                        <div class="b">
                                            <div class="my_like_div" title="点击爱心收藏">
                                                <img class="my_like_img" title="添加收藏"  src="img/nolike.png" id="my_like" name='<s:property value="id"/>' />
                                                <span class="my_like_div_nobr"><s:property value="CollectionNumber"/></span>
                                            </div>
                                            <div class="my_like_div2"  title="下载此图片">
                                                <img class="my_like_img2"  src="img/downloadimg.png" />
                                                <span>下载图片</span>
                                            </div>
                                            <a class="example-image-link" href="/userimg/<s:property value="url"/>" data-lightbox="example-set" data-title="<s:property value='picturename' />">
                                                <div class="lookimg">
                                                    <span>查看图片</span>
                                                </div>
                                            </a>
                                                <%--上传者头像--%>
                                            <img class="up_userimg" src="http://q.qlogo.cn/headimg_dl?bs=qq&dst_uin=<s:property value="user.email" />&src_uin=qq.zy7.com&fid=blog&spec=640" />
                                                <%--上传者输出--%>
                                            <div class="up_username">上传者:<s:property value="user.username" /></div>
                                                <%--图片标题--%>
                                            <div class="up_biaoti">标题:<s:property value="picturename" />(<s:property value="size"/> ) </div>
                                        </div>
                                        <%--灯箱结束--%>
                                </div>
                            </s:iterator>
                        </div>
                    </div>				
				 <div style="float:left;width:45%;margin:50px 0px 50px 30%;">
                    	<s:set name="page" value="#session.page" />
    				<b>当前页为第<s:property value="#page.pageNow" />页 共<s:property value="#page.TotalPage"/>页</b>
    				<s:if test="#page.hasFirst">
    					<a href="User_ckshoucang?pageNow=1"><input type="button" value="首页" class="fenye"/></a>
    				</s:if>
    				<s:if test="#page.hasPre">
    					<a href="User_ckshoucang?pageNow=<s:property value="#page.pageNow-1" />"><input type="button" value="上一页" class="fenye"/></a>
    				</s:if>
    				<s:if test="#page.hasNext">
    					<a href="User_ckshoucang?pageNow=<s:property value="#page.pageNow+1" />"><input type="button" value="下一页" class="fenye"/></a>
    				</s:if>
    				<s:if test="#page.hasLast">
    					<a href="User_ckshoucang?pageNow=<s:property value="#page.totalPage" />"><input type="button" value="尾页" class="fenye"/></a>
    				</s:if>
    				<input type="text" id="tiao" class="fenye"/><input type="button" value="跳转" class="fenye" id="fenye"/>
                 </div >
       </div>          
</div>			
</body>
<style>
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
<script>
    $(function(){
    	$("#fenye").click(function(){
    		var pageNow = $("#tiao").val().trim();
    	    location.href="User_ckshoucang?pageNow="+pageNow;
    	});
    });
    function deng(){
  		 if(<%=session.getAttribute("totalSize") %>==0){
  		 	document.getElementById("deng").innerHTML="<div style='margin-left:45%;margin-top:15%'><h1><b>暂无收藏</b></h1></br>(快去收藏吧(*^_^*))</div>";
  		 }
  		}
</script >
</html>
