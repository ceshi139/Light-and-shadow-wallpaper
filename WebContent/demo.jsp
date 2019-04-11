<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>基于amaze-ui的充值界面</title>
    <link rel="stylesheet" type="text/css" href="css/amazeui.min.css"  />
    <link rel="stylesheet" type="text/css" href="css/getmoney_main.css"  />
    <link rel="stylesheet" type="text/css" href="css/message.css"  />
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"  />

</head>

<body>
<div class="pay">
    <!--主内容开始编辑-->
    <div class="tr_recharge">
        <div class="tr_rechtext">
            <p class="te_retit"><img src="images/coin.png"  alt="" />充值中心</p>
            <p>1.余额与VIP挂钩。</p>
            <p>2.转账时一定要输入对应金额!(如果输入错误管理员概不负责)</p>
            <p >3.余额充值成功立即到账,如未到账请联系管理员!</p>
            <p >4.管理员QQ:1376134288 # 微信:15170806809</p>
        </div>
        <form action="getmoney.action" method="post" class="am-form" id="doc-vld-msg">
            <div class="tr_rechbox">
                <div class="tr_rechhead">
                    <img src="http://q.qlogo.cn/headimg_dl?bs=qq&dst_uin=<s:property value="#session.user.email" />&src_uin=qq.zy7.com&fid=blog&spec=640"  />
                    <p>充值帐号：
                        <nobr id="adduser" style="font-size: 20px;color: #27B0D6;"><s:property value="#session.user.username" /></nobr>
                        <input style="border: 0px" name="pay_id" type="hidden" value="<s:property value="#session.user.username" />" ></input>
                    </p>
                    <div class="tr_rechheadcion">
                        <img src="images/coin.png"  alt="" />
                        <span id="userNowMoney">当前余额:<s:property value="#session.usernowmoney" />元</span>
                    </div>
                </div>
                <div class="tr_rechli am-form-group">
                    <ul class="ui-choose am-form-group" id="uc_01">
                        <li>
                            <label class="am-radio-inline">
                                <input  type="radio" name="docVlGender" data-validation-message="请选择一项充值额度"> 0.01￥
                            </label>
                        </li>
                        <li>
                            <label class="am-radio-inline">
                                <input type="radio" name="docVlGender" required data-validation-message="请选择一项充值额度"> 9.9￥/1月
                            </label>
                        </li>
                        <li>
                            <label class="am-radio-inline">
                                <input type="radio" name="docVlGender" data-validation-message="请选择一项充值额度"> 66￥/6月
                            </label>
                        </li>

                        <li>
                            <label class="am-radio-inline">
                                <input type="radio" name="docVlGender" data-validation-message="请选择一项充值额度"> 99￥/12月
                            </label>
                        </li>
                        <li>
                            <label class="am-radio-inline">
                                <input type="radio" name="docVlGender" data-validation-message="请选择一项充值额度"> 其他金额
                            </label>
                        </li>
                    </ul>
                </div>
                <div class="tr_rechoth am-form-group">
                    <span>其他金额：</span>
                    <input type="number" min="0.01" max="10000" class="othbox" style="margin-left: 20px;" data-validation-message="充值金额范围：0.01-10000元" />
                </div>
                <div class="tr_rechcho am-form-group">
                    <span>充值方式：</span>
                    <label class="am-radio">
                        <input style="width: 0px;height: 0px;opacity: 0" type="radio" checked="checked" name="type" value="2" ><img style="border:3px solid #27b0d6 " class="qq_img" src="images/qqzf.png" />
                    </label>
                    <label class="am-radio" style="margin-left:-30px;">
                        <input style="width: 0px;height: 0px;opacity: 0" type="radio" name="type" value="1" ><img class="zfb_img" src="images/zfbpay.png" />
                    </label>
                </div>
                <div class="tr_rechnum">
                    <span>应付金额：</span>
                    <input style="padding-left:10px;border: 1px solid #ccc;margin-left:18px;width:104px;" name="price" value="0.00" class="rechnum"></input>
                    ￥
                </div>
            </div>
            <div class="tr_paybox">
                <input style="margin-left: 0px;" type="submit" value="确认支付" class="tr_pay am-btn" />
                <span style="color: red;">温馨提示：支付页面如果要输入充值金额,请输入对应金额，否则会充值失败!</span>
            </div>
        </form>
    </div>
</div>

