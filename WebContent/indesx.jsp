<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/screen.css">
    <link rel="stylesheet" href="css/lightbox.css">
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
    <script src="js/lightbox.min.js"></script>
    <script src="js/texiao.js"></script>
    <script src="js/wow.min_1.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/page.js"></script>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <base target="_blank">


<style>

	.fenye{
		width:90px;
		height:34px;
		line-height: 34px;
		margin-right: 6px;
		padding: 0 15px;
		border: 1px solid #e1e2e3;
		background: #fff;
		border-radius:5px;
	}
	.fenye:hover{
		border: 1px solid #2828FF;
		background: #ECF5FF;
	}
	.guanzhu{
		width:80px;
		height:30px;
		border-radius: 4px;
		position: relative;
    	left: 60%;
    	cursor:pointer;
	}
</style>
<script>
    $(function(){
    	$("#fenye").click(function(){
    		var pageNow = $("#tiao").val().trim();
    		alert(pageNow);
    	    location.href="User_findPicture?pageNow="+pageNow;
    	});
    	$(".fenye").click(function(){
    		var type_id = $(this).attr("type_id");
    		var pageNow = $(this).attr("pageNow");
    		var param={
       			 pageNow : pageNow,
       			 type_id: type_id
                }
    		$.ajax({
                url:"User_findPicture",
                type:"post",
                data:param,
                datatype:"json",
                success:function (data,textStatus) {
                	window.location.reload();
                }
            });
    	});
    	$(".my_like_div3").click(function(){
    		var user_id = $("#user_id").val();
    		var b = $(this);
    		if(user_id == null || user_id == ""){
    			alert("登陆后可关注噢!(ง •_•)ง");
    			return false;
    		}else{
    			var fromuser_id = $(this).attr("name");
    			var param={
    					fromuser_id : fromuser_id
    	                }
    	    		$.ajax({
    	                url:"User_attention",
    	                type:"post",
    	                data:param,
    	                datatype:"json",
    	                success:function (data,textStatus) {
    	                	var a = data.result;
    	                	if(a == 1){
    	                		alert("关注成功！");
    	                	}else if(a == 2){
    	                		alert("取消关注成功");
    	                	}else{
    	                		alert("请先登陆！");
    	                	}
    	                	//window.location.reload();
    	                }
    	            });
    		}
    	});
    	
    	$("a" ).attr("target" , "_parent" );
    	 
/*     	 $(window.parent).scroll(function() {
             if($(window.parent).scrollTop()>=($(window).height()-50)){
            	 var pageNow = $("#more").find("img").attr("name");
            	 var type_id = $("#more").find("img").attr("typeid");
            	 var pageSize = $("#more").find("img").attr("pageSize");
            	 if(type_id==0){
            		 var param={
                			 pageNow : pageNow,
                			 type_id: type_id,
                			 pageSize: pageSize
                         }
                         $.ajax({
                             url:"User_findPicture",
                             type:"post",
                             data:param,
                             datatype:"json",
                             success:function (data,textStatus) {
                                 $("iframe[name='text']").attr("src","indesx.jsp");
                             }
                         });
            	 }
             }else{
                
             }
         }); */
    });
</script >
</head>


