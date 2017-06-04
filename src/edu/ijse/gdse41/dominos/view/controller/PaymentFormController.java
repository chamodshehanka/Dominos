/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.view.controller;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author SHEHANKA
 */
public class PaymentFormController implements Initializable {

    @FXML
    private JFXTextField txtPID;

    @FXML
    private JFXTextField txtSubTotal;

    @FXML
    private JFXComboBox cbxDiscount;

    @FXML
    private JFXTextField txtTotal;

    @FXML
    private JFXTextField txtCash;

    @FXML
    private Text lblBalance;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private AnchorPane rootPayment;
    
    private String order_Id;
    
    private String subTotal="";

    private double discountAmount;

    private String order_Date;

    private String customer_Id;

    private int order_Discount;

    private String order_Status;

    @FXML
    private JFXTextField textorderID;

    private ArrayList<OrderDetail> orderDetailList=new ArrayList<>();
    
    public void setText(String order_Price, String order_Id, String order_Date, String customer_Id, ArrayList<OrderDetail> orderDetailList) {
        txtSubTotal.setText(order_Price);
        this.subTotal=order_Price;

        this.order_Id=order_Id;
        this.order_Date=order_Date;
        this.customer_Id=customer_Id;
        this.orderDetailList=orderDetailList;
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idGenerator();
        txtSubTotal.setText(subTotal);
        comboBoxDiscount();
        cbxDiscount.requestFocus();
        order_Status ="Paid";
    } 
    
    public void setDiscountPrice() {
        double total=Double.parseDouble(txtSubTotal.getText());
        String discountPercentage = (String) cbxDiscount.getValue();
        order_Discount= Integer.parseInt(discountPercentage);
        System.out.println(discountPercentage);
        double discountValue= Double.parseDouble(discountPercentage);
        discountAmount =(total * discountValue)/100;

        txtTotal.setText(""+(total-discountAmount));
    }

    private void comboBoxDiscount(){
        cbxDiscount.getItems().addAll("0","5","10","20","50");
    }

    public void setBalance(){
        double cash= Double.parseDouble(txtCash.getText());
        lblBalance.setText(String.valueOf(cash-Double.parseDouble(txtTotal.getText())));
    }

    @FXML
    private void  addNewOrder(){
        try {
            Order order=new Order(order_Id,order_Date,customer_Id,order_Discount,order_Status,orderDetailList);
            String payment_Id=txtPID.getText();
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
                        alert.setContentText("Order has being added sucessfully!!");
                        alert.showAndWait();
                    }
                    System.out.println("Added Success");
                }
            }catch(SQLException e){
                e.printStackTrace();
            }catch(ClassNotFoundException e){
                System.out.println(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void idGenerator(){
        try {
            txtPID.setText(edu.ijse.gdse41.dominos.other.IDGenarator.getNewID("payment","PID","P"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
