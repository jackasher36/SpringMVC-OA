<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<script>
    function a1(){
        $.ajax({
            url: "/[@{/ajax/1}]/",
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