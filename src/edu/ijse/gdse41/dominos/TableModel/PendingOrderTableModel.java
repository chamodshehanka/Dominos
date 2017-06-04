package edu.ijse.gdse41.dominos.TableModel;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by SHEHANKA on 5/31/2017.
 */
public class PendingOrderTableModel {

    private SimpleStringProperty order_Id=new SimpleStringProperty("");
    private SimpleStringProperty customer_Name=new SimpleStringProperty("");
    private SimpleDoubleProperty order_Price=new SimpleDoubleProperty(0.0);

    public PendingOrderTableModel(SimpleStringProperty order_Id, SimpleStringProperty customer_Name, SimpleDoubleProperty order_Price) {
        this.order_Id = order_Id;
        this.customer_Name = customer_Name;
        this.order_Price = order_Price;
    }

    public PendingOrderTableModel() {

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

    public String getCustomer_Name() {
        return customer_Name.get();
    }

    public SimpleStringProperty customer_NameProperty() {
        return customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name.set(customer_Name);
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
}
