$(document).ready(function(){
    /*隐藏个人信息面板*/
    $(".info").hide();

    /*鼠标悬浮头像显示*/
    $(".Avatar").hover(function(){
        $(".info").slideDown("slow");
    });
    /*鼠标移开隐藏*/
    $(".info").mouseleave(function(){
        $(this).slideUp("slow");
    });

    /*鼠标悬浮显示收藏面板*/
    $(".a").hover(function(){
        var aaaa=$(this).height();
        var aaa=-aaaa;
        $(".b",this).stop().animate({height:aaaa,marginTop:aaa,opacity:'toggle'});
    },function(){
        $(".b",this).stop().animate({height:'0px',marginTop:'0px',opacity:'toggle'});
    });

    //点击爱心特效
    var flag=1;
    /*$(".big div div div img").click(function () {

        alert($(this).parent().find("span").text());
    });*/
    $(".my_like_div").click(function () {
    	var pic_id = $(this).parent().find(".my_like_img").attr("name");
    	var user_id = $("#user_id").val();
    	var CollectionNumber = $(this).parent().find(".my_like_div_nobr").text();
    	var z=$(this);
    	var params = {
           pic_id: pic_id,
           user_id: user_id,
        }
    	if(user_id == null || user_id == ""){
    		alert("请先登陆！再收藏！");
    	}else{
    		 $.ajax({
                 url: "User_collect",
                 type: "post",
                 data: params,
                 datatype: "json",
                 success: function (data, textStatus) {
                	var flag = data.result;
                	if(flag==1){
                        z.parent().find(".my_like_img").attr({src:"img/like.png",title:"取消收藏"});


                       var a =  Number(CollectionNumber)+1;
                        z.parent().find(".my_like_div_nobr").text(a);
                        $.message({
                            message:'收藏成功!',
                            time:'3000',
                            type:'success',
                            showClose:true,
                            autoClose:true,
                        });
                    }else if (flag==0) {
                        z.parent().find(".my_like_img").attr({src:"img/nolike.png",title:"添加收藏"});
                        var a = CollectionNumber-1;
                        z.parent().find(".my_like_div_nobr").text(a);
                        //判断收藏页取消收藏立即刷新页面
                        if($(document).attr("title")=="我的收藏..."){
                            window.location.reload();
                        }

                        $.message({
                            message:'取消收藏成功!',
                            time:'3000',
                            type:'success',
                            showClose:true,
                            autoClose:true,
                        });
                    }else {
                    	alert("请先登陆！再收藏！");
                    }
                 }
             });
    	}
    });
    
    $(".a").mouseover(function(){
        	var pic_id = $(this).find(".my_like_img").attr("name");
        	var user_id = $("#user_id").val();
        	var fromuser_id = $(this).find(".my_like_div3").attr("name");
        	var z=$(this);
        	var params = {
               pic_id: pic_id,
               user_id: user_id,
               fromuser_id: fromuser_id
            }
        	$.ajax({
                     url: "User_collectpic",
                     type: "post",
                     data: params,
                     datatype: "json",
                     success: function (data, textStatus) {
                    	var flag = data.result;
                    	var flag_a = data.result_a;
                    	if(flag==1){
                            z.parent().find(".my_like_img").attr({src:"img/nolike.png",title:"添加收藏"});
                        }else{
                        	 z.parent().find(".my_like_img").attr({src:"img/like.png",title:"取消收藏"});
                        }
                    	if(flag_a == 2) {
                        	z.parent().find(".my_like_div3 img").attr({src:"img/guanzhu.jpg",title:"添加关注"});;
                        }else{
                        	z.parent().find(".my_like_div3 img").attr({src:"img/no_guanzhu.png",title:"取消关注"});;
                        }
                     }
                 });
        });
    
    //点击下载图片按钮
    $(".my_like_div2").click(function () {
        /*图片名*/
        var ImgName="test.jpg";
        /*下载action*/
        var url = "downloadimg";

        /*找到父类b元素的同类img的src*/
        var ImgUrl =$(this).parent(".b").siblings("img").attr("src");
        //创建隐形form表单
        var form = $("<form></form>").attr("action", url).attr("method", "post");
        form.append($("<input></input>").attr("type", "hidden").attr("name", "ImgUrl").attr("value", ImgUrl));
        form.append($("<input></input>").attr("type", "hidden").attr("name", "ImgName").attr("value", ImgName));
        form.appendTo('body').submit().remove();

    });


    /*window.onscroll=function() {


        // 窗口可视范围的高度
        var height = getClientHeight(),
            // 窗口滚动条高度
            theight = getScrollTop(),
            // 窗口可视范围的高度
            rheight = getScrollHeight(),
            hhh=getziyemian(),
            // 滚动条距离底部的高度
            bheight = rheight - theight - height;
        document.getElementById('show').innerHTML = '此时浏览器可见区域高度为：' + height + '<br />此时文档内容实际高度为：' + rheight + '<br />此时滚动条距离顶部的高度为：' + theight + '<br />此时滚动条距离底部的高度为：' + bheight+'<br/>此时子页面内容高度是:'+hhh;
    }*/


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
        return document.getElementById("iframe").contentDocument.body.scrollHeight;
    }

    //距离底部距离
    function getbottom(){
        return getScrollHeight()-getScrollTop()-getClientHeight();
    }


    /*iframe高度自适应*/
    $(".daohang li").click(function () {

        /*延迟0.5秒加载高度*/
        setTimeout(function(){
            var iframe = document.getElementById("iframe");
            $("#iframe").css({"height":0});
            var bHeight =iframe.contentWindow.document.body.scrollHeight;
            var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
            var height = Math.max(bHeight, dHeight);
            var hhh=height+500;
            $("#iframe").css({"height":hhh});
            var a=$("#iframe").attr("height");
        }, 500)
    });
});