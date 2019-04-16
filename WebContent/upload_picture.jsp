
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">

    <title>信息照片上传</title>

    <link rel="stylesheet" type="text/css" href="css/base_upload.css" >
    <link rel="stylesheet" type="text/css" href="css/home_upload.css" >
    <link rel="stylesheet" type="text/css" href="css/layui_upload.css">
    <script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
    <script type="text/javascript" src="js/biaoqian.js"></script>
    <script type="text/javascript" src="js/layer_upload.js"></script>
    <script type="text/javascript">
/*     function imgChange() {
    //获取点击的文本框
    var file =document.getElementById("file");
    var imgUrl =window.URL.createObjectURL(file.files[0]);
    var img =document.getElementById('imghead');
    img.setAttribute('src',imgUrl); // 修改img标签src属性值
 } */
 	$(function(){
 		$("#imghead").click(function(){
 			$("#file").click();
 			$("#file").on("change",function(){
 				var file = (this).files;
 				var dd = "";
 				$.each(file,function(i,item){
 					var img = URL.createObjectURL(file[i]);
 					dd+="<div id='tu' style='position:relative;float:left;'><img src='"+img+"' style='margin:10px 10px 10px;height:130px;width:130px;z-index:-1'/>";
 					dd+="<img id='dele' src='images/close.png' style='width:25px;height:25px;position:absolute;left:80%;' /></div>";
 				});				
 				$("#img").show().empty();
 				$(dd).hide().appendTo("#img").fadeIn("slow");
 				//$("#img").empty().append(dd);
 				$("[id = dele]").on("click",function(){
 					$(this).parent("#tu").remove();
 	 		 	});
 			});
 		});

 		
 	});
  </script>
</head>
<body>
<section class="aui-content">
    <div style="height:20px;"></div>
    <div class="aui-content-up">
        <form action="User_up" method="post" enctype = "multipart/form-data">
            <div class="aui-content-up-form">
                <h2>上传图片</h2>
            </div>
            <div class="aui-form-group clear">
                <label class="aui-label-control">
                    图片上传 <em>*</em>
                    <span>小于5M<br/>(Ctrl多选)</span>
                </label>
                <!-- <div class="aui-form-input">
                    <div class="aui-content-img-box aui-content-full">
                        <div class="aui-photo aui-up-img clear">
                            <section class="aui-file-up fl">
                                <img src="images/up.png"  class="add-img">

                                <input type="file" name="file" id="file" class="file" accept="image/jpg,image/jpeg,image/png,image/bmp" multiple/>
                            </section>
                        </div>
                    </div>
                </div> -->
                <div class="aui-form-input" style="">
                    <div class="aui-content-img-box aui-content-full">
                        <input type="file" name="file" id="file" accept="image/*"  style="display:none;" multiple/>
                        <div id="preview" class="aui-photo">
                            <div id="img" class="aui-file-up fl" style="display:none;"></div>
                            <img id="imghead" src="images/up.png"  class="add-img" style="margin:10px 10px 10px;height:130px;width:130px;"  />
                        </div>
                    </div>
                </div>
            </div>



            <div class="aui-form-group clear" style="margin-bottom: 30px;">
                <label class="aui-label-control">

                    图片尺寸 <em>*</em>
                </label>
                <div class="aui-form-input">


                    <select name="type_id" class="aui-form-control-two">
                        <s:iterator value="#session.types">

                            <option value="<s:property value='id' />"><s:property value="picturetype"/> </option>
                        </s:iterator>
                    </select>
                    <span class="tips" id="">提示...</span>
                </div>
            </div>

            <div class="aui-form-group clear">
                <label class="aui-label-control">
                    图片标题 <em>*</em>
                </label>
                <div class="aui-form-input">
                    <input type="text" class="aui-form-control-two" name="picture.picturename" id="3" placeholder="请输入图片相关描述" onBlur="checkpsd2()" />

                    <span class="tips" id="zizhi">提示...</span>
                </div>
            </div>

            <div class="aui-form-group clear" style="margin-bottom: 30px;">
                <label class="aui-label-control">

                    图片尺寸 <em>*</em>
                </label>
                <div class="aui-form-input">
                    <select name="picture.size" class="aui-form-control-two">
                        <option value="未知">全部尺寸</option>
                        <option value="1920*1080" >1920*1080</option>
                        <option value="1920*1200">1920*1200</option>
                        <option value="1280*720">1280*720</option>
                        <option value="1536*864">1536*864</option>
                        <option value="1680*1050">1680*1050</option>
                    </select>

                    <span class="tips" id="phone">提示...</span>
                </div>
            </div>
            <div style="width:500px;height:100px;">
                <button class="aui-btn aui-btn-account" type="submit">保存并提交审核</button>
            </div>
        </form>
    </div>

</section>
<!-- 
<div class="aui-mask aui-works-mask">
    <div class="aui-mask-content">
        <p class="aui-delete-text">确定要删除你上传的资料？</p>
        <p class="aui-check-text">
            <span class="aui-delete aui-accept-ok">确定</span>
            <span class="aui-accept-no">取消</span>
        </p>
    </div>

</div> -->
</body>
</html>


