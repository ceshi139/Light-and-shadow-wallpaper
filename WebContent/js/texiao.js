$(document).ready(function(){
    $(".info").hide();

    $(".Avatar").hover(function(){
        $(".info").slideDown("slow");
    });
    $(".info").mouseleave(function(){
        $(this).slideUp("slow");
    });

    $(".a").hover(function(){
        var aaaa=$(this).height();
        var aaa=-aaaa;
        $(".b",this).stop().animate({height:aaaa,marginTop:aaa,opacity:'toggle'});
    },function(){
        $(".b",this).stop().animate({height:'0px',marginTop:'0px',opacity:'toggle'});
    });

})