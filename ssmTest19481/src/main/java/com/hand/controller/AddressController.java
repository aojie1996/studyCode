package com.hand.controller;

import com.hand.dto.Address;
import com.hand.dto.Msg;
import com.hand.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AddressController {
    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/address")
    @ResponseBody
    public Msg getaddress(){
        List<Address> address = addressService.getAddress();
        return Msg.success().add("address",address);
    }

}
