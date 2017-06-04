package edu.ijse.gdse41.dominos.view.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import edu.ijse.gdse41.dominos.DBController.UserController;
import edu.ijse.gdse41.dominos.TableModel.UserTableModel;
import edu.ijse.gdse41.dominos.model.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by SHEHANKA on 5/29/2017.
 */
public class UserFormController implements Initializable {

    @FXML
    private AnchorPane rootUser;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXComboBox cbxType;

    @FXML
    private TableView tblUser;

    @FXML
    private TableColumn tblUserName;

    @FXML
    private TableColumn tblUserType;

    private final ObservableList<UserTableModel> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxType();

        try {
            tblUserName.setCellValueFactory(new PropertyValueFactory<UserTableModel,String>("user_Name"));
            tblUserType.setCellValueFactory(new PropertyValueFactory<UserTableModel,String>("user_Type"));

            tblUser.setItems(data);
            ArrayList<Users> users=null;
            users = UserController.getAllUsers();
            for (Users user:users) {
                UserTableModel ctm=new UserTableModel();
                ctm.setUser_Name(user.getUser_Name());
                ctm.setUser_Type(user.getUser_Type());
                data.add(ctm);
            }
        }catch (ClassNotFoundException|SQLException ex){
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addUser(ActionEvent event) {

    }

    @FXML
    private void deleteUser(ActionEvent event) {

    }

    @FXML
    private void searchUser(ActionEvent event) {

    }

    @FXML
    private void updateUser(ActionEvent event) {

    }

    private void comboBoxType(){
        cbxType.getItems().addAll("admin","other");
    }

    @FXML
    private void btnMainMenu(ActionEvent actionEvent){
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/MainMenuAdmin.fxml")));
            rootUser.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void btnLogOut(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/LoginForm.fxml")));
            rootUser.getChildren().setAll(loginForm);
        }catch(IOException e){
            System.out.println(e);
        }
    }

}
