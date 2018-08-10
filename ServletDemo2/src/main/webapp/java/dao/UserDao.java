package dao;

import impl.ImpDao;
import util.ConnDB;

import java.sql.*;

public class UserDao implements ImpDao{
    private Connection ct = null;
    private Statement sm = null;
    private ResultSet rs = null;
    private PreparedStatement ps=null;
    @Override
    public boolean checkuser(String username, String password) {
        boolean b= false;
        ct= new ConnDB().getconn();
        try {
            sm=ct.createStatement();
            rs = sm.executeQuery("select passwd from userTab where username='"+username+"'");
            if (rs.next()){
                if (rs.getString(1).equals(password)){
                    b=true;
                }
                System.out.println(rs.getString(1));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return b;
    }

    //关闭的方法
    public void close() {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (sm != null) {
                sm.close();
                sm = null;
            }
            if (ct != null) {
                ct.close();
                ct = null;
            }
            if (ps != null) {
                ps.close();
                ps = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
