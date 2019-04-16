<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=yes">
    <meta http-equiv="Cache-Control" content="no-transform"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>光影壁纸</title>
    <meta name="renderer" content="webkit">
    <!--ico-->
    <link rel="shortcut icon" href="../images/favicon1.ico">
    <link rel="stylesheet" type="text/css" href="css/base.css"/>
    <link rel="stylesheet" type="text/css" href="css/buju.css"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="css/animate.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/owl.carousel.css"/>
    <link type="text/css" href="css/button.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="css/responsive.css"/>
    <link rel="stylesheet" type="text/css" href="css/daohang_style.css"/>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/wow.min_1.js"></script>
    <script src="js/page.js"></script>
    <script src="js/texiao.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery-nav.js" ></script>

    <base target="_blank">
    <script type="text/javascript">
            $(function () {
            	 
                //获取窗口可视范围的高度
                function getClientHeight(){
                    var clientHeight=0;
                    if(document.body.clientHeight&&document.documentElement.clientHeight){
                        var clientHeight=(document.body.clientHeight<document.documentElement.clientHeight)?document.body.clientHeight:document.documentElement.clientHeight;
                    }else{
                        var clientHeight=(document.body.clientHeight>document.documentElement.clientHeight)?document.body.clientHeight:document.documentElement.clientHeight;
                    }
                    return clientHeight;
                }
                //窗口滚动条所在位置
                function getScrollTop(){
                    var scrollTop=0;
                    if(document.documentElement&&document.documentElement.scrollTop){
                        scrollTop=document.documentElement.scrollTop;
                    }else if(document.body){
                        scrollTop=document.body.scrollTop;
                    }
                    return scrollTop;
                }

                function getScrollHeight(){
                    return Math.max(document.body.scrollHeight,document.documentElement.scrollHeight);
                }
                function getziyemian(){
                    return document.getElementById("iframe_index").contentDocument.body.scrollHeight;
                }

                //距离底部距离
                function getbottom(){
                    return getScrollHeight()-getScrollTop()-getClientHeight();
                }



            $("#gototop").hide();

                /*去顶部点击触发事件*/
            $("#gototop").click(function () {
                $("body,html").animate({scrollTop:0},1500);
            });

            /*监听滚动条高度*/
            $(window).scroll(function() {
                /*距离底部距离=文档内容实际高度-窗口滚动条高度-窗口可视化高度*/
                var gobottom=getScrollHeight()-getScrollTop()-getClientHeight();
                if($(this).scrollTop()<570){
                    $("#gototop").hide();
                }else if(gobottom<328){

                    /*到达底部进行逐渐增加到底部的距离//防止遮挡底部*/
                    var a=378-gobottom;
                    $("#gototop").css({"bottom":a});
                }else{
                    $("#gototop").css({"bottom":"50px"});
                    $("#gototop").show();
                }
            });
            $(window).scroll(function() {
                if($(this).scrollTop()>460){
                    $("#biaoqian").css({"position":"fixed","left":"0px","top":"80px","z-index":"10"});
                }else{
                    $("#biaoqian").css({"position":"","left":"0px","top":"","z-index":""});
                }

            });

            $(".f-nav li").click(function ck() {

                /*//初始化iframe高度*/
                $("#iframe_index").attr({"height":0});
                var thisid=$(this).attr("name");
                var param={
                    type_id : thisid,
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
            });
            
			function more(){
					var aa=$("#iframe_index").contents().find("#more img");
	                var pageNow =aa.attr("name");
	                var type_id = aa.attr("typeid");
	                var pageSize = aa.attr("pageSize");
	                /*alert(pageNow+"type_id"+type_id+"pagesize"+pageSize);*/
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
                
			}
            $(window).scroll(function () {
                    /*var iframe=$("#iframe_index");*/
                    /*var document=iframe.contentWindow.document;*/
                    if(getbottom()<350&&getbottom()>300){
						more();
                    }else{

                    }
                });
            $(window).unload(function(){
            	var thisid= 0;
                var param={
                    type_id : thisid,
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
              });

                $(".iframe_c").load(function() {
                    var a=getziyemian();
                    $("#iframe_index").attr({"height":a});
                    /*var iframeHeight = $(this).contents().find("body[name='body']").height();
                    $(this).height(iframeHeight < 500 ? 500 : iframeHeight+50);*/
                });


                $("#soso").click(function () {		//搜索
                	 var aa = $("#iframe_index").contents().find("#more");
                    var cha = $("input[name='cha']").val();
                    var type = $("#type").val();
                    var sech_type = $("#sech_type").val();
                    alert(type);
                    alert(sech_type);
                    var param={
                    	cha : cha,
                    	type: type,
                    	sech_type: sech_type
                    }
                    $.ajax({
                        url:"User_cha",
                        type:"post",
                        data:param,
                        datatype:"json",
                        success:function (data,textStatus) {
						   $("iframe[name='text']").attr("src","indesx.jsp"); 
						    if(<%=session.getAttribute("totalSize") %>==0){
							   alert("1");
							   var aa=$("#iframe_index").contents().find("#more");
		             		 	aa.html("<div id='no' style='margin-left:-12%;margin-top:-15%'><h1><b>暂无内容(ง •_•)ง</b></h1></div>");
		             		}else{
		             			alert("2");
		             			$("iframe[name='text']").attr("src","indesx.jsp"); 
		             		}
                        }
                    });
                   
                });
                $("#sech_type").mouseover(function(){
                	$("#type").slideDown("slow");
                });
            /*     $("#type").mouseout(function(){
                	$("#type").slideUp("slow");
                }); */

                $('#f-nav').tooltip({ 
               // default :b,     // 默认为空  --  选中默认值
                width: '100',     // 限制宽度
                height: '60',
                textList: ['1','2','3','4'],
                type: 'slideMove',  // 必填, 选择内容
                success: function(ret){
                	
                }   //初始化回调
          		});
                
            });
    </script>
</head>
<body>
 <s:if test="#session.types == null" >
     <s:action name="User_findPicture" namespace="/"></s:action>
 </s:if>
<%--//导航栏模块--%>
<div class="header">
    <div class="container">
        <div class="rowFluid">
            <div class="span3 col-md-12" >
                <div class="logo"><a href="index.jsp#" title="光影"> <img src="images/logo_me.png" style="width: 220px;height: 60px;" alt="光影"/></a></div>
            </div>
            <div class="span9">
                <div class="mobileMenuBtn"><span class="span1"></span><span class="span2"></span><span class="span3"></span></div>
                <div class="mobileMenuBtn_shad"></div>
                <div class="header_menu" style="margin-left:-100px">
                    <ul id="menu">
                    	<li> 
              				<select id="sech_type" class="button button-glow button-border button-rounded button-primary" style="height: 42px;border-radius: 4px;padding: 0px;">
              					<option value="1">全部类型</option>
              					<s:iterator value="#session.types">
              						<option value="<s:property value="id" />" ><s:property value="picturetype" /></option>
              					</s:iterator>
              				</select>
              				<select id="type" class="button button-glow button-border button-rounded button-primary" style="height: 42px;border-radius: 4px;padding: 0px;display:none;">       							
              					<option value="1">全部</option>
              					<option value="1">图片名</option>
              					<option value="2">尺寸</option>
              				</select>        					
              					<%-- <div id="type_a" value="1">全部</div>
              					<div id="type_b" style="display: none;" value="2">类型<s:iterator value="#session.types"><div style=""><s:property value="picturetype"/></div></s:iterator></div>
              					<div id="type_c" style="display: none;" value="3">尺寸</div>  --%>
          				</li>
          					
                        <li> <input name="cha" type="text" style="border: 0px solid yellow;border-radius:4px;width: 600px;height:40px;padding-left: 12px;"/></li>	<!-- 搜索 -->
                        <li><button id="soso" class="button button-glow button-border button-rounded button-primary" style="height: 42px;width: 80px;border-radius: 4px;padding: 0px;">搜索</button></li>
                        <s:if test="#session.user.username!=''">
                            <li><img title="<s:property value="#session.user.username"/>" class="Avatar" src="http://q.qlogo.cn/headimg_dl?bs=qq&dst_uin=<s:property value="#session.user.email" />&src_uin=qq.zy7.com&fid=blog&spec=640" /> </li>
                        </s:if>
                        <s:else>
                            <li><a href="login_regiest.jsp">登录/注册</a></li>
                        </s:else>

                        <div class="info">
                            <div>
                                <i class="fa fa-address-card-o" style="font-size:18px;color:#1E98F4;margin-right: 8px;"></i><a href="navigation.jsp">个人信息</a>
                            </div>
                            <hr>
                            <div>
                                <i class="fa fa-jsfiddle" style="font-size:18px;color:#1E98F4;margin-right: 8px;"></i> <a href="my_collection.jsp" target="text">我的收藏</a>

                            </div>
                            <hr>
                            <div>
                                <i class="fa fa-leanpub" style="font-size:18px;color:#1E98F4;margin-right: 8px;"></i><a href="my_collection.jsp" target="text">我的作品</a>
                            </div>
                            <hr>
                            <div>
                                <i class="fa fa-upload" style="font-size:18px;color:#1E98F4;margin-right: 8px;"></i><a href="upload_picture.jsp" target="_self">上传图片</a>
                            </div>
                            <hr>
                            <div>
                                <i class="fa fa-dollar" style="font-size:18px;color:#1E98F4;margin-right: 8px;"></i><a href="demo.jsp" target="_self">充值中心</a>
                            </div>
                            <hr>
                            <div>
                                <i class="fa fa-sign-out" style="font-size:18px;color:#1E98F4;margin-right: 8px;"></i><a target="_self" href="User_removeSession">退出登录</a>
                            </div>

                        </div>
                    </ul>
                </div>
            </div>
            <div class="span2"></div>
        </div>
    </div>
</div>

<div id="show" style="width: 400px;height: 30px;position: fixed;top: 300px;left: 20px;color: red;">测试滚动条</div>
<div id="test" style="width: 400px;height: 30px;position: fixed;top: 500px;left: 20px;color: red;">按钮</div>
<%--//头部模块--%>
<div class="page">
    <div class="rowFluid">
        <div class="span12">
            <div class="main">
                <script src="js/login.js"></script>
                <div class="banner">
                    <div class="rowFluid">
                        <div class="span12">
                            <div class="owl-demo  wow fadeInUp">
                                 <div class="item">
                                      <h3 class="banner_title">光影壁纸</h3>
                                     <hr style="width:40%;margin:0 auto;"/>
                                     <h2 style="color: #fff;">Light and shadow Wallpaper</h2>
                                      <div class="banner_jianjie">
                                         <%--<input type="text" />--%>
                                      </div>
                                  </div>
                            </div>

                            <ul class="platform_advantage_bg">
                                <%--方块特效--%>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                            </ul>
                        </div>
                    </div>
                    <div id="container" class="mpage">
                        <div id="anitOut" class="anitOut"></div>
                    </div>
                </div>
<%--//标签模块--%>
                <div id="biaoqian" class="kzf-mod-product,box" style="background-color: #1F2B39;width: 100%;">
                    <%--<s:iterator value="#session.types">
                        <input type="button" value="<s:property value="picturetype"/>" onclick="type2(<s:property value="id"/>)" />
                    </s:iterator>--%>
                        <ul class="f-nav" id='f-nav'>
                            <li style="margin-left: 200px;" title="首页" name="0">首页</li>
                                <s:iterator value="#session.types">
                                    <li title="<s:property value="picturetype" /> " name="<s:property value="id"/> "><s:property value="picturetype" /> </li>
                                </s:iterator>
                            <div class='sideline'></div>
                        </ul>
                </div>
<%--//内容模块--%>

                <%--<hr style="width: 80%;margin: 0 auto;">--%>
                <div id="index-iframe">
                <iframe id="iframe_index" frameborder="no" scrolling="no" class="iframe_c" src="indesx.jsp" name="text"  style="padding-top: 20px;width: 100%;background:#253242;">

   				</iframe>
   				</div>

<%--去顶部--%>
                <div id="gototop" style=""><img src="img/gotop.png" /> </div>



<%--//底部模块--%>

                <div class="footer ">
                    <div class="rowFluid">
                        <div class="span12">
                            <div class="container">
                                <div class="footer_content">
                                    <!--<div class="lianxi">全国分支机构</div>-->
                                    <div class="span4 col-xm-6 col-xs-12 text_align">
                                        <div class="footer_list">
                                            <div class="footer_cotact">
                                                <div class="footer_cotact_title text_align">光影壁纸</div>
                                                <ul>
                                                    <li class="span6"><a href="index.jsp">注册公司</a></li>
                                                    <li class="span6"><a href="index.jsp">代理记账</a></li>
                                                    <li class="span6"><a href="index.jsp">商标注册</a></li>
                                                    <li class="span6"><a href="index.jsp">公司变更</a></li>
                                                    <li class="span6"><a href="index.jsp">公司注销</a></li>
                                                    <li class="span6"><a href="index.jsp">常见问题</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="span4 col-xm-6 col-xs-12 text_align">
                                        <div class="footer_list">
                                            <div class="footer_cotact">
                                                <div class="footer_cotact_title text_align">光影财务（江西）</div>
                                                <ul>
                                                    <li><span
                                                            class="footer_cotact_content">地址：江西制造职业技术学院</span>
                                                    </li>
                                                    <li><span class="footer_cotact_content">电话：<a href="index.jsp#" class="call">400-8200-830</a></span>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="span4 col-xm-6 col-xs-12 text_align">
                                        <div class="footer_list">
                                            <div class="footer_cotact">
                                                <div class="footer_cotact_title"></div>
                                                <ul>
                                                    <li class="">
                                                        <img style="width: 140px;height:140px;" src="img/guangyingqq.jpg" alt=""/>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="copyright">光影壁纸版权所有 抄袭必究</div>
                            <div class="jiqiren">
                                <div class="copyright">友情链接：
                                    <span class="STYLE3">
                     <a href='https://codepay.fateqq.com/home.htm'>码支付</a>
                  </span>
                                    <span class="STYLE3">
                     <a href='https://unsplash.com/'>Unsplash</a>
                  </span>
                                    <span class="STYLE3">
                     <a href='http://logo.xwzn.cn/index/index?login=open'>LOGO设计</a>

                  </span>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>

<SCRIPT langauge="javasript">document.oncontextmenu = new Function('event.returnValue=false;');
document.onselectstart = new Function('event.returnValue=false;');</SCRIPT>

</body>
</html>
