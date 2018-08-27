package com.hand.service;

import com.hand.dto.Customer;
import com.hand.dto.Msg;

import java.util.List;

public interface CustomerService {
    Customer getCustomer(String firstName);

    List<Customer> selectCustomer();

    void saveCust(Customer customer);

    Customer getCusById(Integer id);

    void updateCus(Customer customer);

    Msg deleteCust(Integer id);
}
