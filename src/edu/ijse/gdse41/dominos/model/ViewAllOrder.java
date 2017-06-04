package edu.ijse.gdse41.dominos.model;

/**
 * Created by SHEHANKA on 6/2/2017.
 */
public class ViewAllOrder {
    private String order_Id;
    private String customer_Id;
    private String customer_Name;
    private String order_Date;
    private double order_Price;
    private String order_Status;

    public ViewAllOrder(String order_Id, String customer_Id, String customer_Name, String order_Date, double order_Price, String order_Status) {
        this.order_Id = order_Id;
        this.customer_Id = customer_Id;
        this.customer_Name = customer_Name;
        this.order_Date = order_Date;
        this.order_Price = order_Price;
        this.order_Status = order_Status;
    }

    public String getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(String order_Id) {
        this.order_Id = order_Id;
    }

    public String getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(String customer_Id) {
        this.customer_Id = customer_Id;
    }

    public String getCustomer_Name() {
        return customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    public String getOrder_Date() {
        return order_Date;
    }

    public void setOrder_Date(String order_Date) {
        this.order_Date = order_Date;
    }

    public double getOrder_Price() {
        return order_Price;
    }

    public void setOrder_Price(double order_Price) {
        this.order_Price = order_Price;
    }

    public String getOrder_Status() {
        return order_Status;
    }

    public void setOrder_Status(String order_Status) {
        this.order_Status = order_Status;
    }
}
