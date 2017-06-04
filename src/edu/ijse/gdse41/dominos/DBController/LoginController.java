/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.DBController;
import java.sql.Connection;
import java.sql.SQLException;
import edu.ijse.gdse41.dominos.DB.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author SHEHANKA
 */
public class LoginController {
    public static boolean Login(String userName, String password) throws SQLException, ClassNotFoundException {
        String SQL = "SELECT * FROM login WHERE LName=?";
        
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, userName);
        ResultSet rst = stm.executeQuery(); 
        if (rst.next()) {
            if(!rst.getString(1).equals(userName)){
                return false;
            }
            String pwd = rst.getString(2);
            if (pwd.equals(password)) {
                return true;
            }
        }
        return false;
      
    }
    
    public static boolean AccountType(String userName)throws ClassNotFoundException,SQLException{
        String SQL = "SELECT * FROM login WHERE LName=?";
        String LType = "admin";
        
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, userName);
        ResultSet rst = stm.executeQuery();
        
        if(rst.next()){
            String type = rst.getString(3);
            if(type.equals(LType)){
                return true;
            }
        }
        return false;
    }
    
}
