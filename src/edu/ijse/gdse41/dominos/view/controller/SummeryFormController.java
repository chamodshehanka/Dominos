package edu.ijse.gdse41.dominos.view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by SHEHANKA on 5/29/2017.
 */
public class SummeryFormController implements Initializable {

    @FXML
    private AnchorPane rootSummeryForm;

    @FXML
    private JFXButton btnTopMovingItems;

    @FXML
    private JFXButton btnTopCustomers;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private JFXButton btnMainMenu;

    @FXML
    private JFXButton btnAllOrders;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void btnLogOut(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/LoginForm.fxml")));
            rootSummeryForm.getChildren().setAll(loginForm);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void btnMainMenu(ActionEvent event) {
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/MainMenuAdmin.fxml")));
            rootSummeryForm.getChildren().setAll(loginForm);
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    private void setBtnTopMovingItems(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/TopMovingItemForm.fxml")));
            rootSummeryForm.getChildren().setAll(loginForm);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void setBtnTopCustomers(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/TopBuyingCustomersForm.fxml")));
            rootSummeryForm.getChildren().setAll(loginForm);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void setBtnViewAllOrders(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/ViewAllOrderForm.fxml")));
            rootSummeryForm.getChildren().setAll(loginForm);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
