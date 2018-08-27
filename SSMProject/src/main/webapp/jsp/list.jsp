<%--
  Created by IntelliJ IDEA.
  User: aojie
  Date: 2018/8/18
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>员工列表</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <script src="${APP_PATH }/static/jquery3.3.1.js"></script>
    <script src="${APP_PATH }/static/bootstrap.min.js"></script>
    <link href="${APP_PATH }/static/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 员工修改的模态框 -->
<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">员工修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="empName_update_static"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="text" name="email" class="form-control" id="email_update_input" placeholder="email@atguigu.com">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_update_input" value="M" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_update_input" value="w"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
                            <!-- 部门提交部门id即可 -->
                            <select class="form-control" name="dId">
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>


<!-- 利用bootstrap，显示员工添加的模态框 -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">员工添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <input type="text"  name="empName" class="form-control" id="empName_add_input" placeholder="empName">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="text" name="email" class="form-control" id="email_add_input" placeholder="email@qq.com">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_add_input" value="M" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_add_input" value="w"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
                            <!-- 部门提交部门id即可 -->
                            <select class="form-control" name="dId">
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>
<!--得到session作用域中用户名，判断是否存在-->
<%
    String userName= (String) session.getAttribute("userName");
    if (userName==null){
        response.sendRedirect("login.jsp?error=1");
        return;
    }
%>
<!--搭建导航栏-->
<div class="row" style="background-color: lightskyblue">
    <%--<div class="col-md-2" style="background-color: #2b542c"></div>--%>
    <div class="col-md-3 col-md-offset-1"><h1>SSM-Project</h1></div>
    <div class="col-md-5"></div>
    <div class="col-md-3" style="margin-top: 20px">
        <h4>欢迎您，<span style="color: red">${sessionScope.get("userName")}</span></h4>
    </div>