<body style="background-color: #253242" name="body">
		 <div class="platform_advantage" style="background:#253242;">
                    <div class="bigbig">
                        <div class="big" style="margin-left:4%;">
                       <input type="hidden" id="user_id" value="${user.id}"/>
                            <s:iterator value="#session.pc1" >
               
                                <div class="a">
                                    <img src='/userimg/<s:property value="url"/>' style="width:100%;"/>

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
                                        /*<div class="my_like_div3" id="my_like"  name="<s:property value="user.id"/>" title="关注">
                                             <img title="添加关注" src="img/guanzhu.jpg" class="guanzhu">
                                        </div>*/
                                        </a>
                                        <img class="up_userimg" src="http://q.qlogo.cn/headimg_dl?bs=qq&dst_uin=<s:property value="user.email" />&src_uin=qq.zy7.com&fid=blog&spec=640" />
                                        <div class="up_biaoti">标题:<s:property value="picturename" />(<s:property value="size"/> ) </div>
                                        <div class="up_username">上传者:<s:property value="user.username" /></div>
                                    </div>

                                </div>   
                            </s:iterator>
                        </div>
                        <div class="big">
                            <s:iterator value="#session.pc2">
                                <div class="a">
                                    <img src='/userimg/<s:property value="url"/>' style="width:100%;"/>
                                    <div class="b">
                                        <div class="my_like_div" title="点击爱心收藏">
                                            <img class="my_like_img" title="添加收藏"  src="img/nolike.png" id="my_like" name='<s:property value="id"/>' />
                                            <span class="my_like_div_nobr"><s:property value="CollectionNumber" /></span>

                                        </div>
                                        <div class="my_like_div2"  title="下载此图片">
                                            <img class="my_like_img2"  src="img/downloadimg.png"  />
                                            <span>下载图片</span>
                                        </div>

                                        <a class="example-image-link" href="/userimg/<s:property value="url"/>" data-lightbox="example-set" data-title="<s:property value='picturename' />">
                                            <div class="lookimg">
                                                <span>查看图片</span>
                                            </div>
                                        </a>
                                        <img class="up_userimg" src="http://q.qlogo.cn/headimg_dl?bs=qq&dst_uin=<s:property value="user.email" />&src_uin=qq.zy7.com&fid=blog&spec=640" />
                                        <div class="up_biaoti">标题:<s:property value="picturename" />(<s:property value="size"/> ) </div>
                                        <div class="up_username">上传者:<s:property value="user.username" /></div>

                                    </div>
                                </div>
                            </s:iterator>
                        </div>
                        <div class="big">
                            <s:iterator value="#session.pc3">


                                <div class="a">
                                    <img src='/userimg/<s:property value="url"/>' style="width:100%;"/>
                                    <div class="b">
                                        <div class="my_like_div" title="点击爱心收藏">
                                            <img class="my_like_img" title="添加收藏"  src="img/nolike.png" id="my_like" name='<s:property value="id"/>' />
                                            <span class="my_like_div_nobr"><s:property value="CollectionNumber" /> </span>
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

                                        <img class="up_userimg" src="http://q.qlogo.cn/headimg_dl?bs=qq&dst_uin=<s:property value="user.email" />&src_uin=qq.zy7.com&fid=blog&spec=640" />
                                        <div class="up_biaoti">标题:<s:property value="picturename" />(<s:property value="size"/> ) </div>
                                        <div class="up_username">上传者:<s:property value="user.username" /></div>

                                    </div>
                                </div>
                            </s:iterator>
                        </div>
                    </div>

                   <s:set name="page" value="#session.page" />
                  	<s:if test="#page.hasmore">
                    <div id="more" style="float:left;width:45%;margin:50px 0px 50px 35%;color:#fff;">	
    				<b>当前页为第<s:property value="#page.pageNow" />页 共<s:property value="#page.TotalPage"/>页</b>
    				<s:if test="#page.hasFirst">
    					<input type="button" value="首页" type_id="<s:property value="#session.type_id" />" pageNow="<s:property value="#page.pageNow=1" />" class="fenye"/>
    				</s:if>
    				<s:if test="#page.hasPre">
    					<input type="button" value="上一页" type_id="<s:property value="#session.type_id" />" pageNow="<s:property value="#page.pageNow-1" />" class="fenye"/>
    				</s:if>
    				<s:if test="#page.hasNext">
    					<input type="button" value="下一页" type_id="<s:property value="#session.type_id" />" pageNow="<s:property value="#page.pageNow+1" />" class="fenye"/>
    				</s:if>
    				<s:if test="#page.hasLast">
    					<input type="button" value="尾页" type_id="<s:property value="#session.type_id" />" pageNow="<s:property value="#page.totalPage" />" class="fenye"/>
    				</s:if>
    				<input type="text" id="tiao" class="fenye"/><input type="button" value="跳转" class="fenye" id="fenye"/>
                 </div >
                 </s:if>
                 <s:else>
                 	<div id="more" style="float:left;width:45%;margin:100px 0px 50px 48%;color:#fff;">
                 		<%-- <a href="User_findPicture?pageNow=<s:property value="#page.pageNow+1" />"><input type="button" value="更多" class="fenye" style="margin:50px 0px 50px 35%;"/></a> --%>
                 		 <img src="images/loading.gif" typeid="0" pageSize="<s:property value="#page.pageSize+10" />" name="<s:property value="#page.pageNow+1" />" />
                 	</div>
                 </s:else>
             </div>
</body>
</html>
