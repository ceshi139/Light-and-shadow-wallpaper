<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/buju.css"/>

    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/texiao.js"></script>
    <%@ taglib prefix="s" uri="/struts-tags" %>
</head>
<body>
<div>
  <div>
      <div style="width:100%;height:120px;border: 0px solid red;">
          <p style="text-align: center"><img style="width: 100px;height: 100px;border-radius:50%;margin-left: 10%;" title="<s:property value="#session.user.username"/>" class="Avatar" src="http://q.qlogo.cn/headimg_dl?bs=qq&dst_uin=<s:property value="#session.user.email" />&src_uin=qq.zy7.com&fid=blog&spec=640" /><s:property value="#session.user.username" />的收藏夹</p>
      </div>
                  <div class="bigbig">
                        <div class="big" style="margin-left:4%;">
                       <input type="hidden" id="user_id" value="${user.id}"/>
                            <s:iterator value="#session.pc4">
                 				
                                <div class="a"><img src='<s:property value="url"/>' style="width:100%;"/>
                                    <div class="b">
                                        <div class="my_like_div" title="点击爱心收藏">
                                            <img class="my_like_img" title="添加收藏"  src="img/nolike.png" id="my_like" name='<s:property value="id"/>' />
                                            <span class="my_like_div_nobr"><s:property value="CollectionNumber"/></span>
                                        </div>
                                        <div class="my_like_div2"  title="下载此图片">
                                            <img class="my_like_img2"  src="img/downloadimg.png" />
                                            <span>下载图片</span>
                                        </div>
                                    </div>
                                </div>
                                
                            </s:iterator>
                        </div>
                        <div class="big">
                            <s:iterator value="#session.pc5">
                                <div class="a">
                                    <img src='<s:property value="url"/>' style="width:100%;"/>
                                    <div class="b">
                                        <div class="my_like_div" title="点击爱心收藏">
                                            <img class="my_like_img" title="添加收藏"  src="img/nolike.png" id="my_like" name='<s:property value="id"/>' />
                                            <span><s:property value="CollectionNumber" /></span>
                                        </div>
                                        <div class="my_like_div2"  title="下载此图片">
                                            <img class="my_like_img2"  src="img/downloadimg.png"  />
                                            <span>下载图片</span>
                                        </div>
                                    </div>
                                </div>
                            </s:iterator>
                        </div>
                        <div class="big">
                            <s:iterator value="#session.pc6">
                                <div class="a"><img src='<s:property value="url"/>' style="width:100%;"/>
                                    <div class="b">
                                        <div class="my_like_div" title="点击爱心收藏">
                                            <img class="my_like_img" title="添加收藏"  src="img/nolike.png" id="my_like" name='<s:property value="id"/>' />
                                            <span><s:property value="CollectionNumber" /> </span>
                                        </div>
                                        <div class="my_like_div2"  title="下载此图片">
                                            <img class="my_like_img2"  src="img/downloadimg.png" />
                                            <span>下载图片</span>
                                        </div>
                                    </div>
                                </div>
                            </s:iterator>
                        </div>
                    </div>
				</div>
</div>

</body>
</html>
