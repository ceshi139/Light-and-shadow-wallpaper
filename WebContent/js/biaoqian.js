$(function(){
    $(".show-labelitem").on("click",function(){
        $(this).hide();
        $(".hide-labelitem").show();
        $("#labelItem").show();
    });
    $(".hide-labelitem").on("click",function(){
        $(this).hide();
        $(".show-labelitem").show();
        $("#labelItem").hide();
    });
    $(".label-item").on("click","li",function(){
        var geshu=5;
        var id = $(this).attr("data");
        var text = $(this).children("span").html();
        var labelHTML = "<li data='"+id+"''>x "+text+"</li>";
        if($(this).hasClass("selected")){
            return false;
        }else if($(".label-selected").children("li").length >= geshu){
            alert("最多只能选择"+geshu+"个标签哦!")
            return false;
        }
        $(".label-selected").append(labelHTML);
        val = '';
        for(var i = 0; i < $(".label-selected").children("li").length; i++){
            val += $(".label-selected").children("li").eq(i).attr("data")+',';
        }
        $("input[name='label']").val(val);
        $(this).addClass("selected");
    });
    var val = "";
    $(".label-selected").on("click","li",function(){
        var id = $(this).attr("data");
        val = '';
        $(this).remove();
        for(var i = 0; i < $(".label-selected").children("li").length; i++){
            val += $(".label-selected").children("li").eq(i).attr("data")+',';
        }
        $("input[name='label']").val(val);
        $(".label-item").find("li[data='"+id+"']").removeClass("selected");
    });


    //点击更换标签
    var limit = 0;
    $(".replacelable").on("click",function(){
        layer.load(1);
        limit += 32;
        $.ajax({
            url:window.location.href,
            type:"post",
            datatype:"json",
            data:{
                labellimit:limit
            },
            success:function(data){
                layer.closeAll('loading');
                $(".label-item").find("li").remove();//删除原先所有，本来想让数据表随机搜索的，想着有点mmp，就没搞，用的是limit
                var html = '';
                for(var i in data){
                    html += "<li data=\""+data[i].term_id+"\">x<span>"+data[i].name+"</span></li>";//拼接标签
                }
                $(".label-item").append(html);//追加至文档
            },
            error:function(){
                layer.closeAll('loading');
                layer.msg("错误~~~");
            }
        })
    })
    //获取标签
    $("#cell").on("click",function(){
        if($("input[name='label']").val() == ""){
            return false;
        }else{
            alert($("input[name='label']").val());
        }
    })
})