package com.hand.service.impl;

import com.hand.dto.Address;
import com.hand.mapper.AddressMapper;
import com.hand.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;

    //查询出所有的地址的信息
    @Override
    public List<Address> getAddress(){
        List<Address> list=addressMapper.selectAllAddress();
        return list;
    }

}
