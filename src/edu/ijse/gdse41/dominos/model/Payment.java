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
public class Payment {
    private String payment_Id;
    private String order_Id;
    private double payment_Price;
    private int payment_Discount;

    public Payment() {
    }

    public Payment(String payment_Id, String order_Id, double payment_Price, int payment_Discount) {
        this.payment_Id = payment_Id;
        this.order_Id = order_Id;
        this.payment_Price = payment_Price;
        this.payment_Discount = payment_Discount;
    }

    public String getPayment_Id() {
        return payment_Id;
    }

    public void setPayment_Id(String payment_Id) {
        this.payment_Id = payment_Id;
    }

    public String getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(String order_Id) {
        this.order_Id = order_Id;
    }

    public double getPayment_Price() {
        return payment_Price;
    }

    public void setPayment_Price(double payment_Price) {
        this.payment_Price = payment_Price;
    }

    public int getPayment_Discount() {
        return payment_Discount;
    }

    public void setPayment_Discount(int payment_Discount) {
        this.payment_Discount = payment_Discount;
    }
}
