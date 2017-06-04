/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.TableModel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Shehanka
 */
public class CustomerTableModel {

    private SimpleStringProperty customer_Id = new SimpleStringProperty("");
    private SimpleStringProperty customer_Name = new SimpleStringProperty("");
    private SimpleIntegerProperty customer_TpNo = new SimpleIntegerProperty(0);
    private SimpleStringProperty customer_Address = new SimpleStringProperty("");
    

    public CustomerTableModel() {
    }

    public String getCustomer_Id() {
        return customer_Id.get();
    }

    public String getCustomer_Name() {
        return customer_Name.get();
    }

    public int getCustomer_TpNo(){
        return customer_TpNo.get();
    }
    
    public String getCustomer_Address() {
        return customer_Address.get();
    }

   

    public void setCustomer_Id(String customer_Id) {
        this.customer_Id.set(customer_Id);
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name.set(customer_Name);
    }
    
    public void setCustomer_TpNo(int customer_TpNo) {
        this.customer_TpNo.set(customer_TpNo);
    }

    public void setCustomer_Address(String customer_Address) {
        this.customer_Address.set(customer_Address);
    }

//    public void setItem_Code(String item_Code) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public void setItem_Description(String item_Description) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public void setItem_UnitPrice(double item_UnitPrice) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    
}
