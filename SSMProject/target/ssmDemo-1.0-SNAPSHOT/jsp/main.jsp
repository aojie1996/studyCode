<%--
  Created by IntelliJ IDEA.
  User: aojie
  Date: 2018/8/19
  Time: 15:37
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
    <script type="text/javascript" src="${APP_PATH }/static/jquery3.3.1.js"></script>
    <script src="${APP_PATH }/static/bootstrap.min.js"></script>
    <link href="${APP_PATH }/static/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
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

    <!-- 搭建显示页面 -->
    <div class="container">
        <!-- 标题 -->
        <div class="row">
            <div class="col-md-12">
                <h1>SSM-Project</h1>
            </div>
        </div>
        <!-- 按钮 -->
        <div class="row">
            <div class="col-md-4 col-md-offset-8">
                <button class="btn btn-success" id="emp_add_modal_btn">新增</button>
                <button class="btn btn-danger" id="emp_delete_all_btn">删除</button>
            </div>
        </div>
        <!-- 显示表格数据 -->
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover" id="emps_table">
                    <thead>
                    <tr>
                        <th>
                            <input type="checkbox" id="check_all"/>
                        </th>
                        <th>#</th>
                        <th>empName</th>
                        <th>gender</th>
                        <th>email</th>
                        <th>deptName</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
        </div>

        <!-- 显示分页信息 -->
        <div class="row">
            <!--分页文字信息  -->
            <div class="col-md-6" id="page_info_area"></div>
            <!-- 分页条信息 -->
            <div class="col-md-6" id="page_nav_area">

            </div>
        </div>

    </div>
    <script type="text/javascript">
        //定义两个全局变量
        //总记录数和当前页数
        var totalRecord,currentPage;
        //1、页面加载完成以后，直接去发送ajax请求,要到分页数据
        $(document).ready(function(){
            //去首页
            to_page(1);
        });
        function to_page(pn){
            $.ajax({
                url:"${APP_PATH}/emps",
                data:"pn="+pn,
                type:"GET",
                success:function(result){
                    //控制台打印信息
                    //console.log(result);
                    //1、解析并显示员工数据
                    build_emps_table(result);
                    //2、解析并显示分页信息
                    build_page_info(result);
                    //3、解析显示分页条数据
                    build_page_nav(result);
                }
            })
        }

        function build_emps_table(result){
            //清空table表格
            $("#emps_table tbody").empty();
            var emps = result.extend.pageInfo.list;
            $.each(emps,function(index,item){//迭代出数据两个参数，第一个为索引，第二个为当前对象
                var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
                var empIdTd = $("<td></td>").append(item.empId);
                var empNameTd = $("<td></td>").append(item.empName);
                var genderTd = $("<td></td>").append(item.gender=='M'?"男":"女");
                var emailTd = $("<td></td>").append(item.email);
                var deptNameTd = $("<td></td>").append(item.department.deptName);
                /**
                 <button class="">
                 <span class="" aria-hidden="true"></span>
                 编辑
                 </button>
                 */
                var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                    .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
                //--------重要点---------------------
                //为编辑按钮添加一个自定义的属性，来表示当前员工id
                editBtn.attr("edit-id",item.empId);
                var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
                    .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
                //为删除按钮添加一个自定义的属性来表示当前删除的员工id
                delBtn.attr("del-id",item.empId);
                var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
                //var delBtn =
                //append方法执行完成以后还是返回原来的元素，链式操作
                $("<tr></tr>").append(checkBoxTd)
                    .append(empIdTd)
                    .append(empNameTd)
                    .append(genderTd)
                    .append(emailTd)
                    .append(deptNameTd)
                    .append(btnTd)
                    .appendTo("#emps_table tbody");//把元素添加到emps_table tbody里面去
            });
        }
        //解析显示分页信息
        function build_page_info(result){
             $("#page_info_area").empty();
             $("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页,总"+
            result.extend.pageInfo.pages+"页,总"+
            result.extend.pageInfo.total+"条记录");
            totalRecord = result.extend.pageInfo.total;//取到总记录数
            currentPage = result.extend.pageInfo.pageNum;//取到当前页数
        }
        //解析显示分页条，点击分页要能去下一页....
        function build_page_nav(result){
            $("#page_nav_area").empty();
            var ul=$("<ul></ul>").addClass("pagination");
            //构建元素
            var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
            var prePageLi=$("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
            if(result.extend.pageInfo.hasPreviousPage == false){//如果hasPreviousPage上一页为false，为按钮添加不能点击的属性
                firstPageLi.addClass("disabled");
                prePageLi.addClass("disabled");
            }else{
                //为元素添加点击翻页的事件
                firstPageLi.click(function(){
                    to_page(1);
                });
                prePageLi.click(function(){
                    to_page(result.extend.pageInfo.pageNum -1);
                });
            }
            var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#"));
            var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
            if(result.extend.pageInfo.hasNextPage==false){
                nextPageLi.addClass("disabled");
                lastPageLi.addClass("disabled");
            }else{
                nextPageLi.click(function () {
                    to_page(result.extend.pageInfo.pageNum+1);
                });
                lastPageLi.click(function () {
                    to_page(result.extend.pageInfo.pages)
                })
            }
            //添加首页和前一页 的提示
            ul.append(firstPageLi).append(prePageLi);

            //1,2，3遍历给ul中添加页码提示
            $.each(result.extend.pageInfo.navigatepageNums,function(index,item){
                var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href","#"));
                if(result.extend.pageInfo.pageNum==item){
                   numLi.addClass("active");
                }
                numLi.click(function () {
                    to_page(item);
                });
                ul.append(numLi);
            });

            //添加下一页和末页 的提示
            ul.append(nextPageLi).append(lastPageLi);
            //把ul加入到nav
            var navEle = $("<nav></nav>").append(ul);
            navEle.appendTo("#page_nav_area");
        }

        //清空表单样式及内容
        function reset_form(ele){
            //因为jQuery没有对象
            $(ele)[0].reset();
            //清空表单样式
            $(ele).find("*").removeClass("has-error has-success");
            $(ele).find(".help-block").text("");
        }
        //点击新增按钮，模拟框显示
         $("#emp_add_modal_btn").click(function () {
             //清除表单数据（表单完整重置（表单的数据，表单的样式））
             reset_form("#empAddModal form");
             //s$("")[0].reset();
             //发送ajax请求，查出部门信息，显示在下拉列表中
             getDepts("#empAddModal select");
             //弹出模拟框
             $("#empAddModal").modal({
                 backdrop:"static"
             });
         })

        //查出所有的部门信息并显示在下拉列表中
        function getDepts(ele){
            //清空之前下拉框的值
            $(ele).empty();
            $.ajax({
                url:"${APP_PATH}/depts",
                type:"GET",
                success:function (result) {
                    //console.log(result);
                    //把部门信息打印到下拉框中
                    $.each(result.extend.depts,function () {
                        var optionEle = $("<option></option>").append(this.deptName).attr("value",this.deptId);
                        optionEle.appendTo(ele);
                    });
                }

            });
        };

        //校验新增模拟框中的数据
        function validate_add_form(){
            var empName = $("#empName_add_input").val();
            var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
            if(!regName.test(empName)){
                //alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
                show_validate_msg("#empName_add_input","error","用户名可以是2-5位中文或者6-16位英文和数字的组合");
                return false;
            }else{
                show_validate_msg("#empName_add_input","success","");
            }
            var emailName = $("#email_add_input").val();
            var regEmail=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
            if(!regEmail.test(emailName)){
                //alert("邮箱格式不正确")
                show_validate_msg("#email_add_input","error","邮箱格式不正确");
                return false;
            }else{
                show_validate_msg("#email_add_input","success","");
            }
            return true;
        }

        //显示校验结果的提示信息
        function show_validate_msg(ele,status,msg) {
            //清除当前元素的校验状态
            $(ele).parent().removeClass("has-success has-error");
            $(ele).next("span").text("");
            if(status=="success"){
                $(ele).parent().addClass("has-success");
                $(ele).next("span").text(msg);
            }else if(status=="error"){
                $(ele).parent().addClass("has-error");
                $(ele).next("span").text(msg);
            }
        }
        //校验用户名是否可用，是否重复
        $("#empName_add_input").change(function () {
            //发送ajax请求查看用户名是否可用
            var empName = this.value;
            $.ajax({
                url:"${APP_PATH}/checkuser",
                data:"empName="+empName,
                type:"POST",
                success:function (result) {
                    if(result.code==100){
                         show_validate_msg("#empName_add_input","success","用户名可用");
                         $("#emp_save_btn").attr("ajax_va","success");
                    }else{
                        show_validate_msg("#empName_add_input","error",result.extend.va_msg);
                        $("#emp_save_btn").attr("ajax_va","error");
                    }
                }
            })
        })
        
        //新增人员
        $("#emp_save_btn").click(function () {
//            //先对要提交给服务器的数据进行校验
            if(!validate_add_form()){
                return false;
            };
            //1、判断之前的ajax用户名校验是否成功。如果成功。
            if($(this).attr("ajax_va")=="error"){
                return false;
            }
            $.ajax({
                url:"${APP_PATH}/emp",
                type:"POST",
                data:$("#empAddModal form").serialize(),
                success:function(result){
                    if(result.code==100){
                        //alert(result.msg);
                        //员工保存成功
                        //1、关闭模拟框
                        $("#empAddModal").modal("hide");
                        //2、来到最后一页，显示刚才保存的数据
                        //发送ajax请求显示最后一页数据即可
                        to_page(totalRecord);
                    }else{
                        //显示失败信息
                        console.log(result);
//                        //有哪个字段的错误信息就显示哪个字段的；
//                        if(undefined != result.extend.errorFields.email){
//                            //显示邮箱错误信息
//                            show_validate_msg("#email_add_input", "error", result.extend.errorFields.email);
//                        }
//                        if(undefined != result.extend.errorFields.empName){
//                            //显示员工名字的错误信息
//                            show_validate_msg("#empName_add_input", "error", result.extend.errorFields.empName);
//                        }
                    }
                }
            });

        })

        //1、我们是按钮创建之前就绑定了click，所以绑定不上。
        //1）、可以在创建按钮的时候绑定。    2）、绑定点击.live()
        //jquery新版没有live，使用on进行替代
        $(document).on("click",".edit_btn",function () {//点击编辑按钮显示修改的模拟框
            //alert("edit_btn");
            //发送ajax请求，查出部门信息，显示在下拉列表中
            getDepts("#empUpdateModal select");
            //2、查出员工信息，显示员工信息
            getEmp($(this).attr("edit-id"));
            //3、把员工id传给更新按钮
            $("#emp_update_btn").attr("edit-id",$(this).attr("edit-id"));
            //弹出模拟框
            $("#empUpdateModal").modal({
                backdrop:"static"
            });
        })
            //得到员工表中的数据填充到修改框中
        function getEmp(id) {
            $.ajax({
                url:"${APP_PATH}/emp/"+id,
                type:"GET",
                success:function(result){
                    var empData = result.extend.emp;
                    $("#empName_update_static").text(empData.empName);
                    $("#email_update_input").val(empData.email);
                    $("#empUpdateModal input[name=gender]").val([empData.gender]);
                    //console.log(empData.gender);
                    $("#empUpdateModal select").val([empData.dId]);
                }
            });
        }

        //点击更新，更新员工信息
        $("#emp_update_btn").click(function () {
            //验证邮箱是否合法
            //1、校验邮箱信息
            var email = $("#email_update_input").val();
            var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
            if(!regEmail.test(email)){
                show_validate_msg("#email_update_input", "error", "邮箱格式不正确");
                return false;
            }else{
                show_validate_msg("#email_update_input", "success", "");
            }
            //2、发送ajax请求保存更新的员工数据
            $.ajax({
                url:"${APP_PATH}/updateemp/"+$(this).attr("edit-id"),
                type:"GET",
                data:$("#empUpdateModal form").serialize(),
                success:function (result) {
                    //1、关闭对话框
                    $("#empUpdateModal").modal("hide");
                    //2、回到本页面
                    to_page(currentPage);
                }
            })
        })

        //单个删除
        $(document).on("click",".delete_btn",function (){
            //弹出是否确认删除的对话框
            var empName=$(this).parents("tr").find("td:eq(2)").text();
            //console.log(empName);
            var empId=$(this).attr("del-id");
            if(confirm("确定要删【"+empName+"】除吗？")){
                //确认，发送ajax请求删除即可
                $.ajax({
                    url:"${APP_PATH}/emp/"+empId,
                    type:"DELETE",
                    success:function (result) {
                        alert(result.msg);
                        //回到本页
                        to_page(currentPage);
                    }
                })
            }
        });

        //完成全选，全不选的功能
        $("#check_all").click(function () {
            //attr获取checked是undefined；
            //prop获取是我们dom原生的属性；attr获取自定义属性的值
            //prop修改和读取dom原生属性的值
            $(".check_item").prop("checked",$(this).prop("checked"));
        });
        //checked_item
        $(document).on("click",".check_item",function () {
            var flag=$(".check_item:checked").length==$(".check_item").length;
            $("#check_all").prop("checked",flag);
        });

        //点击全部删除，执行批量删除
        $("#emp_delete_all_btn").click(function () {
            var empNames="";
            var del_idstr="";
            $.each($(".check_item:checked"),function () {
                empNames += $(this).parents("tr").find("td:eq(2)").text()+",";
                del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";
            })
            empNames=empNames.substring(0,empNames.length-1);
            del_idstr=del_idstr.substring(0,del_idstr.length-1);
            if(confirm("你确定要删除【"+empNames+"】吗？")){
                   $.ajax({
                       url:"${APP_PATH}/emp/"+del_idstr,
                       type:"delete",
                       success:function (result) {
                           alert(result.msg);
                           to_page(currentPage);
                       }
                   })
            }
        })
    </script>

</body>
</body>
</html>
