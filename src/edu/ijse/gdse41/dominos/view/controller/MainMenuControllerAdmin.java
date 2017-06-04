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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SHEHANKA
 */
public class MainMenuControllerAdmin implements Initializable {

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private JFXButton btnManageUsers;

    @FXML
    private JFXButton btnManageItems;

    @FXML
    private JFXButton btnSummery;

    @FXML
    private AnchorPane rootMainMenuAdmin;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }  
    
    @FXML
    private void setBtnManageUsers(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/UserForm.fxml")));
            rootMainMenuAdmin.getChildren().setAll(loginForm);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void setBtnManageItems(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/ItemForm.fxml")));
            rootMainMenuAdmin.getChildren().setAll(loginForm);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void setBtnSummery(ActionEvent actionEvent){
        AnchorPane fxmlForm = null;
        try {
            fxmlForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/SummeryForm.fxml")));
            rootMainMenuAdmin.getChildren().setAll(fxmlForm);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    @FXML
    private void btnLogOut(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/LoginForm.fxml")));
            rootMainMenuAdmin.getChildren().setAll(loginForm);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
}
