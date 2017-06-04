/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.TableModel;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author SHEHANKA
 */
public class OrderTableModel {
    private SimpleStringProperty item_Code = new SimpleStringProperty("");
    private SimpleStringProperty item_Description = new SimpleStringProperty("");
    private SimpleDoubleProperty item_Price = new SimpleDoubleProperty(0.0);
    private SimpleIntegerProperty item_Qty = new SimpleIntegerProperty(0);
    private SimpleDoubleProperty amount =new SimpleDoubleProperty(0.0);

    public OrderTableModel() {
    }

    /**
     * @return the item_Code
     */
    public String getItem_Code() {
        return item_Code.get();
    }

    /**
     * @param item_Code the item_Code to set
     */
    public void setItem_Code(String item_Code) {
        this.item_Code.set(item_Code);
    }

    /**
     * @return the item_Description
     */
    public String getItem_Description() {
        return item_Description.get();
    }

    /**
     * @param item_Description the item_Description to set
     */
    public void setItem_Description(String item_Description) {
        this.item_Description.set(item_Description);
    }

    /**
     * @return the item_Price
     */
    public double getItem_Price() {
        return item_Price.get();
    }

    /**
     * @param item_Price the item_Price to set
     */
    public void setItem_Price(double item_Price) {
        this.item_Price.set(item_Price);
    }

    /**
     * @return the item_Qty
     */
    public int getItem_Qty() {
        return item_Qty.get();
    }

    /**
     * @param item_Qty the item_Qty to set
     */
    public void setItem_Qty(int item_Qty) {
        this.item_Qty.set(item_Qty);
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount.get();
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount.set(amount);
    }
    
    
}
