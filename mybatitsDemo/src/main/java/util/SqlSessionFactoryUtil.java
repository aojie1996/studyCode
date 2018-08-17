package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 会话工厂工具类
 */
public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSession getSession() {
        if(sqlSessionFactory==null){
            try {
                //建立SqlSessionFactory实例
                InputStream inputStream = Resources.getResourceAsStream("Configuration.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return sqlSessionFactory.openSession();
    }
}

