package test;

import dao.UserMappering;
import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import util.SqlSessionFactoryUtil;

import java.io.Reader;
import java.util.List;

/**
 * 利用mybatis实现单表的增删改查
 */
public class Test {

    public static void main(String[] args) {
        SqlSession session = SqlSessionFactoryUtil.getSession();
        try {
            //User user = (User) session.selectOne("dao.UserMappering.selectUserByID", 1);
            /**
             * 实现查询操作
             */
//            UserMappering userMappering= session.getMapper(UserMappering.class);
//            List<User> usersList = userMappering.selectUsers("summer");
//            for (User user: usersList){
//                System.out.println(user.getId()+"\t"+user.getUserName()+"\t"+user.getUserAge()+"\t"+user.getUserAddress());
//            }
            /**
             * 实现添加操作
             */
//            UserMappering userMappering = session.getMapper(UserMappering.class);
//            User user = new User();
//            user.setUserAddress("人民广场");
//            user.setUserName("飞鸟");
//            user.setUserAge(80);
//            userMappering.addUser(user);
//            session.commit();
//            System.out.println("新增人员的id为："+user.getId());
            /**
             * 实现更新操作
             */
//            UserMappering userMappering =session.getMapper(UserMappering.class);
//            User user = userMappering.selectUserByID(1);
//            user.setUserAddress("上海青浦");
//            userMappering.updateUser(user);
//            session.commit();

            /**
             * 实现删除操作
             */
//            UserMappering userMappering =session.getMapper(UserMappering.class);
//            userMappering.deleteUser(2);
//            session.commit();

        } finally {
            session.close();
        }

    }

}
