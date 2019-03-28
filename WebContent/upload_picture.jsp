<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript" src="js/up.js" ></script>
    <script type="text/javascript" src="js/biaoqian.js"></script>
    <script type="text/javascript" src="js/layer_upload.js"></script>
</head>
<body>
<section class="aui-content">
    <div style="height:20px;"></div>
    <div class="aui-content-up">
        <form action="" name="form1" method="post">
            <div class="aui-content-up-form">
                <h2>上传图片</h2>
            </div>
            <div class="aui-form-group clear">
                <label class="aui-label-control">
                    图片上传 <em>*</em>
                    <span>小于5M</span>
                </label>
                <div class="aui-form-input">
                    <div class="aui-content-img-box aui-content-full">
                        <div class="aui-photo aui-up-img clear">
                            <section class="aui-file-up fl">
                                <img src="images/up.png"  class="add-img">
                                <input type="file" name="file" id="file" class="file" value="" accept="image/jpg,image/jpeg,image/png,image/bmp" multiple/>
                            </section>
                        </div>
                    </div>
                </div>
            </div>
            <div class="aui-form-group clear">
                <label class="aui-label-control">
                    图片标签 <em>*</em>
                </label>
                <div class="aui-form-input">
                    <div class="wrap">
                        <div class="label-selected">
                            <a href="javascript:;" class="layui-btn layui-btn-sm show-labelitem" style="float: right; margin: 4px; display: block;line-height: 30px;">展开标签库 </a>
                            <a href="javascript:;" class="layui-btn layui-btn-sm hide-labelitem" style="float: right; margin: 4px; display: none;line-height: 30px;">收起标签库 </a>
                            <input type="hidden" name="label">
                        </div>
                        <div class="layui-col-md12" id="labelItem">
                            <!--标签库-->
                            <div class="label-item">
                                <li data="春天"><span>春天</span></li>
                                <li data="夏天"><span>夏天</span></li>
                                <li data="秋天"><span>秋天</span></li>
                                <li data="冬天"><span>冬天</span></li>
                                <li data="卡通"><span>卡通</span></li>
                                <li data="动物"><span>动物</span></li>
                                <li data="影视"><span>影视</span></li>
                                <li data="游戏"><span>游戏</span></li>
                                <li data="植物"><span>植物</span></li>
                                <li data="风景"><span>风景</span></li>
                                <li data="明星"><span>明星</span></li>
                                <li data="名车"><span>名车</span></li>
                                <li data="不同风格"><span>不同风格</span></li>
                            </div>
                        </div>
                        <%--<a href="javascript:;" class="layui-btn" id="cell">获取</a>--%>
                    </div>
                    <span class="tips" id="divname">最多5个标签</span>
                </div>
            </div>

            <div class="aui-form-group clear">
                <label class="aui-label-control">
                    图片描述 <em>*</em>
                </label>
                <div class="aui-form-input">
                    <input type="text" class="aui-form-control-two" name="youziz" id="3" placeholder="请输入图片相关描述" onBlur="checkpsd2()" required/>
                    <span class="tips" id="zizhi">提示...</span>
                </div>
            </div>
            <div class="aui-form-group clear" style="margin-bottom: 30px;">
                <label class="aui-label-control">
                    添加其他...
                </label>
                <div class="aui-form-input">
                    <input type="text" class="aui-form-control-two" name="youphone" id="2" placeholder="输入提示" onBlur="checkpsd1()" required/>
                    <span class="tips" id="phone">提示...</span>
                </div>
            </div>


        </form>
    </div>
    <div class="aui-btn-default">
        <button class="aui-btn aui-btn-account">保存并提交审核</button>
    </div>
</section>
<!-- mask begin -->
<div class="aui-mask aui-works-mask">
    <div class="aui-mask-content">
        <p class="aui-delete-text">确定要删除你上传的资料？</p>
        <p class="aui-check-text">
            <span class="aui-delete aui-accept-ok">确定</span>
            <span class="aui-accept-no">取消</span>
        </p>
    </div>
</div>
</body>
</html>


