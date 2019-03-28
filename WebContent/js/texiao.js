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
        if(flag==1){
            $(this).parent().find(".my_like_img").attr({src:"img/like.png",title:"取消收藏"});
            flag=0;
        }else if (flag==0) {
            $(this).parent().find(".my_like_img").attr({src:"img/nolike.png",title:"添加收藏"});
            flag=1;
        }else {
            alert("出错了");
        }
    });

    //点击下载图片按钮
    $(".my_like_div2").click(function () {

        alert("开始下载图片");
    });
});