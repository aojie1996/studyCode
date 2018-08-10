package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnDB {
    private Connection ct = null;
    public Connection getconn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/test";
            String user="root";
            String password="123456";
            ct = DriverManager.getConnection(url,user,password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ct;
    }
}
