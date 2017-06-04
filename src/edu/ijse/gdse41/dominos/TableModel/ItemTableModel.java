/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.TableModel;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author SHEHANKA
 */
public class ItemTableModel {
    private SimpleStringProperty item_Code = new SimpleStringProperty("");
    private SimpleStringProperty item_Description = new SimpleStringProperty("");
    private SimpleDoubleProperty item_UnitPrice = new SimpleDoubleProperty(0.0);
    private SimpleStringProperty item_Type = new SimpleStringProperty("");
    private SimpleStringProperty item_Image = new SimpleStringProperty("");

    public ItemTableModel() {
    }

    public String getItem_Code() {
        return item_Code.get();
    }

    public String getItem_Description() {
        return item_Description.get();
    }

    public double getItem_UnitPrice(){
        return item_UnitPrice.get();
    }
    
    public String getItem_Type(){
        return item_Type.get();
    }
    
    public String getItem_Image(){
        return item_Image.get();
    }
    
    public void setItem_Code(String item_Code) {
        this.item_Code.set(item_Code);
    }

    public void setItem_Description(String item_Description) {
        this.item_Description.set(item_Description);
    }
    
    public void setItem_UnitPrice(double item_UnitPrice) {
        this.item_UnitPrice.set(item_UnitPrice);
    }
    
    public void setItem_Type(String item_Type){
        this.item_Type.set(item_Type);
    }
    
    public void setItem_Image(String item_Image){
        this.item_Image.set(item_Image);
    }

}
