<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>updatePicture</title>
    <style type="text/css">
        body{
           background-color:#fff;
        }
        
        input{
           border:0px;
           width:180px;        
        }
        
        .input1{
           border:0px;
           width:60px;
        }
        
        select{
           border:0px;           
        }
        .type{
           border:0px;
           width:50px;
        }
         
       .bigDiv{
           margin-left:12%;
           margin-top:10%;
           width:950px;
           height:450px;
           font-size:14px;
       }
       
       .left{
           width:700px;
           height:450px;
           border:1px solid #ddd;
           float:left;
       }
       
       .right{
           width:240px;
           height:450px;
           border:1px solid #ddd;
           float:right;
       }
    </style>

</head>
<body>
    <div class="bigDiv">
      <form action="updatePicture" method="post">
         <div class="left">
             <input type="hidden" value="<s:property value="#session.list[0].url"/>" name="picture.url"/>
             <img src="/userimg/<s:property value="#session.list[0].url"/>" style="width:700px;height:450px;"/>
         </div>
         <div class="right">
         
             <div style="width:100%;height:35px;float:left;background:#ddd;font-size:20px;">图片信息</div>
             <div style="width:90%;height:380px;float:left;margin-top:15px;margin-left:10px;">
             
                                <input type="hidden" value="<s:property value="#session.list[0].id"/>" name="picture.id"/>
                                  图片编号：<input type="text" value="<s:property value="#session.list[0].picturename"/>" name="picture.pictureName" readonly="readonly"/><br/><br/>
                                   发布时间：<input type="text" value="<s:property value="#session.list[0].time"/>" name="picture.time" readonly="readonly"/><br/><br/>
                                   文件格式：<input type="text" value="<s:property value="#session.list[0].format"/>" name="picture.format" readonly="readonly" class="input1"/><br/><br/>
                                   下载数：<input type="text" value="<s:property value="#session.list[0].CollectionNumber"/>" name="picture.CollectionNumber" readonly="readonly" class="input1"/><br/><br/>
                                   图片尺寸： <select name="picture.size">
                       <option value="<s:property value="#session.list[0].size"/>"><s:property value="#session.list[0].size"/></option>
                       <option value="1920*1080" >1920*1080</option>
                       <option value="1920*1200">1920*1200</option>
                       <option value="1280*720">1280*720</option>
                       <option value="1536*864">1536*864</option>
                       <option value="1680*1050">1680*1050</option>
                    </select><br/><br/>
                    
                    
                                   图片类型: <select name="id" class="type">

                      <option value="<s:property value="#session.list[0].type.id"/>"><s:property value="#session.list[0].type.picturetype"/></option>
                      <s:iterator value="#session.type">
                          <s:if test="picturetype!=#session.list[0].type.picturetype">
                              <option value="<s:property value="id"/>"><s:property value="picturetype"/></option>
                          </s:if>

                      </s:iterator>
                    </select><br/><br/><br/>
                    
                    <input type="submit" value="修改"/>  
             </div>              
         </div>
      </form>
    </div> 
</body>
</html>