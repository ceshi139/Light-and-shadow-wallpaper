<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>修改</title>
    <link rel="stylesheet" type="text/css" href="css/layui_2.css"/>

    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js" type="text/javascript" ></script>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".mima").hide();
            $(".xiugaiziliao").css({"color":"#3ec8f7","font-size":"17px"});
            $(".xiugaimima").click(function(){
                $(".xinxi").toggle();
                $(".mima").toggle();
                $(this).css({"color":"#3ec8f7","font-size":"17px"});
                $(".xiugaiziliao").css({"color":"#000000","font-size":"14px"});
            });
            $(".xiugaiziliao").click(function(){
                $(".xinxi").toggle();
                $(".mima").toggle();
                $(this).css({"color":"#3ec8f7","font-size":"17px"});
                $(".xiugaimima").css({"color":"#000000","font-size":"14px"});
            });

            $("input[type=text],input[type=password],textarea[name=desc]").focusin(function(){
                    $(this).css({"outline":"1px solid #3ec8f7"})
            });
            $("input[type=text],input[type=password],textarea[name=desc]").focusout(function(){
                $(this).css({"outline":""});
            });
            
            $("#update").click(function(){
            	var id = $("input['name=id']").val();
            	alert(id);
            });
        });
    </script>
</head>
<body>
<div class="layui-tab page-content-wrap">
    <ul class="layui-tab-title">
        <li class="xiugaiziliao">修改资料</li>
        <li class="xiugaimima">修改密码</li>
    </ul>
    <div class="">
        <div class="xinxi">
            <form action="User_user_update" method="get" class="layui-form"  style="width: 90%;padding-top: 20px;">
                <div class="layui-form-item">
                    <label class="layui-form-label">ID：</label>
                    <div class="layui-input-block">
                        <input type="text" name="user.id" readonly="readonly" class="layui-input" value='<s:property value="#session.user.id" />'>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">邮箱：</label>
                    <div class="layui-input-block">
                        <input type="email" name="user.email" readonly="readonly" class="layui-input" value="${user.email}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">余额：</label>
                    <div class="layui-input-block">
                        <input type="text" name="user.moneyover" readonly="readonly" class="layui-input" value="${user.moneyover}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名：</label>
                    <div class="layui-input-block">
                        <input type="text" name="user.username" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input" value="${user.username}">
                        <input type="hidden" name="user.password" value="${user.password}" />
                        <span><s:property value="#session.ck_username" /></span>
                    </div>
                </div>
                <div class="layui-form-item">
                  <label class="layui-form-label">年龄：</label>
                  <div class="layui-input-block">
                   <input type="test" name="user.age" placeholder="请输入年龄" class="layui-input" value="${user.age}"/>
                  </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">个性签名：</label>
                    <div class="layui-input-block">
                        <textarea name="user.gexing" placeholder="请输入内容" class="layui-textarea">${user.gexing}</textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn layui-btn-normal" lay-submit lay-filter="adminInfo">立即提交</button>
                    </div>
                </div>
            </form>
        </div>

        <div class="mima">
            <form class="layui-form" style="width: 90%;padding-top: 20px;">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名：</label>
                    <div class="layui-input-block">
                        <input type="text" name="username" disabled autocomplete="off" class="layui-input layui-disabled" value="${user.username}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">旧密码：</label>
                    <div class="layui-input-block">
                        <input type="password" name="password1" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" >
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">新密码：</label>
                    <div class="layui-input-block">
                        <input type="password" name="password2" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">重复密码：</label>
                    <div class="layui-input-block">
                        <input type="password" name="password3" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn layui-btn-normal"  lay-filter="adminPassword" id="update">立即提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>