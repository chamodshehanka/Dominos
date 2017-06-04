/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.ijse.gdse41.dominos.DB.DBConnection;
import edu.ijse.gdse41.dominos.DBController.CustomerController;
import edu.ijse.gdse41.dominos.TableModel.CustomerTableModel;
import edu.ijse.gdse41.dominos.model.Customer;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author SHEHANKA
 */
public class CustomerFormController implements Initializable {
    @FXML
    private JFXTextField txtTPNo;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private TableView tblCustomer;
    @FXML
    private TableColumn tblCID;
    @FXML
    private TableColumn tblName;
    @FXML
    private TableColumn tblTpNo;
    @FXML
    private TableColumn tblAddress;
    @FXML
    private JFXButton btnLogOut;
    @FXML
    private JFXButton btnMainMenu;
    @FXML
    private JFXTextField txtCID;
    @FXML
    private AnchorPane rootCustomer;

    @FXML
    private JFXButton btnPrintCustomers;

    private final ObservableList<CustomerTableModel> data = FXCollections.observableArrayList();
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idGenerator();
        txtCID.requestFocus();
        try {
            tblCID.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("customer_Id"));
            tblName.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("customer_Name"));
            tblTpNo.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, Integer>("customer_TpNo"));
            tblAddress.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("customer_Address"));

            tblCustomer.setItems(data);
            ArrayList<Customer> customers = null;
            customers = CustomerController.getAllCustomer();
            for (Customer customer : customers) {
                CustomerTableModel ctm = new CustomerTableModel();
                ctm.setCustomer_Id(customer.getCustomer_Id());
                ctm.setCustomer_Name(customer.getCustomer_Name());
                ctm.setCustomer_TpNo(customer.getCustomer_TpNo());
                ctm.setCustomer_Address(customer.getCustomer_Address());

                data.add(ctm);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtTPNo.focusedProperty().addListener((arg0,oldValue,newValue)->{
            if (!newValue){
                ValidationController.validateTelephoneNumber(txtTPNo);
            }
        });

    }
    @FXML
    private void addCustomer(ActionEvent event) {
        try {
            String customer_Id = txtCID.getText();
            String customer_Name = txtName.getText();
            int customer_TpNo = Integer.parseInt(txtTPNo.getText());
            String customer_Address = txtAddress.getText();

            Customer c = new Customer(customer_Id, customer_Name, customer_TpNo, customer_Address);
            int i = CustomerController.addCustomer(c);
            if (i > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Customer Add");
                alert.setHeaderText("This is an infomation dialog");
                alert.setContentText("Customer has being added sucessfully!!");
                alert.showAndWait();
                tblCustomer.refresh();
                refreshtbl();
                //refresh();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Customer Add");
                alert.setHeaderText("This is an error dialog");
                alert.setContentText("OOPs there is an error adding customer");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void deleteCustomer(ActionEvent event) {
        try {
            String customer_Id = txtCID.getText();
            int deleteCustomer = CustomerController.deleteCustomer(customer_Id);
            if (deleteCustomer > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Customer Delete");
                alert.setHeaderText("This is an infomation dialog");
                alert.setContentText("Customer has being deleted sucessfully!!");
                alert.showAndWait();
                tblCustomer.refresh();
                refreshtbl();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Customer Delete");
                alert.setHeaderText("This is an error dialog");
                alert.setContentText("OOPs there is an error deleting customer");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void searchCustomer(ActionEvent event) {
        try {
            String customer_Id = txtCID.getText();
            Customer c = CustomerController.searchCustomer(customer_Id);
            if (c != null) {
                txtCID.setText(c.getCustomer_Id());
                txtName.setText(c.getCustomer_Name());
                txtTPNo.setText(c.getCustomer_TpNo() + "");
                txtAddress.setText(c.getCustomer_Address());

            }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Customer Search");
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setHeaderText("This is an error dialog");
                alert.setContentText("Customer Not Found");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void updateCustomer(ActionEvent event) {
        try {
            String customer_Id = txtCID.getText();
            String customer_Name = txtName.getText();
            int customer_TpNo = Integer.parseInt(txtTPNo.getText());
            String customer_Address = txtAddress.getText();
            Customer c = new Customer(customer_Id, customer_Name, customer_TpNo, customer_Address);
            int i = CustomerController.updateCustomer(c);
            if (i > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Customer Update");
                alert.setHeaderText("This is an infomation dialog");
                alert.setContentText("Customer has being added updated!!");
                alert.showAndWait();
                tblCustomer.getItems().clear();
                tblCustomer.refresh();
                refreshtbl();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Customer Update");
                alert.setHeaderText("This is an error dialog");
                alert.setContentText("OOPs there is an error updating customer");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void refreshtbl() {
        try {
            tblCID.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("customer_Id"));
            tblName.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("customer_Name"));
            tblTpNo.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, Integer>("customer_TpNo"));
            tblAddress.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("customer_Address"));

            tblCustomer.setItems(data);
            ArrayList<Customer> customers = null;
            customers = CustomerController.getAllCustomer();
            for (Customer customer : customers) {
                CustomerTableModel ctm = new CustomerTableModel();
                ctm.setCustomer_Id(customer.getCustomer_Id());
                ctm.setCustomer_Name(customer.getCustomer_Name());
                ctm.setCustomer_TpNo(customer.getCustomer_TpNo());
                ctm.setCustomer_Address(customer.getCustomer_Address());

                data.add(ctm);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void btnLogOut(ActionEvent actionEvent){
       try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/LoginForm.fxml")));
            rootCustomer.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void btnMainMenu(ActionEvent actionEvent){
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/MainMenu.fxml")));
            rootCustomer.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void idGenerator(){
        try {
            txtCID.setText(edu.ijse.gdse41.dominos.other.IDGenarator.getNewID("customer","CID","C"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void printAllCustomers(ActionEvent actionEvent){
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            JasperReport
                    compiledReport = JasperCompileManager.compileReport(CustomerFormController.class
                    .getResourceAsStream("/edu/ijse/gdse41/dominos/reports/PrintCustomers.jrxml"));
            JasperPrint filledReport = JasperFillManager.fillReport(compiledReport,new HashMap<>(),conn);
            JasperViewer.viewReport(filledReport);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void validationName(KeyEvent event) {
        //ValidationController.onlyAlpha(txtName);
    }

}