</div>
<!-- 搭建显示页面 -->
<div class="container" style="margin-top: 30px">
    <%--<!-- 标题 -->--%>
    <%--<div class="row">--%>
        <%--<div class="col-md-12">--%>
            <%--<h1>SSM-Project</h1>--%>
        <%--</div>--%>
    <%--</div>--%>
    <!-- 按钮 -->
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-success" id="emp_add_modal_btn">新增</button>
        </div>
    </div>
    <!-- 显示表格数据 -->
    <div class="row">
        <div class="col-md-12">
            <table id="tableList" class="table table-hover">
                <tr>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>
                <!--把pageInfo中的中的对象取出来，给一个名字叫emp-->
                <c:forEach items="${pageInfo.list }" var="emp">
                    <tr>
                        <th>${emp.empId }</th>
                        <th>${emp.empName }</th>
                        <th>${emp.gender=="M"?"男":"女" }</th>
                        <th>${emp.email }</th>
                        <th>${emp.department.deptName }</th>
                        <th>
                            <button class="btn btn-primary btn-sm edit_btn">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                编辑
                            </button>
                            <button class="btn btn-danger btn-sm delete_btn">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                删除
                            </button>
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <!-- 显示分页信息 -->
    <div class="row">
        <!--分页文字信息  -->
        <div class="col-md-6">当前 ${pageInfo.pageNum }页,总${pageInfo.pages }
            页,总 ${pageInfo.total } 条记录</div>
        <!-- 分页条信息 -->
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="${APP_PATH }/empsModel?pn=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage }"><!--pageInfo.hasPreviousPage判断其是否存在上一页return true 和 false-->
                        <li><a href="${APP_PATH }/empsModel?pn=${pageInfo.pageNum-1}"
                               aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                        </a></li>
                    </c:if>


                    <c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
                        <c:if test="${page_Num == pageInfo.pageNum }">
                            <li class="active"><a href="#">${page_Num }</a></li>
                        </c:if>
                        <c:if test="${page_Num != pageInfo.pageNum }">
                            <li><a href="${APP_PATH }/empsModel?pn=${page_Num }">${page_Num }</a></li>
                        </c:if>

                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage }"><!--pageInfo.hasNextPage判断其是否存在下一页return true 和 false-->
                        <li><a href="${APP_PATH }/empsModel?pn=${pageInfo.pageNum+1 }"
                               aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                        </a></li>
                    </c:if>
                    <li><a href="${APP_PATH }/empsModel?pn=${pageInfo.pages}">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<script type="text/javascript">
    $("#emp_add_modal_btn").click(function () {
        //发送ajax请求，查出部门信息，显示在下拉列表中
        getDepts("#empAddModal select");
        //弹出模拟框
        $("#empAddModal").modal({
            backdrop:"static"
        });
    })

    //查出所有的部门信息并显示在下拉列表中
    function getDepts(ele) {
         //清空之前下拉框的内容
        $(ele).empty();
        //利用ajax实现对后端的访问
        $.ajax({
            url:"${APP_PATH}/depts",
            type:"GET",
            success:function (result) {
                //把部门信息打印到下拉框中
                $.each(result.extend.depts,function () {
                    var optionEle =$("<option></option>").append(this.deptName).attr("value",this.deptId);
                    optionEle.appendTo(ele);
                })
            }
        })

    }

    //新增员工信息
    $("#emp_save_btn").click(function () {
        if(!validate_add_form()){
            return false;
        }
        $.ajax({
            url:"${APP_PATH}/emp",
            type:"POST",
            data:$("#empAddModal form").serialize(),
            success:function (result) {
                alert(result.msg);
                $("#empAddModal").modal("hide");
                goto_page(1);
            }
        });
    })

    //对新增表单信息进行前端验证
    function validate_add_form() {
        //利用正则表达式对新增表单信息进行验证
        var empName=$("#empName_add_input").val();
        var empEmail=$("#email_add_input").val();
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        var regEmail=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if(!regName.test(empName)){
            //alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
            show_validate_msg("#empName_add_input","error","用户名可以是2-5位中文或者6-16位英文和数字的组合");
            return false;
        }else{
            show_validate_msg("#empName_add_input","success","格式正确");
        }
        if(!regEmail.test(empEmail)){
            //alert("邮箱格式不正确");
            show_validate_msg("#email_add_input","error","邮箱格式不正确");
            return false;
        }else {
            show_validate_msg("#email_add_input","success","格式正确");
        }
        return true;
    }

    //美化表单校验的提示信息
    function show_validate_msg(ele,status,msg){
        //清除当前的校验状态
        $(ele).parent().removeClass("has-success has-error");
        $(ele).next("span").text("");
        if(status=="success"){
            $(ele).parent().addClass("has-success");
            $(ele).next("span").text(msg);
        }else if(status=="error"){
            $(ele).parent().addClass("has-error");
            $(ele).next("span").text(msg)
        }
    }
    //删除员工信息
    $(".delete_btn").click(function () {
        //弹出是否确认删除的对话框
        var empName=$(this).parents("tr").find("th:eq(1)").text();
        var empId=$(this).parents("tr").find("th:eq(0)").text();
        if(confirm("确定要删【"+empName+"】除吗？")){
              $.ajax({
                  url:"${APP_PATH}/emp/"+empId,
                  type:"DELETE",
                  success:function (result) {
                      goto_page(1);
                      alert(result.msg);
                  }
              })
        }
    })

    //修改用户信息
   $(".edit_btn").click(function () {
       //发送ajax请求，查出部门信息，显示在下拉列表中
       getDepts("#empUpdateModal select");
       //得到用户的id值
       var empId=$(this).parents("tr").find("th:eq(0)").text();
       //根据empId值得到对应的属性
       getEmp(empId);
       //把对应的员工id传给模拟框的更新按钮
       $("#emp_update_btn").attr("edit-id",empId);
       //弹出模拟框
       $("#empUpdateModal").modal({
           backdrop:"static"
       });
   })

    //得到员工表中的数据填充到修改框中
    function getEmp(id){
        $.ajax({
            url:"${APP_PATH}/emp/"+id,
            type:"GET",
            success:function (result) {
                var empData=result.extend.emp;
                $("#empName_update_static").text(empData.empName);
                $("#email_update_input").val(empData.email);
                $("#empUpdateModal input[name=gender]").val([empData.gender]);
                //console.log(empData.gender);
                $("#empUpdateModal select").val([empData.dId]);
            }
        });
    }

    //点击模拟框中更新按钮更新信息
    $("#emp_update_btn").click(function () {
        //验证邮箱是否合法
        //1、校验邮箱信息
        //2、发送ajax请求保存更新的员工数据
        $.ajax({
            url:"${APP_PATH}/updateemp/"+$(this).attr("edit-id"),
            type:"GET",
            data:$("#empUpdateModal form").serialize(),
            success:function () {
                //关闭模拟框
                $("#empUpdateModal").modal("hide");
                goto_page(1);
            }
        })
    })
     function goto_page(pn) {
         $.ajax({
             url:"/empsModel",
             type:"get",
             data:"pn="+pn,
             success:function () {
                 console.log("操作成功");
             }
         })
     }
</script>
</body>
</html>
