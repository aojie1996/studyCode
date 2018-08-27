package com.hand.controller;

import com.hand.entity.Department;
import com.hand.entity.Msg;
import com.hand.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 处理部门相关的请求
 */

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        //查询出部门所有信息
        List<Department> list =departmentService.getDepts();
        return Msg.success().add("depts",list);
    }

}
