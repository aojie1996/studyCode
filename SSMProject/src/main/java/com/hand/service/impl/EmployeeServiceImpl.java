package com.hand.service.impl;

import com.hand.dao.EmployeeMapper;
import com.hand.entity.Employee;
import com.hand.entity.EmployeeExample;
import com.hand.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    public List<Employee> getAll() {
        return employeeMapper.selectByExampleWithDept(null);
    }

    //保存部门员工的方法
    public void saveEmp(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    //按照员工id查询员工
    public Employee getEmp(Integer id) {
        Employee employee=employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public void deleteEmp(int id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> del_ids) {
        EmployeeExample example = new EmployeeExample();//按照条件删除
        EmployeeExample.Criteria criteria = example.createCriteria();
        //delete from xxx where emp_id in(1,2,3)
        criteria.andEmpIdIn(del_ids);
        employeeMapper.deleteByExample(example);
    }

    public boolean checkUser(String empName) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long a=employeeMapper.countByExample(example);
        return a==0;
    }
}
