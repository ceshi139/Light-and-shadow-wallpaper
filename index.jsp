<%--
  Created by IntelliJ IDEA.
  User: 七月。。
  Date: 2019-01-02
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <script src="js/jquery-3.3.1.min.js" ></script>
  <script type="text/javascript">
    $(function () {
      $("input[type='text']").keyup(function () {
        $("#txdiv").hidden;
        var tx=$(this).val();
        var parpem={result : tx};
        $.ajax({
          url: "query.action",
          type: "post",
          data :parpem,
          dataType: "JSON",
          success:function (data,textStatus) {
            alert(data);
          }
        });
      });
    });
  </script>
</head>
<body>
<input type="text" placeholder="输入值" name="result">
<div id="txdiv">

</div>
</body>
</html>
