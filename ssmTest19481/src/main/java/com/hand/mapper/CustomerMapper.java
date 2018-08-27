package com.hand.mapper;

import com.hand.dto.Customer;

import java.util.List;

public interface CustomerMapper {
    Customer selectByfirstName(String firstName);

    List<Customer> selectCustomerList();

    void insertCust(Customer customer);

    Customer selectById(Integer id);

    int updateById(Customer customer);

    int deleteCustById(Integer id);
}
