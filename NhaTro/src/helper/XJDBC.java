/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Admin
 */
public class XJDBC {

    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://localhost;database=NHATRO";
    static String username = "sa";
    static String password = "19216811";
    
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static PreparedStatement preparestatement(String sql, Object...args) throws SQLException{
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement ppsm;
        if(sql.trim().startsWith("{")){
            ppsm = con.prepareCall(sql);
        }
        else{
            ppsm = con.prepareStatement(sql);
        }
        for(int i = 0; i < args.length; i++){
            ppsm.setObject(i+1, args[i]);
        }
        return ppsm;
    }
    
    public static int update(String sql,Object...args ){
        try {
            PreparedStatement ppsm = XJDBC.preparestatement(sql, args);
            try {
                return ppsm.executeUpdate();
            } finally {
                ppsm.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static ResultSet query(String sql, Object...args) throws SQLException {
            PreparedStatement ppsm = preparestatement(sql, args);
            return ppsm.executeQuery();
    }
}
