package edu.ijse.gdse41.dominos.TableModel;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by SHEHANKA on 6/2/2017.
 */
public class ViewAllOrderTableModel {

    private SimpleStringProperty order_Id=new SimpleStringProperty("");
    private SimpleStringProperty customer_Id=new SimpleStringProperty("");
    private SimpleStringProperty customer_Name=new SimpleStringProperty("");
    private SimpleStringProperty order_Date=new SimpleStringProperty("");
    private SimpleDoubleProperty order_Price=new SimpleDoubleProperty(0.0);
    private SimpleStringProperty order_Status=new SimpleStringProperty("");

    public ViewAllOrderTableModel(SimpleStringProperty order_Id, SimpleStringProperty customer_Id, SimpleStringProperty customer_Name, SimpleStringProperty order_Date, SimpleDoubleProperty order_Price, SimpleStringProperty order_Status) {
        this.order_Id = order_Id;
        this.customer_Id = customer_Id;
        this.customer_Name = customer_Name;
        this.order_Date = order_Date;
        this.order_Price = order_Price;
        this.order_Status = order_Status;
    }

    public ViewAllOrderTableModel() {

    }

    public String getOrder_Id() {
        return order_Id.get();
    }

    public SimpleStringProperty order_IdProperty() {
        return order_Id;
    }

    public void setOrder_Id(String order_Id) {
        this.order_Id.set(order_Id);
    }

    public String getCustomer_Id() {
        return customer_Id.get();
    }

    public SimpleStringProperty customer_IdProperty() {
        return customer_Id;
    }

    public void setCustomer_Id(String customer_Id) {
        this.customer_Id.set(customer_Id);
    }

    public String getCustomer_Name() {
        return customer_Name.get();
    }

    public SimpleStringProperty customer_NameProperty() {
        return customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name.set(customer_Name);
    }

    public String getOrder_Date() {
        return order_Date.get();
    }

    public SimpleStringProperty order_DateProperty() {
        return order_Date;
    }

    public void setOrder_Date(String order_Date) {
        this.order_Date.set(order_Date);
    }

    public double getOrder_Price() {
        return order_Price.get();
    }

    public SimpleDoubleProperty order_PriceProperty() {
        return order_Price;
    }

    public void setOrder_Price(double order_Price) {
        this.order_Price.set(order_Price);
    }

    public String getOrder_Status() {
        return order_Status.get();
    }

    public SimpleStringProperty order_StatusProperty() {
        return order_Status;
    }

    public void setOrder_Status(String order_Status) {
        this.order_Status.set(order_Status);
    }
}
