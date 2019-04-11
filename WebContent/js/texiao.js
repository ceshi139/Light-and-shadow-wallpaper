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
                        alert("收藏成功！");
                    }else if (flag==0) {
                        z.parent().find(".my_like_img").attr({src:"img/nolike.png",title:"添加收藏"});
                        var a = CollectionNumber-1;
                        z.parent().find(".my_like_div_nobr").text(a);
                        alert("取消收藏成功！");
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
        	var z=$(this);
        	var params = {
               pic_id: pic_id,
               user_id: user_id
            }
        	$.ajax({
                     url: "User_collectpic",
                     type: "post",
                     data: params,
                     datatype: "json",
                     success: function (data, textStatus) {
                    	var flag = data.result;
                    	if(flag==1){
                            z.parent().find(".my_like_img").attr({src:"img/nolike.png",title:"添加收藏"});
                        }else if (flag==0) {
                        	 z.parent().find(".my_like_img").attr({src:"img/like.png",title:"取消收藏"});
                        }else {
                        	z.parent().find(".my_like_img").attr({src:"img/nolike.png",title:"添加收藏"});
                        }
                     }
                 });
        });
    
    //点击下载图片按钮
    $(".my_like_div2").click(function () {

        alert("开始下载图片");
    });
});