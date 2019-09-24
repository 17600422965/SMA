<%@  page  pageEncoding="UTF-8" contentType="text/html;UTF-8" isELIgnored="false"%>
<html>
<head>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script type="application/javascript">
        //相当于onload
        $(function () {
            $("#input").blur(function () {
                //给input标签添加onblur事件
                var username=$("#input").val();
                //发送Ajax请求 校验
                $.ajax({
                    url:"${pageContext.request.contextPath}/sma/checkusername",
                    type:"GET",
                    data:"username="+username,
                    dataType:"text",
                    success:function (message) {
                        $("#span").empty();
                        $("#span").append(message);
                    }
                });
            })
        })


    </script>
</head>
<body>
<form  action="" method="post">
    用户名 <input id="input" type="text"  name="username" onblur="checkusername()" /><span id="span"></span><br/>
    密码 <input type="password" name="password" /> <br/>
    年龄 <input type="text" name="age" /> <br/>
    <input type="submit" value="注册">
</form>



</body>
</html>