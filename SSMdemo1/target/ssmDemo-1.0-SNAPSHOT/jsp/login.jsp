<%--
  Created by IntelliJ IDEA.
  User: aojie
  Date: 2018/8/17
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>登陆</title>
    <style>
        body{
            margin: 0px;
            padding: 0px;
        }
        #tableForm{
            /*background-color: aqua;*/
            margin: 10px auto;
            height: 130px;
            width: 300px;
        }
        #tableForm tr{
            text-align: right;
        }
    </style>
</head>
<body>
<form action="/checkLogin" method="post" >
    <table id="tableForm" cellspacing="0">
        <tr>
            <td>用户id：</td>
            <td><input type="text" id="id" name="id"></td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><input type="text" id="username" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" id="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="登陆">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
