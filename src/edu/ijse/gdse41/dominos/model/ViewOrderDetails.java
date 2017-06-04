package edu.ijse.gdse41.dominos.model;

/**
 * Created by SHEHANKA on 6/2/2017.
 */
public class ViewOrderDetails {
    private String item_Code;
    private String item_Description;
    private int item_Qty;
    private double unit_Price;

    public ViewOrderDetails(String item_Code, String item_Description, int item_Qty, double unit_Price) {
        this.item_Code = item_Code;
        this.item_Description = item_Description;
        this.item_Qty = item_Qty;
        this.unit_Price = unit_Price;
    }

    public String getItem_Code() {
        return item_Code;
    }

    public void setItem_Code(String item_Code) {
        this.item_Code = item_Code;
    }

    public String getItem_Description() {
        return item_Description;
    }

    public void setItem_Description(String item_Description) {
        this.item_Description = item_Description;
    }

    public int getItem_Qty() {
        return item_Qty;
    }

    public void setItem_Qty(int item_Qty) {
        this.item_Qty = item_Qty;
    }

    public double getUnit_Price() {
        return unit_Price;
    }

    public void setUnit_Price(double unit_Price) {
        this.unit_Price = unit_Price;
    }
}
