<%@  page  pageEncoding="UTF-8" contentType="text/html;UTF-8" isELIgnored="false"%>
<html>
<head>
    <script type="application/javascript">
        function checkusername () {
            //获取用户输入的用户名
            var  input=document.getElementById("input");
            var  username=input.value;
            //发送异步请求传输到后台
            //创建异步请求对象
            var   xhr;
            if (window.ActiveXObject){
                //IE系
                xhr=new ActiveXObject("Microsoft.XMLHTTP");
            } else {
                //非IE系
                xhr=new XMLHttpRequest();
            }
            //打开异步请求
            xhr.open("GET","${pageContext.request.contextPath}/sma/checkusername?username="+username);
            //发送异步请求
            xhr.send(null);
            //监听响应
            xhr.onreadystatechange=function () {
                //响应正确解析完成
                if (xhr.readyState==4&&xhr.status==200){
                    //获取校验的结果
                    var  message=xhr.responseText;
                    var  span=document.getElementById("span");
                    //把校验结果 放入span标签中
                    span.innerHTML=message;
                }
            }
        }
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