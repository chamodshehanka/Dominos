package edu.ijse.gdse41.dominos.TableModel;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by SHEHANKA on 6/2/2017.
 */
public class ViewOrderDetailsTableModel {
    private SimpleStringProperty item_Code=new SimpleStringProperty("");
    private SimpleStringProperty item_Description=new SimpleStringProperty("");
    private SimpleIntegerProperty item_Qty=new SimpleIntegerProperty(0);
    private SimpleDoubleProperty unit_Price=new SimpleDoubleProperty(0.0);

    public ViewOrderDetailsTableModel(SimpleStringProperty item_Code, SimpleStringProperty item_Description, SimpleIntegerProperty item_Qty, SimpleDoubleProperty unit_Price) {
        this.item_Code = item_Code;
        this.item_Description = item_Description;
        this.item_Qty = item_Qty;
        this.unit_Price = unit_Price;
    }

    public ViewOrderDetailsTableModel() {

    }

    public String getItem_Code() {
        return item_Code.get();
    }

    public SimpleStringProperty item_CodeProperty() {
        return item_Code;
    }

    public void setItem_Code(String item_Code) {
        this.item_Code.set(item_Code);
    }

    public String getItem_Description() {
        return item_Description.get();
    }

    public SimpleStringProperty item_DescriptionProperty() {
        return item_Description;
    }

    public void setItem_Description(String item_Description) {
        this.item_Description.set(item_Description);
    }

    public int getItem_Qty() {
        return item_Qty.get();
    }

    public SimpleIntegerProperty item_QtyProperty() {
        return item_Qty;
    }

    public void setItem_Qty(int item_Qty) {
        this.item_Qty.set(item_Qty);
    }

    public double getUnit_Price() {
        return unit_Price.get();
    }

    public SimpleDoubleProperty unit_PriceProperty() {
        return unit_Price;
    }

    public void setUnit_Price(double unit_Price) {
        this.unit_Price.set(unit_Price);
    }
}
