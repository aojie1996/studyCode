<%--
  Created by IntelliJ IDEA.
  User: aojie
  Date: 2018/8/21
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>登录界面</title>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript" src="${APP_PATH }/static/jquery3.3.1.js"></script>
<script src="${APP_PATH }/static/bootstrap.min.js"></script>
<link href="${APP_PATH }/static/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<script type="text/javascript">
    function show_validate_msg(ele,status,msg){
        //清除当前元素的校验状态
        $(ele).parent().removeClass("has-success has-error");
        $(ele).next("span").text("");
        if(status=="success"){
            $(ele).parent().addClass("has-success");
            $(ele).next("span").text(msg);
        }else if(status="error"){
            $(ele).parent().addClass("has-error");
            $(ele).next("span").text(msg);
        }
    }

    function checks() {
        var empId=$("#emp_id").val();
        var regEmpId=/^[1-9]\d*$/;
        var emp_name=$("#emp_name").val();
       if(!regEmpId.test(empId)){
             show_validate_msg("#emp_id","error","员工编号输入的格式不正确,请输入数字！！！");
            return false;
        }else{
             show_validate_msg("#emp_id","success","格式正确");
         }
        if(emp_name==""){
            show_validate_msg("#emp_name","error","员工姓名不能为空");
            return false;
        }else{
             show_validate_msg("#emp_name","success","格式正确");
         }
        return true;
    }
    //通过js得到request传递的参数
    $.extend({
        getUrlVars: function() {
            var vars = [],
                hash;
            var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
            for (var i = 0; i < hashes.length; i++) {
                hash = hashes[i].split('=');
                vars.push(hash[0]);
                vars[hash[0]] = hash[1];
            }
            return vars;
        },
        getUrlVar: function(name) {
            return $.getUrlVars()[name];
        }
    });
    $(document).ready(function () {
        var error = $.getUrlVar('error');
        if(error==1){
            alert("用户还没登录，请登录用户");
        }
    })
</script>
<%--<%--%>
    <%--String err = request.getParameter("error");--%>
    <%--if(err!=null){--%>
        <%--if(err.equals("1")){--%>
            <%--out.print("<font color='red'>用户还没登录，请登录用户</font>");--%>
        <%--}--%>
    <%--}--%>
<%--%>--%>
<div class="row" style="margin-top: 50px; margin-bottom: 70px">
    <div class="col-xs-6 col-md-4"></div>
    <div class="col-xs-6 col-md-4">
        <h1>SSM-Project登录界面</h1>
    </div>
    <div class="col-xs-6 col-md-4"></div>
</div>

<form class="form-horizontal" action="${APP_PATH }/loginUser" method="post" onsubmit="return checks()">
    <div class="form-group">
        <label for="emp_id" class="col-sm-4 control-label">用户编号</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="emp_id" name="emp_id" placeholder="请输入用户编号">
            <span class="help-block"></span>
        </div>
    </div>
    <div class="form-group">
        <label for="emp_name" class="col-sm-4 control-label">用户姓名</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="emp_name" name="emp_name" placeholder="请输入用户姓名">
            <span class="help-block"></span>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-4 col-sm-5">
            <div class="checkbox">
                <label>
                    <input type="checkbox"> Remember me
                </label>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-4 col-sm-5">
            <button type="submit" class="btn btn-default btn-success" id="emp_login_btn">登录</button>
        </div>
    </div>
</form>
</body>
</html>