<script type="text/javascript" src="js/jquery.min.js" ></script>
<script type="text/javascript" src="js/amazeui.min.js" ></script>
<script type="text/javascript" src="js/ui-choose.js" ></script>
<script src="js/message.js" ></script>
<script type="text/javascript">

        //清空地址栏,,后台充值金额
       $(function() {


           var addmoneyuser=$("#adduser").text();
           var url = location.search; //获取url中"?"符后的字串

           //找到位置status
           var StatusindexOf=url.indexOf("status");
           //找到money位置
           var moneyindexof=url.indexOf("money");
           //money后一个参数的位置
           var pay_timeindexof=url.indexOf("&pay_time");
           //获得用户充值实际金额
           var moneysub=url.substring(moneyindexof+6,pay_timeindexof);
           //判断stauts=0
           var Statussub=url.substring(StatusindexOf+7,StatusindexOf+8);
           //后台需要数据
           var param={
               money : moneysub,
               addmoneyuser :addmoneyuser,
           }
           if(Statussub.length==0){
               /*alert("付款失败!");*/
               /*$.message({
                   message:'没有支付!',
                   time:'3000',
                   type:'warning',
                   showClose:true,
                   autoClose:true,
               });*/
           }else if (Statussub.length==1) {
               $.message({
                   message:'支付成功!',
                   time:'3000',
                   type:'success',
                   showClose:true,
                   autoClose:true,
               });
                $.ajax({
                    url : "User_addmoney",
                    type : "post",
                    data : param,
                    datatype : "json",
                    success:function(data,textStatus){
                        var usernowmoney=data.usernowmoney;
                        $("#userNowMoney").text("当前余额"+usernowmoney+"元");
                    }
                });
           }else{
               $.message({
                   message:'付款出错!',
                   time:'3000',
                   type:'error',
                   showClose:true,
                   autoClose:true,
               });
           }

           //清空代码
           var state = {title:'',url:window.location.href};
           history.pushState(state,'','demo.jsp');
       });


       $(function () {
          $(".qq_img").click(function () {
              $(this).attr("style","border:3px solid #27b0d6");
              $(".zfb_img").attr("style","");
          });
          $(".zfb_img").click(function () {
              $(this).attr("style","border:3px solid #27b0d6");
              $(".qq_img").attr("style","");
          });
       });

    // 将所有.ui-choose实例化
    $('.ui-choose').ui_choose();
    // uc_01 ul 单选
    var uc_01 = $('#uc_01').data('ui-choose'); // 取回已实例化的对象
    uc_01.click = function(index, item) {
        console.log('click', index, item.text())
    }
    uc_01.change = function(index, item) {
        console.log('change', index, item.text())
    }
    $(function() {
        $('#uc_01 li:eq(4)').click(function() {
            $('.tr_rechoth').show();
            $('.tr_rechoth').find("input").attr('required', 'true')
            $('.rechnum').text('0.00元');
            $('.rechnum').val('0.00');

        })
        $('#uc_01 li:eq(0)').click(function() {
            $('.tr_rechoth').hide();
            $('.rechnum').text('0.01元');
            $('.rechnum').val('0.01');
            $('.othbox').val('');
        })
        $('#uc_01 li:eq(1)').click(function() {
            $('.tr_rechoth').hide();
            $('.rechnum').text('9.90元');
            $('.rechnum').val('9.9');
            $('.othbox').val('');
        })
        $('#uc_01 li:eq(2)').click(function() {
            $('.tr_rechoth').hide();
            $('.rechnum').text('66.00元');
            $('.rechnum').val('66');
            $('.othbox').val('');
        })
        $('#uc_01 li:eq(3)').click(function() {
            $('.tr_rechoth').hide();
            $('.rechnum').text('99.00元');
            $('.rechnum').val('99');
            $('.othbox').val('');
        })
        $(document).ready(function() {
            $('.othbox').on('input propertychange', function() {
                var num = $(this).val();
                $('.rechnum').html(num+".00元");
                $('.rechnum').val(num);
            });
        });
    })

    $(function() {
        $('#doc-vld-msg').validator({
            onValid: function(validity) {
                $(validity.field).closest('.am-form-group').find('.am-alert').hide();
            },
            onInValid: function(validity) {
                var $field = $(validity.field);
                var $group = $field.closest('.am-form-group');
                var $alert = $group.find('.am-alert');
                // 使用自定义的提示信息 或 插件内置的提示信息
                var msg = $field.data('validationMessage') || this.getValidationMessage(validity);

                if(!$alert.length) {
                    $alert = $('<div class="am-alert am-alert-danger"></div>').hide().
                    appendTo($group);
                }
                $alert.html(msg).show();
            }
        });
    });
</script>
</body>

</html>