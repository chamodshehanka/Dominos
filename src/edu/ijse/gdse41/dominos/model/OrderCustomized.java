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
public class OrderCustomized {
    
    private String item_Description;
    
    private String item_Image;

    public OrderCustomized() {
    }

    public OrderCustomized(String item_Description, String item_Image) {
        this.item_Description = item_Description;
        this.item_Image = item_Image;
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
