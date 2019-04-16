<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fenye.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/paging.css">
    <link rel="stylesheet" href="http://www.17sucai.com/preview/81082/2019-02-09/%E9%80%9A%E7%94%A8%E7%9A%84%E7%BD%91%E7%AB%99%E7%AE%A1%E7%90%86%E5%90%8E%E5%8F%B0%E6%A8%A1%E6%9D%BF/css/amazeui.min.css" />
	<link rel="stylesheet" href="http://www.17sucai.com/preview/81082/2019-02-09/%E9%80%9A%E7%94%A8%E7%9A%84%E7%BD%91%E7%AB%99%E7%AE%A1%E7%90%86%E5%90%8E%E5%8F%B0%E6%A8%A1%E6%9D%BF/css/admin.css" />
	
	    <script src="js/chartist.min.js"></script>
        <script src="js/material-dashboard.js"></script>
        <script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/material.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="myplugs/js/plugs.js"></script>
        
        <script type="text/javascript">
			//添加编辑弹出层
			function addType(title, id) {
				$.jq_Panel({
					title: title,
					iframeWidth: 400,
					iframeHeight: 100,
					url: "addType.jsp"
				});
			}
			
			//删除提示框
			function del() {
	            if(confirm("确实要删除吗？")){
	                return ture;
	            }else {
	                return false;
	             }
	        }
			
		</script>
 </head>
<body>   
           <s:action name="chaAllType" namespace="/admin"></s:action>
           <div class="admin-content-body">
		    <div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">类型管理</strong><small></small></div>
			</div><hr>
			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-6">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<a href="javascript:void(0)" onclick="addType('添加图片类型',5)">添加类型</a>
						</div>
					</div>
				</div>
				<div class="am-u-sm-12 am-u-md-3"></div>
			</div>
			
			<div class="am-g">
				<div class="am-u-sm-12">
					<form class="am-form">
						<table class="am-table am-table-striped am-table-hover table-main">
							<thead>
								<tr>
									<th class="table-check"><input type="checkbox"></th>
									<th class="table-id">ID</th>
									<th class="table-title">图片类型</th>
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
										<a href="user.html#"><s:property value="picturetype"/></a>
									</td>
									<td>
										<div class="am-btn-toolbar">
											<div class="am-btn-group am-btn-group-xs">
												<%--<button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span><a href="/admin/findById?id=<s:property value="id"/>">修改</a></button>--%>
												<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span><a href="/admin/delete?id=<s:property value="id"/>" onclick="return del();">删除</a></button>
											</div>
										</div>
									</td>
								</tr>
							    </s:iterator>
							</tbody>
						</table>
						
						<s:set name="page" value="#request.page"></s:set>
						<div class="am-cf" >
							共 <s:property value="#page.totalSize"/> 条记录,
							共<s:property value="#page.totalPage"/>页，
							当前第 <s:property value="#page.pageNow"/>页
							<div class="am-fr">
								<ul class="am-pagination">
								    <li>
								        <s:if test="#page.hasFirst">
										<a href="/admin/chaAllType?pageNow=1" target="right" id="next">首页</a>
										</s:if>
									</li>
									<li>
									    <s:if test="#page.hasPre">
										<a href="/admin/chaAllType?pageNow=<s:property value="#page.pageNow-1"/>" target="right">上一页</a>
										</s:if>
									</li>
								
									<li>
									    <s:if test="#page.hasNext">
										<a href="/admin/chaAllType?pageNow=<s:property value="#page.pageNow+1" />" target="right" id="next">下一页</a>
									    </s:if>
									</li>
									<li>
									    <s:if test="#page.hasLast">
										<a href="/admin/chaAllType?pageNow=<s:property value="#page.totalPage" />" target="right" id="next">尾页</a>
									    </s:if>
									</li>
								 
									<form method="post" action="/admin/chaAllType">
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
