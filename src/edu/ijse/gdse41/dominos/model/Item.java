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
public class Item {
    private String item_Code;
    private String item_Description;
    private double item_UnitPrice;
    private String item_Type;
    private String item_Image;

    public Item() {
    }

    public Item(String item_Code, String item_Description, double item_UnitPrice, String item_Type, String item_Image) {
        this.item_Code = item_Code;
        this.item_Description = item_Description;
        this.item_UnitPrice = item_UnitPrice;
        this.item_Type = item_Type;
        this.item_Image = item_Image;
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
     * @return the item_Description
     */
    public String getItem_Description() {
        return item_Description;
    }

    /**
     * @param item_Description the item_Description to set
     */
    public void setItem_Description(String item_Description) {
        this.item_Description = item_Description;
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

    /**
     * @return the item_Type
     */
    public String getItem_Type() {
        return item_Type;
    }

    /**
     * @param item_Type the item_Type to set
     */
    public void setItem_Type(String item_Type) {
        this.item_Type = item_Type;
    }

    /**
     * @return the item_Image
     */
    public String getItem_Image() {
        return item_Image;
    }

    /**
     * @param item_Image the item_Image to set
     */
    public void setItem_Image(String item_Image) {
        this.item_Image = item_Image;
    }
    
    
   
    
}
