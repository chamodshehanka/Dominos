/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.view.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.ijse.gdse41.dominos.DBController.OrderController;
import edu.ijse.gdse41.dominos.DBController.PaymentController;
import edu.ijse.gdse41.dominos.model.Order;
import edu.ijse.gdse41.dominos.model.OrderDetail;
import edu.ijse.gdse41.dominos.model.Payment;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author SHEHANKA
 */



public class DeliveryFormController implements Initializable {

    @FXML
    private JFXTextField txtOID;

    @FXML
    private JFXComboBox cbxDeliverers;

    @FXML
    private JFXComboBox cbxDiscount;

    @FXML
    private JFXTextField txtPID;

    @FXML
    private JFXTextField txtTotal;

    @FXML
    private JFXTextField txtSubTotal;

    private String order_Status;

    private String order_Id;

    private String order_Date;

    private String customer_Id;

    private int order_Discount;

    private String sub_Total;

    private double discountAmount;

    private ArrayList<OrderDetail> orderDetailList=new ArrayList<>();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxDeliver();
        comboBoxDiscount();
        order_Status="Pending";
        txtOID.setText(order_Id);
        order_Discount=0;
        idGenerator();
        txtSubTotal.setText(sub_Total);
    }

    private void comboBoxDeliver(){
        cbxDeliverers.getItems().addAll("D001","D002","D003","D004","D005");
    }

    @FXML
    private void addDeliveryOrder(){
        try {
            Order order=new Order(order_Id,order_Date,customer_Id,order_Discount,order_Status,orderDetailList);
            String payment_Id=txtOID.getText();
            Double order_Price= Double.valueOf(txtTotal.getText());
            Payment payment=new Payment(payment_Id,order_Id,order_Price,order_Discount);
            try{
                boolean isAdded= OrderController.addNewOrder(order);
                if(isAdded){
                    int i= PaymentController.addNewPayment(payment);
                    if(i>0){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        //
                        DialogPane dialogPane = alert.getDialogPane();
                        dialogPane.getStylesheets().add(
                                getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/DialogStyle.css").toExternalForm());
                        dialogPane.getStyleClass().add("myDialog");
                        //
                        alert.setTitle("Added Success");
                        alert.setHeaderText("This is an infomation dialog");
                        alert.setContentText("Order has being added sucessfully to Pending Orders");
                        alert.showAndWait();
                    }
                    System.out.println("Added Success ");
                }
            }catch(SQLException e){
                e.printStackTrace();
            }catch(ClassNotFoundException e){
               e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setText(String order_Price, String order_Id, String order_Date, String customer_Id, ArrayList<OrderDetail> orderDetailList) {
        System.out.println(order_Price);
        this.order_Id=order_Id;
        this.order_Date=order_Date;
        this.customer_Id=customer_Id;
        this.orderDetailList=orderDetailList;
        txtSubTotal.setText(order_Price);
    }

    public void setDiscountPrice() {
        double total=Double.parseDouble(txtSubTotal.getText());
        String discountPercentage = (String) cbxDiscount.getValue();
        order_Discount= Integer.parseInt(discountPercentage);
        double discountValue= Double.parseDouble(discountPercentage);
        discountAmount =(total * discountValue)/100;

        txtTotal.setText(""+(total-discountAmount));
    }
    private void comboBoxDiscount(){
        cbxDiscount.getItems().addAll("0","5","10","20","50");
    }

    private void idGenerator(){
        try {
            txtOID.setText(edu.ijse.gdse41.dominos.other.IDGenarator.getNewID("payment","PID","P"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
