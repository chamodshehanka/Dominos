/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.DBController;

import edu.ijse.gdse41.dominos.DB.DBConnection;
import edu.ijse.gdse41.dominos.model.OrderCustomized;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SHEHANKA
 */
public class OrderCustomizedController {
    
    public static OrderCustomized searchItem(String item_Code) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Item WHERE ICode = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, item_Code);//System.out.println("db"+item_Code);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            OrderCustomized c;
            c = new OrderCustomized(rst.getString(2),rst.getString(3));
            return c;
        }
        return null;
    }
    
}
