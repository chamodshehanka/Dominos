/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import edu.ijse.gdse41.dominos.DBController.LoginController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author SHEHANKA
 */
public class LoginFormController implements Initializable {

    @FXML
    private AnchorPane rootLogin;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private JFXButton btnLogin;

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
    public void btnLoginAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
        String userName=txtUserName.getText();
        String password=txtPassword.getText();
        boolean bool=LoginController.Login(userName, password);
        
        try {
            AnchorPane mainMenu = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/MainMenu.fxml")));
            AnchorPane mainMenuAdmin = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/MainMenuAdmin.fxml")));
            if(bool){ 
               
                boolean type=LoginController.AccountType(userName);
               if(type){
                rootLogin.getChildren().setAll(mainMenuAdmin);
               }else{
                rootLogin.getChildren().setAll(mainMenu);
               }
           }else{
               Alert alert=new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Login Error!");
               alert.setHeaderText("Login Failed!");
               alert.setContentText("Username/Password does not match");
               
               alert.showAndWait();
               System.out.println("Wrong login details");
           }  
        } catch (IOException ex) {
            Logger.getLogger(LoginFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
    }
    
}
