package com.hand.service;

import com.hand.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    void saveEmp(Employee employee);

    Employee getEmp(Integer id);

    void updateEmp(Employee employee);

    void deleteEmp(int id);

    void deleteBatch(List<Integer> del_ids);

    boolean checkUser(String empName);
}
