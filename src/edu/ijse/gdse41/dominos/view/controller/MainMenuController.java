/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.view.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author SHEHANKA
 */
public class MainMenuController implements Initializable {

    @FXML
    private JFXButton btnLogOut;
    @FXML
    private JFXButton btnManageCustomer;
    @FXML
    private JFXButton btnPendingOrders;
    @FXML
    private AnchorPane rootMainMenu;

    @FXML
    private JFXButton btnAllOrders;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void btnManageCustomer(ActionEvent actionEvent){
        try {
            AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/CustomerForm.fxml")));
            rootMainMenu.getChildren().setAll(parentContent);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void btnMakeOrder(ActionEvent actionEvent){
        try {
            AnchorPane orderForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/OrderForm.fxml")));
            rootMainMenu.getChildren().setAll(orderForm);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void btnLogOut(ActionEvent actionEvent){
       try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/LoginForm.fxml")));
            rootMainMenu.getChildren().setAll(loginForm);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void btnPendingOrders(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/PendingOrdersForm.fxml")));
            rootMainMenu.getChildren().setAll(loginForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void setBtnViewAllOrders(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/ViewAllOrderForm.fxml")));
            rootMainMenu.getChildren().setAll(loginForm);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
