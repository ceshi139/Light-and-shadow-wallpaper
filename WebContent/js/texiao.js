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
                        window.location.reload();
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
});