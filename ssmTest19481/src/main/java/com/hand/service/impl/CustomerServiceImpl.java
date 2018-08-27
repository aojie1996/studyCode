package com.hand.service.impl;

import com.hand.dto.Customer;
import com.hand.dto.Msg;
import com.hand.mapper.CustomerMapper;
import com.hand.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    //按照的firstName查询员工
    @Override
    public Customer getCustomer(String firstName) {
        Customer customer=customerMapper.selectByfirstName(firstName);
        return customer;
    }

    //查询出customer表中所有数据，返回list集合
    @Override
    public List<Customer> selectCustomer() {
        List<Customer> list=customerMapper.selectCustomerList();
        return list;
    }

    //新增客户的方法
    @Override
    public void saveCust(Customer customer) {
        customerMapper.insertCust(customer);
    }

    //根据id查询出员工数据
    @Override
    public Customer getCusById(Integer id) {
        Customer customer=customerMapper.selectById(id);
        return customer;
    }


    @Override
    public void updateCus(Customer customer) {
        int i=customerMapper.updateById(customer);
        if (i==1){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    //删除方法
    @Override
    public Msg deleteCust(Integer id) {
        Msg msg = new Msg();
        int i=0;
        try {
            i=customerMapper.deleteCustById(id);
            if (i==1){
                msg.setCode(100);
                msg.setMsg("删除成功");
            }
        }catch (Exception e){
            msg.setCode(300);
            msg.setMsg("该用户是关联用户，不能删除");
        }
        return msg;
    }


}
