package com.hand.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.dto.Customer;
import com.hand.dto.Msg;
import com.hand.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 处理顾客的请求
 */
@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    /**
     * 删除员工
     */
    @RequestMapping(value = "/delete/{customerId}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteCus(@PathVariable("customerId") Integer id){
        Msg msg=customerService.deleteCust(id);
         return msg;
    }
    /**
     * 修改员工方法
     */
    @ResponseBody
    @RequestMapping("/updateCus/{customerId}")
    public Msg updateCus(@PathVariable("customerId") Integer id,Customer customer){
        customerService.updateCus(customer);
        return Msg.success();
    }
    /**
     * 查询对应id值的客户信息
     * 填充到修改框中去
     */
    @RequestMapping(value = "/getCus/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Msg getCus(@PathVariable("id") Integer id){
        Customer customer=customerService.getCusById(id);
        return Msg.success().add("cus",customer);
    }
    /**
     * 添加客户的方法
     */
    @RequestMapping(value="/addCustomer")
    @ResponseBody
    public Msg addCustomer(Customer customer){
        customerService.saveCust(customer);
        return Msg.success();
    }

    /**
     *得到customer表中的数据
     * 返回json数据
     */
     @RequestMapping("/clist")
     @ResponseBody
     public Msg getCustWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
         // 引入PageHelper分页插件
         // 在查询之前只需要调用，传入页码，以及每页的大小
         PageHelper.startPage(pn,10);
         // startPage后面紧跟的这个查询就是一个分页查询
         List<Customer> clist = customerService.selectCustomer();
         // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
         // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
         PageInfo page = new PageInfo(clist,3);
         return Msg.success().add("pageInfo", page);
     }



    /**
     * 用户登录处理
     */

    @RequestMapping(value = "/loginUser",method = RequestMethod.POST)
    @ResponseBody
    public Msg checkUser(@RequestBody Customer customer){
        String firstName=customer.getFirstName();
        Customer customer1=customerService.getCustomer(firstName);
        System.out.println(customer1.toString());
        if (customer==null){
            System.out.println("------------");
            return Msg.fail();
        }else if (customer1.getLastName().equals(customer.getLastName())){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }
}
