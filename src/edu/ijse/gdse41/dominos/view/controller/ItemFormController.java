/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.ijse.gdse41.dominos.DBController.ItemController;
import edu.ijse.gdse41.dominos.TableModel.ItemTableModel;
import edu.ijse.gdse41.dominos.model.Item;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author SHEHANKA
 */
public class ItemFormController implements Initializable {

    @FXML
    private JFXTextField txtICode;
    @FXML
    private JFXTextField txtIUnitPrice;
    @FXML
    private JFXTextField txtIDescription;
    @FXML
    private JFXButton btnAddItem;
    @FXML
    private JFXButton btnDeleteItem;
    @FXML
    private JFXButton btnSearchItem;
    @FXML
    private JFXButton btnUpdateItem;
    @FXML
    private TableView tblItem;
    @FXML
    private TableColumn tblICode;
    @FXML
    private TableColumn tblIDescription;
    @FXML
    private TableColumn tblIUnitPrice;
    @FXML
    private TableColumn tblIType;

    @FXML
    private TableColumn tblIImage;

    @FXML
    private JFXButton btnLogOut;
    @FXML
    private JFXButton btnMainMenu;
    
    @FXML
    private JFXComboBox cbxType;
    
    @FXML
    private JFXTextField txtIImage;
    
    @FXML
    private AnchorPane rootItemForm;

    private final ObservableList<ItemTableModel> data = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idGenerator();
        comboBoxType();
        try {
            tblICode.setCellValueFactory(new PropertyValueFactory<ItemTableModel, String>("item_Code"));
            tblIDescription.setCellValueFactory(new PropertyValueFactory<ItemTableModel, String>("item_Description"));
            tblIUnitPrice.setCellValueFactory(new PropertyValueFactory<ItemTableModel, Double>("item_UnitPrice"));
            tblIType.setCellValueFactory(new PropertyValueFactory<ItemTableModel,String>("item_Type"));
            tblIImage.setCellValueFactory(new PropertyValueFactory<ItemTableModel,String>("item_Image"));

            tblItem.setItems(data);
            ArrayList<Item> items = null;
            items = ItemController.getAllItem();
            for (Item item : items) {
                ItemTableModel ctm = new ItemTableModel();
                ctm.setItem_Code(item.getItem_Code());
                ctm.setItem_Description(item.getItem_Description());
                ctm.setItem_UnitPrice(item.getItem_UnitPrice());
                ctm.setItem_Type(item.getItem_Type());
                ctm.setItem_Image(item.getItem_Image());

                data.add(ctm);
            
            
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        unitPriceValidation();
    }    


    @FXML
    private void addItem(ActionEvent event) {
        try {
            String item_Code = txtICode.getText();
            String item_Desciption = txtIDescription.getText();
            double item_UnitPrice = Double.parseDouble(txtIUnitPrice.getText());
            String item_Type=(String) cbxType.getValue();
            String item_Image=txtIImage.getText();
            
            Item c = new Item(item_Code, item_Desciption, item_UnitPrice,item_Type,item_Image);
            int i = ItemController.addItem(c);
            if (i > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Item Add");
                alert.setHeaderText("This is an infomation dialog");
                alert.setContentText("Item has being added sucessfully!!");
                alert.showAndWait();
                tblItem.getItems().clear();
                tblItem.refresh();
                refreshtbl();
                
                txtICode.setText(null);
                txtIDescription.setText(null);
                txtIUnitPrice.setText(null);
                cbxType.setValue(null);
                txtIImage.setText(null);

                idGenerator();
               
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Item Add");
                alert.setHeaderText("This is an error dialog");
                alert.setContentText("OOPs there is an error adding item");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deleteItem(ActionEvent event) {
        try {
            String item_Code = txtICode.getText();
            int deleteItem = ItemController.deleteItem(item_Code);
            if (deleteItem > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Item Delete");
                alert.setHeaderText("This is an infomation dialog");
                alert.setContentText("Item has being deleted sucessfully!!");
                alert.showAndWait();
                tblItem.refresh();
                refreshtbl();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Item Delete");
                alert.setHeaderText("This is an error dialog");
                alert.setContentText("OOPs there is an error deleting item");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void searchItem(ActionEvent event) {
        try {
            String item_Code = txtICode.getText();
            Item c = ItemController.searchItem(item_Code);
            if (c != null) {
                txtICode.setText(c.getItem_Code());
                txtIDescription.setText(c.getItem_Description());
                txtIUnitPrice.setText(c.getItem_UnitPrice() + "");
                cbxType.setValue(c.getItem_Type());
                txtIImage.setText(c.getItem_Image());
            }else {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Item Search");
                alert.setHeaderText("This is an error dialog");
                alert.setContentText("Item Not Found \n Add it");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void updateItem(ActionEvent event) {
        try {
            String item_Code = txtICode.getText();
            String item_Desciption = txtIDescription.getText();
            double item_UnitPrice = Double.parseDouble(txtIUnitPrice.getText());
            String item_Type=(String) cbxType.getValue();
            String item_Image=txtIImage.getText();
            
            Item c = new Item(item_Code, item_Desciption, item_UnitPrice,item_Type,item_Image);
            int i = ItemController.updateItem(c);
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
                tblItem.getItems().clear();
                tblItem.refresh();
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
                alert.setContentText("OOPs there is an error adding customer");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void refreshtbl(){
        try {
            tblICode.setCellValueFactory(new PropertyValueFactory<ItemTableModel, String>("item_Code"));
            tblIDescription.setCellValueFactory(new PropertyValueFactory<ItemTableModel, String>("item_Description"));
            tblIUnitPrice.setCellValueFactory(new PropertyValueFactory<ItemTableModel, Double>("item_UnitPrice"));
            tblIType.setCellValueFactory(new PropertyValueFactory<ItemTableModel,String>("item_Type"));
            tblIImage.setCellValueFactory(new PropertyValueFactory<ItemTableModel,String>("item_Image"));

            tblItem.setItems(data);
            ArrayList<Item> items = null;
            items = ItemController.getAllItem();
            for (Item item : items) {
                ItemTableModel ctm = new ItemTableModel();
                ctm.setItem_Code(item.getItem_Code());
                ctm.setItem_Description(item.getItem_Description());
                ctm.setItem_UnitPrice(item.getItem_UnitPrice());
                ctm.setItem_Type(item.getItem_Type());
                ctm.setItem_Image(item.getItem_Image());

                data.add(ctm);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void comboBoxType(){
        cbxType.getItems().addAll("Pizza","Sides");
    }
    
    @FXML
    private void btnMainMenu(ActionEvent actionEvent){
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/MainMenuAdmin.fxml")));
            rootItemForm.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void btnLogOut(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/LoginForm.fxml")));
            rootItemForm.getChildren().setAll(loginForm);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void idGenerator(){
        try {
            txtICode.setText(edu.ijse.gdse41.dominos.other.IDGenarator.getNewID("Item","ICode","I"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void unitPriceValidation(){
        txtIUnitPrice.focusedProperty().addListener((arg0,oldValue,newValue)->{
            if (!newValue){
                //ValidationController.onlyNumeric(txtIUnitPrice);
            }
        });
    }
    
}
