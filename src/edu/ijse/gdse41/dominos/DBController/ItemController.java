/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.DBController;
import edu.ijse.gdse41.dominos.DB.DBConnection;

import edu.ijse.gdse41.dominos.model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author SHEHANKA
 */
public class ItemController {
    
    public static int addItem(Item item) throws ClassNotFoundException, SQLException {
        String sql = "Insert into Item values(?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, item.getItem_Code());
        stm.setObject(2, item.getItem_Description());
        stm.setObject(3, item.getItem_UnitPrice());
        stm.setObject(4, item.getItem_Type());
        stm.setObject(5, item.getItem_Image());
        
        return  stm.executeUpdate();
        
    }
    
    public static Item searchItem(String item_Code) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Item WHERE ICode = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, item_Code);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Item c=new Item(rst.getString(1),rst.getString(2),rst.getDouble(3),rst.getString(4),rst.getString(5));
            return c;
        }
        return null;
    }
    public static int updateItem(Item item) throws ClassNotFoundException, SQLException {
    String sql = "UPDATE Item SET ICode= ? ,Description= ? ,UnitPrice= ? ,ItemType=? ,ItemImage=? , WHERE ICode= ? ";    
    Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, item.getItem_Code());
        stm.setObject(2, item.getItem_Description());
        stm.setObject(3, item.getItem_UnitPrice());
        stm.setObject(4, item.getItem_Type());
        stm.setObject(5, item.getItem_Image()); 
    return  stm.executeUpdate();
    }
    public static int deleteItem(String item_Code) throws ClassNotFoundException, SQLException {
       
        String sql = "DELETE FROM Item WHERE ICode='"+item_Code+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        
        return  stm.executeUpdate();
        
    }
    
    
    
    public static ArrayList<Item> getAllItem() throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select * From Item");
        ArrayList<Item>itemList=new ArrayList<>();
        while(rst.next()){
            Item item;
            item = new Item(rst.getString(1),rst.getString(2),rst.getDouble(3),rst.getString(4),rst.getString(5));
            itemList.add(item);
        }
        return itemList;
    }

}
