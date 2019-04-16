
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html lang="en" xmlns="http://www.w3.org/1999/html">

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

 </head>
 
<body>
  
<form action="/admin/User_up" method="post" enctype = "multipart/form-data">
        选择图片：<input type="file" name="file" multiple="multiple" />
          <select name="uploadPicture.size">
              <option value="全部尺寸">全部尺寸</option>
              <option value="1920*1080" >1920*1080</option>
              <option value="1920*1200">1920*1200</option>
              <option value="1280*720">1280*720</option>
              <option value="1536*864">1536*864</option>
              <option value="1680*1050">1680*1050</option>
          </select>
          <input type="hidden" name="username" value="${user.username}" />
          <input type="hidden" name="uploadPicture.picturename" value="天真" />
          <input type="hidden" name="uploadPicture.type" value="4" />
          <input type="hidden" name="uploadPicture.userid" value="${user.id}" />
          <input type="submit" value="上传"/>
</form>
      
   </body>
   
  <%--  <style>

    .add_div {
        width: 300px;
        height: 400px;
        
        margin-top: 20px;
        margin-left: 100px;
        padding-left: 20px;
        font-size:12px;
    }

    .file-list {
        height: 125px;
        display: none;
        list-style-type: none;
    }

    .file-list img {
        max-width: 70px;
        vertical-align: middle;
    }

    .file-list .file-item {
        margin-bottom: 10px;
        float: left;
        margin-left: 20px;
    }


    .file-list .file-item .file-del {
        display: block;
        margin-left: 20px;
        margin-top: 5px;
        cursor: pointer;
    }


</style>
<body>
<div class="add_div">
    <p>
        <span>名称：</span>
        <input type="text" name="" id="name" value=""/>
    </p>
  
    <p>
        <span>图片：</span>
        <input type="file" name="" id="choose-file" multiple="multiple"/>
        <!--<input type="file" name="" id="choose-file" />-->
    </p>
    <p>
    <ul class="file-list ">

    </ul>
    </p>
    <button style="cursor: pointer;margin-left: 150px;" href="javascript:;" id="upload">上传</button>

</div>
<script src="js/jquery-3.1.1.min.js"></script>
<script>

    $(function () {
        //图片上传
        //声明变量
        var $button = $('#upload'),
            //选择文件按钮
            $file = $("#choose-file"),
            //回显的列表
            $list = $('.file-list'),
            //选择要上传的所有文件
            fileList = [];
        //当前选择上传的文件
        var curFile;
        // 选择按钮change事件，实例化fileReader,调它的readAsDataURL并把原生File对象传给它，
        // 监听它的onload事件，load完读取的结果就在它的result属性里了。它是一个base64格式的，可直接赋值给一个img的src.
        $file.on('change', function (e) {
            //上传过图片后再次上传时限值数量
            var numold = $('li').length;
            if(numold >= 6){
                layer.alert('最多上传6张图片');
                return;
            }
            //限制单次批量上传的数量
            var num = e.target.files.length;
            var numall = numold + num;
            if(num >6 ){
               layer.alert('最多上传6张图片');
               return;
            }else if(numall > 6){
                layer.alert('最多上传6张图片');
                return;
            }
            //原生的文件对象，相当于$file.get(0).files;//files[0]为第一张图片的信息;
            curFile = this.files;
            //curFile = $file.get(0).files;
            //console.log(curFile);
            //将FileList对象变成数组
            fileList = fileList.concat(Array.from(curFile));
            //console.log(fileList);
            for (var i = 0, len = curFile.length; i < len; i++) {
                reviewFile(curFile[i])
            }
            $('.file-list').fadeIn(2500);
        })


        function reviewFile(file) {
            //实例化fileReader,
            var fd = new FileReader();
            //获取当前选择文件的类型
            var fileType = file.type;
            //调它的readAsDataURL并把原生File对象传给它，
            fd.readAsDataURL(file);//base64
            //监听它的onload事件，load完读取的结果就在它的result属性里了
            fd.onload = function () {
                if (/^image\/[jpeg|png|jpg|gif]/.test(fileType)) {
                    $list.append('<li style="border:solid red px; margin:5px 5px;" class="file-item"><img src="' + this.result + '" alt="" height="70"><span class="file-del">删除</span></li>').children(':last').hide().fadeIn(2500);
                } else {
                    $list.append('<li class="file-item"><span class="file-name">' + file.name + '</span><span class="file-del">删除</span></li>');
                }

            }
        }

        //点击删除按钮事件：
        $(".file-list").on('click', '.file-del', function () {
            let $parent = $(this).parent();
            console.log($parent);
            let index = $parent.index();
            fileList.splice(index, 1);
            $parent.fadeOut(850, function () {
                $parent.remove()
            });
            //$parent.remove()
        });
        
        //点击上传按钮事件：
        $button.on('click', function () {
            var name = $('#name').val();
       
            if (name == '') {
                layer.alert('请输入商品名称');
                return;
            }
             if(fileList.length > 6){
                    layer.alert('最多允许上传6张图片');
                    return;
            } else {
                var formData = new FormData();
                for (var i = 0, len = fileList.length; i < len; i++) {
                    //console.log(fileList[i]);
                    formData.append('upfile[]', fileList[i]);
                }
                formData.append('name', name);
                 
                $.ajax({
                    url: './product_add.php',
                    type: 'post',
                    data: formData,
                    dataType: 'json',
                    processData: false,
                    contentType: false,
                    success: function (data) {
                        if (data.status == '1') {
                            layer.msg(data.content, {icon: 6});
                        } else if (data.status == '2') {
                            layer.msg(data.content, {icon: 1});
                        }
                    }
                })
            }
        })
    })
</script>
</body> --%>
   
</html>

