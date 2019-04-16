<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

	<head>
		
		<meta charset="UTF-8">
		<title></title>
		<script src="../js/jquery-3.1.1.min.js" type="text/javascript"></script>
		<link rel="stylesheet" href="http://www.17sucai.com/preview/81082/2019-02-09/%E9%80%9A%E7%94%A8%E7%9A%84%E7%BD%91%E7%AB%99%E7%AE%A1%E7%90%86%E5%90%8E%E5%8F%B0%E6%A8%A1%E6%9D%BF/css/amazeui.min.css" />
		<link rel="stylesheet" href="http://www.17sucai.com/preview/81082/2019-02-09/%E9%80%9A%E7%94%A8%E7%9A%84%E7%BD%91%E7%AB%99%E7%AE%A1%E7%90%86%E5%90%8E%E5%8F%B0%E6%A8%A1%E6%9D%BF/css/admin.css" />
	
	    <script type="text/javascript">
	      $(function(){
	         $('#selectAll').click(function(){
	            $('input[type=checkbox]').attr('checked', $(this).attr('checked'));
	         });
	      });
	    </script>
	
	</head>

	<body>
	    <s:action name="chaAllUser" namespace="/admin"></s:action>
		<s:debug>

		</s:debug>
		<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户管理</strong><small></small></div>
			</div>

			<hr>

			<div class="am-g">
			
				<div class="am-u-sm-12 am-u-md-3">

				</div>
				<div >
					<div style="margin-left:70%;">
					  <form method="post" action="chaAllUser">	
						<input type="text" name="username" style="width:290px;height:35px;"/>
                        <input type="submit" value="查询" style="width:60px;height:35px;"/>
			          </form> 
					</div>
					     
					<!-- <div style="margin-left:2.5%;">					  
					     <form>
					         <input type="checkbox" id="selectAll"/>批量删除
					     </form>
					</div> -->
				</div>
			</div>
			
			<div class="am-g">
				<div class="am-u-sm-12">
					<form class="am-form" id="form">
						<table class="am-table am-table-striped am-table-hover table-main">
							<thead>
								<tr>
									<th class="table-check"><input type="checkbox" id="selectAll"/></th>
									<th class="table-id">ID</th>
									<th class="table-title">用户名</th>
									<th>账号</th>
									<th class="table-type">密码</th>
									<th>性别</th>
									<th class="table-author am-hide-sm-only">年龄</th>
									<th>状态</th>
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
										<a href="user.html#"><s:property value="username" /></a>
									</td>
									<td><s:property value="email"/></td>
									<td><s:property value="password"/></td>
									<td><s:property value="sex"/></td>
									<td class="am-hide-sm-only"><s:property value="age" /></td>
									<td>
										<s:if test="state==1">
											<div style="height:28px;width: 48px;background-color: #9c27b0;color:#fff;text-align: center;line-height: 28px;font-size: 10px;">已封禁</div>
										</s:if>
										<s:else>
											<div style="height:28px;width: 48px;background-color: #39b53b;color: #fff;text-align: center;line-height: 28px;font-size: 10px;">正常</div>
										</s:else>


									</td>
									<td>
										<div class="am-btn-toolbar">
											<div class="am-btn-group am-btn-group-xs">
												<button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> <a href="/admin/fengjin?id=<s:property value="id"/>">封禁</a></button>
												<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span><a href="/admin/jiefeng?id=<s:property value="id"/>">解封</a></button>
											</div>
										</div>
									</td>
								</tr>
							</s:iterator>
							</tbody>
						</table>

						<s:set name="page" value="#request.page"></s:set>
						<div class="am-cf">
							共 <s:property value="#page.totalSize"/> 条记录,
							共<s:property value="#page.totalPage"/>页，
							当前第 <s:property value="#page.pageNow"/>页
							<div class="am-fr">
								<ul class="am-pagination">
								    <li>
								        <s:if test="#page.hasFirst">
										<a href="chaAllUser?pageNow=1" target="right" id="next">首页</a>
										</s:if>
									</li>
									<li>
									     <s:if test="#page.hasPre">
										<a href="chaAllUser?pageNow=<s:property value="#page.pageNow-1"/>" target="right">上一页</a>
									    </s:if>
									</li>
								
									<li>
									    <s:if test="#page.hasNext">
										<a href="chaAllUser?pageNow=<s:property value="#page.pageNow+1" />" target="right" id="next">下一页</a>
									    </s:if>
									</li>
									<li>
									     <s:if test="#page.hasLast">
										<a href="chaAllUser?pageNow=<s:property value="#page.totalPage" />" target="right" id="next">尾页</a>
									     </s:if>
									</li>
								 
									<form method="post" action="chaAllUser">								
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
