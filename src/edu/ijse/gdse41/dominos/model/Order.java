/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.model;

import java.util.ArrayList;

/**
 *
 * @author SHEHANKA
 */
public class Order {
    private String order_Id;
    private String order_Date;
    private String customer_Id;
    private int order_Discount;
    private String order_Status;

    private ArrayList order_DetailList;

    public  Order(String order_Id, String order_Date, String customer_Id, int order_Discount, String order_Status, ArrayList<OrderDetail> orderDetailList) {
        this.order_Id=order_Id;
        this.order_Date=order_Date;
        this.customer_Id=customer_Id;
        this.order_Discount=order_Discount;
        this.order_Status=order_Status;
        this.order_DetailList=orderDetailList;
    }

    public Order(String order_id, String order_status) {
        this.order_Id=order_id;
        this.order_Status=order_status;
    }


    public String getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(String order_Id) {
        this.order_Id = order_Id;
    }

    public String getOrder_Date() {
        return order_Date;
    }

    public void setOrder_Date(String order_Date) {
        this.order_Date = order_Date;
    }

    public String getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(String customer_Id) {
        this.customer_Id = customer_Id;
    }

    public int getOrder_Discount() {
        return order_Discount;
    }

    public void setOrder_Discount(int order_Discount) {
        this.order_Discount = order_Discount;
    }

    public String getOrder_Status() {
        return order_Status;
    }

    public void setOrder_Status(String order_Status) {
        this.order_Status = order_Status;
    }

    public ArrayList getOrder_DetailList() {
        return order_DetailList;
    }

    public void setOrder_DetailList(ArrayList order_DetailList) {
        this.order_DetailList = order_DetailList;
    }
}
