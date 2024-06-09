<%--
  Created by IntelliJ IDEA.
  User: leojackasher
  Date: 2024/6/1
  Time: 06:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    function a1(){
        $.ajax({
            url: "http://localhost:8080/springmvc_009_war/ajax/1",
            data: {"name": $("#txtName").val()},
            success: function (data) {
                console.log(data);
            }
        });
    }
</script>
<body>

用户名:
<input type="text" id="txtName" name="username" onblur="a1()">

</body>
</html>
