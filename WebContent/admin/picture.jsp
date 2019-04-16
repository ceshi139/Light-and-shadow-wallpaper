<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
String basePath1 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <base href="<%=basePath1%>">
     <base src="<%=basePath%>">
    
    <title>My JSP 'picture.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
        <meta charset="UTF-8">
		<title></title>
		
		<link rel="stylesheet" href="http://www.17sucai.com/preview/81082/2019-02-09/%E9%80%9A%E7%94%A8%E7%9A%84%E7%BD%91%E7%AB%99%E7%AE%A1%E7%90%86%E5%90%8E%E5%8F%B0%E6%A8%A1%E6%9D%BF/css/amazeui.min.css" />
		<link rel="stylesheet" href="http://www.17sucai.com/preview/81082/2019-02-09/%E9%80%9A%E7%94%A8%E7%9A%84%E7%BD%91%E7%AB%99%E7%AE%A1%E7%90%86%E5%90%8E%E5%8F%B0%E6%A8%A1%E6%9D%BF/css/admin.css" />
        <script src="js/chartist.min.js"></script>
        <script src="js/material-dashboard.js"></script>
        <script src="js/jquery-3.1.0.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/material.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="myplugs/js/plugs.js"></script>
        
        <script type="text/javascript">
			//添加编辑弹出层
			function upload(title, id) {
				$.jq_Panel({
					title: title,
					iframeWidth: 400,
					iframeHeight: 200,
					url: "upload.jsp"
				});
			}
			
			function update(title) {
				$.jq_Panel({
					title: title,
					iframeWidth: 500,
					iframeHeight: 300,
					url: "updatePicture.jsp"
				});
				
			}

             function del() {
                 if(confirm("确实要删除吗？")){
                    return ture;
                 }else {
                    return false;
                 }
             }
			$(function () {

					$("select[name='imgsize'] option").hover(function () {
							$(this).attr("background-color","red");
					});

			});

		</script>
	  	<style type="text/css">
			.imgselect{
				height: 34px;
			}
		</style>
  </head>
  <body >
  <s:action name="chaAllPicture" namespace="/admin"></s:action>

      <div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户管理</strong><small></small></div>
			</div>

			<hr>

			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-6">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<a href="javascript:void(0)" onclick="upload('上传图片',5)">上传图片</a>
						</div>
					</div>
				</div>
				<div class="am-u-sm-12 am-u-md-3">

				</div>
				<div >
					<div style="margin-left:50%;">
					  <form method="post" action="/admin/chaAllPicture">
						  <select class="imgselect" name="imgsize">
							  <option value="">按尺寸</option>
							  <option value="1920*1200">1920*1200</option>
							  <option value="1920*1080">1920*1080</option>
							  <option value="1280*720">1280*720</option>
							  <option value="1536*864">1536*864</option>
							  <option value="1680*1050">1680*1050</option>
						  </select>
						  <select class="imgselect" name="imgtype">
							  <option value="">按类型</option>
							  <s:iterator value="#session.lstype">
									  <option value="<s:property value="id"/>"><s:property value="picturetype"/></option>
							  </s:iterator>
						  </select>
						  <select class="imgselect" name="paixu">
							  <option value=>排序方式</option>
							  <option value="shijian">按时间</option>
							  <option value="redu">按热度</option>
						  </select>
						<input type="text" name="imgname" placeholder="图片标题" style="width:200px;height:35px;color:#333333;"/>

                        <input type="submit" value="查询" id="sech" style="width:60px;height:35px;"/>
			          </form>
					</div>
				</div>
			</div>
			
			<div class="am-g">
				<div class="am-u-sm-12">
					<form class="am-form">
						<table class="am-table am-table-striped am-table-hover table-main">
							<thead>
								<tr>
									<th class="table-check"><input type="checkbox"></th>
									<th>ID</th>
									<th >图片</th>
									<th>图片标题</th>
									<th >图片尺寸</th>
									<th>类型</th>
									<th>上传时间</th>
									<th>上传者</th>
									<th>格式</th>
									<th>收藏数</th>
									<th class="table-set">操作</th>
								</tr>
							</thead>
							
							<s:property value="#error"/>
							<tbody>
								 <s:iterator value="#session.list">
								<tr>
									<td><input type="checkbox"></td>
									<td><s:property value="id" /></td>
									<td>
										<img src='/userimg/<s:property value="url"/>' style="width:60px;height:60px;"/>
									</td>
									<td style="color:#095f8a;"><s:property value="picturename"/></td>
									<td style="color:#095f8a;"><s:property value="size"/></td>
									<td style="color:#095f8a;"><s:property value="type.picturetype"/></td>
									<td style="color:#095f8a;"><s:property value="time"/></td>
									<td style="color:#095f8a;"><s:property value="user.username"/></td>
									<td style="color:#095f8a;"><s:property value="format"/></td>
									<td style="color:#095f8a;"><s:property value="CollectionNumber"/></td>
									<td>
										<div class="am-btn-toolbar">
											<div class="am-btn-group am-btn-group-xs">
												<button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span><a href="/admin/findByIdPicture?id=<s:property value="id"/> ">修改</a></button>
												<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span><a href="/admin/de?id=<s:property value="id"/>" onclick="return del();">删除</a></button>
											</div>
										</div>
									</td>
								</tr>
							</s:iterator>
							</tbody>
						</table>
						
						<s:set name="page" value="#request.page"></s:set>
						<div class="am-cf">
							共 <s:property value="#page.totalSize"/> 条记录<s:property value="imgname"/> <s:property value="paixu"/> ，
							共<s:property value="#page.totalPage"/>页，
							当前第 <s:property value="#page.pageNow"/>页
							<div class="am-fr">
								<ul class="am-pagination">
								    <li>
								        <s:if test="#page.hasFirst">
										<a href="/admin/chaAllPicture?pageNow=1&imgname=<s:property value="imgname"/>&imgsize=<s:property value="imgsize"/>&imgtype=<s:property value="imgtype"/>&paixu=<s:property value='paixu'/> " target="right" id="next">首页</a>
										</s:if>
									</li>
									<li>
									    <s:if test="#page.hasPre">
										<a href="/admin/chaAllPicture?pageNow=<s:property value="#page.pageNow-1"/>&imgname=<s:property value="imgname"/>&imgsize=<s:property value="imgsize"/>&imgtype=<s:property value="imgtype"/>&paixu=<s:property value='paixu'/> " target="right">上一页</a>
									    </s:if>
									</li>
								
									<li>
									    <s:if test="#page.hasNext">
										<a href="/admin/chaAllPicture?pageNow=<s:property value="#page.pageNow+1" />&imgname=<s:property value="imgname"/>&imgsize=<s:property value="imgsize"/>&imgtype=<s:property value="imgtype"/>&paixu=<s:property value='paixu'/> " target="right" id="next">下一页</a>
									    </s:if>
									</li>
									<li>
									     <s:if test="#page.hasLast">
										<a href="/admin/chaAllPicture?pageNow=<s:property value="#page.totalPage" />&imgname=<s:property value="imgname"/>&imgsize=<s:property value="imgsize"/>&imgtype=<s:property value="imgtype"/>&paixu=<s:property value="paidxu"/> " target="right" id="next">尾页</a>
									     </s:if>
									</li>
								 
									<form method="post" action="/admin/chaAllPicture?imgname=<s:property value="imgname"/>&imgsize=<s:property value="imgsize"/>&imgtype=<s:property value="imgtype"/>&paixu=<s:property value="paidxu"/>">
									  <li>									  
									    <input type="text" name="num" style="width:60px;height:35px;"/>									    
									  </li>
									  <li>
									     <input type="submit"  value="跳转" style="width:60px; height:30px; margin-top:1px;background-color:#fff; border:1px solid #ddd;"/>
									  </li>
							     	</form>
								   </ul>
							</div>
						</div>
						<hr>
					</form>
				</div>
			</div>
		</div>
  </body>
</html>
