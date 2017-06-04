/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.DBController;

import edu.ijse.gdse41.dominos.DB.DBConnection;

import edu.ijse.gdse41.dominos.model.Customer;
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
public class CustomerController {
    public static int addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        String sql = "Insert into Customer values(?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, customer.getCustomer_Id());
        stm.setObject(2, customer.getCustomer_Name());
        stm.setObject(3, customer.getCustomer_TpNo());
        stm.setObject(4, customer.getCustomer_Address());
        
        return  stm.executeUpdate();
        
    }
    public static Customer searchCustomer(String customer_Id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Customer WHERE CID = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, customer_Id);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Customer c=new Customer(rst.getString(1),rst.getString(2),rst.getInt(3), rst.getString(4));
            return c;
        }
        return null;
    }
    public static int updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
    String sql = "UPDATE Customer SET CID= ? ,CName= ? ,TPNo= ? ,Address= ? WHERE CID= ? ";    
    Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, customer.getCustomer_Id());
        stm.setObject(2, customer.getCustomer_Name());
        stm.setObject(3, customer.getCustomer_TpNo());
        stm.setObject(4, customer.getCustomer_Address());   
    return  stm.executeUpdate();
    }
    public static int deleteCustomer(String customer_Id) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM Customer WHERE CID='"+customer_Id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        
       return  stm.executeUpdate();
        
    }
    
    
    
    public static ArrayList<Customer> getAllCustomer() throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select * From Customer");
        ArrayList<Customer>customerList=new ArrayList<>();
        while(rst.next()){
            Customer customer;
            customer = new Customer(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getString(4));
            customerList.add(customer);
        }
        return customerList;
    }
 
}
