package edu.ijse.gdse41.dominos.model;

/**
 * Created by SHEHANKA on 5/31/2017.
 */
public class PendingOrder {

    private String order_Id;
    private String custmer_Name;
    private double order_Price;

    public PendingOrder(String order_Id, String custmer_Name, double order_Price) {
        this.order_Id = order_Id;
        this.custmer_Name = custmer_Name;
        this.order_Price = order_Price;
    }

    public String getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(String order_Id) {
        this.order_Id = order_Id;
    }

    public String getCustmer_Name() {
        return custmer_Name;
    }

    public void setCustmer_Name(String custmer_Name) {
        this.custmer_Name = custmer_Name;
    }

    public double getOrder_Price() {
        return order_Price;
    }

    public void setOrder_Price(double order_Price) {
        this.order_Price = order_Price;
    }
}
