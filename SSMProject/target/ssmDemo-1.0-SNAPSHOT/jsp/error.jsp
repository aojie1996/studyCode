<%--
  Created by IntelliJ IDEA.
  User: aojie
  Date: 2018/8/22
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p style="font-size:22px">用户名或密码错误,请确认之后重新登录....</p>
<script>
    window.setTimeout(function(){
        window.open('jsp/login.jsp','_parent');
    },1000);
</script>

<html>
<head>
    <title>错误界面</title>
</head>
<body>

</body>
</html>
