package com.hand.test;

import com.hand.dao.impl.UserdaoImpl;
import com.hand.entity.User;
import com.hand.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class selectTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext= ApplicationContextUtil.getApplicationContext();
        UserdaoImpl userdao =
                (UserdaoImpl)applicationContext.getBean("userDAOImplTemplate");
        //给id值查找对应的信息
//        User user=userdao.findByIdByJdbcTemlate(1);
//        System.out.println(user.getId()+"\t"+user.getUserName()+"\t"+user.getUserAge()+"\t"+user.getUserAddress());
          //查找表中所用信息
//        List<User> list=userdao.findAll();
//        for (User user:list){
//            System.out.println(user.getId()+"\t"+user.getUserName()+"\t"+user.getUserAge()+"\t"+user.getUserAddress());
//        }

        //修改方法调用
//        User user = new User(3,"curry","30","American");
//        if (userdao.updateUser(user)==1){
//            System.out.println("修改成功");
//        }else{
//            System.out.println("修改失败");
//        }

        //删除方法调用
         if (userdao.deleteUser(4)==1){
             System.out.println("删除成功");
         }else{
             System.out.println("删除失败");
         };
    }
}
