/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.model;

/**
 *
 * @author SHEHANKA
 */
public class OrderDetail {
    private String order_Id;
    private String item_Code;
    private int item_Qty;
    private double item_UnitPrice;

    public OrderDetail() {
    }

    public OrderDetail(String order_Id, String item_Code, int item_Qty, double item_UnitPrice) {
        this.order_Id = order_Id;
        this.item_Code = item_Code;
        this.item_Qty = item_Qty;
        this.item_UnitPrice = item_UnitPrice;
    }

    /**
     * @return the order_Id
     */
    public String getOrder_Id() {
        return order_Id;
    }

    /**
     * @param order_Id the order_Id to set
     */
    public void setOrder_Id(String order_Id) {
        this.order_Id = order_Id;
    }

    /**
     * @return the item_Code
     */
    public String getItem_Code() {
        return item_Code;
    }

    /**
     * @param item_Code the item_Code to set
     */
    public void setItem_Code(String item_Code) {
        this.item_Code = item_Code;
    }

    /**
     * @return the item_Qty
     */
    public int getItem_Qty() {
        return item_Qty;
    }

    /**
     * @param item_Qty the item_Qty to set
     */
    public void setItem_Qty(int item_Qty) {
        this.item_Qty = item_Qty;
    }

    /**
     * @return the item_UnitPrice
     */
    public double getItem_UnitPrice() {
        return item_UnitPrice;
    }

    /**
     * @param item_UnitPrice the item_UnitPrice to set
     */
    public void setItem_UnitPrice(double item_UnitPrice) {
        this.item_UnitPrice = item_UnitPrice;
    }
    
    
    
    
    
}
