package edu.ijse.gdse41.dominos.view.controller;

import com.jfoenix.controls.JFXDatePicker;
import edu.ijse.gdse41.dominos.DBController.ViewAllOrderController;
import edu.ijse.gdse41.dominos.TableModel.ViewAllOrderTableModel;
import edu.ijse.gdse41.dominos.model.ViewAllOrder;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by SHEHANKA on 6/2/2017.
 */
public class ViewAllOrderFormController implements Initializable {

    @FXML
    private AnchorPane rootViewAllOrders;

    @FXML
    private TableView tblOrder;

    @FXML
    private TableColumn tblOrderId;

    @FXML
    private TableColumn tblCID;

    @FXML
    private TableColumn tblCName;

    @FXML
    private TableColumn tblODate;

    @FXML
    private TableColumn tblOPrice;

    @FXML
    private TableColumn tblOStatus;

    @FXML
    private JFXDatePicker txtODate;

    private final ObservableList<ViewAllOrderTableModel> data= FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            tblOrderId.setCellValueFactory(new PropertyValueFactory<ViewAllOrderTableModel,String>("order_Id"));
            tblCID.setCellValueFactory(new PropertyValueFactory<ViewAllOrderTableModel,String>("customer_Id"));
            tblCName.setCellValueFactory(new PropertyValueFactory<ViewAllOrderTableModel,String>("customer_Name"));
            tblODate.setCellValueFactory(new PropertyValueFactory<ViewAllOrderTableModel,String>("order_Date"));
            tblOPrice.setCellValueFactory(new PropertyValueFactory<ViewAllOrderTableModel,Double>("order_Price"));
            tblOStatus.setCellValueFactory(new PropertyValueFactory<ViewAllOrderTableModel,String>("order_Status"));

            tblOrder.setItems(data);
            ArrayList<ViewAllOrder> viewAllOrders=null;
            viewAllOrders= ViewAllOrderController.getAllOrders();
            for (ViewAllOrder allOrder:
                 viewAllOrders) {
                ViewAllOrderTableModel viewAllOrderTableModel=new ViewAllOrderTableModel();
                viewAllOrderTableModel.setOrder_Id(allOrder.getOrder_Id());
                viewAllOrderTableModel.setCustomer_Id(allOrder.getCustomer_Id());
                viewAllOrderTableModel.setCustomer_Name(allOrder.getCustomer_Name());
                viewAllOrderTableModel.setOrder_Date(allOrder.getOrder_Date());
                viewAllOrderTableModel.setOrder_Price(allOrder.getOrder_Price());
                viewAllOrderTableModel.setOrder_Status(allOrder.getOrder_Status());
                data.add(viewAllOrderTableModel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    private void btnLogOut(ActionEvent actionEvent){
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/LoginForm.fxml")));
            rootViewAllOrders.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void btnMainMenu(ActionEvent actionEvent){
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/MainMenu.fxml")));
            rootViewAllOrders.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void viewOrderDetails(ActionEvent actionEvent){
        int selected_Index=tblOrder.getSelectionModel().getSelectedIndex();
        String selected_OID=data.get(selected_Index).getOrder_Id();
        System.out.println(selected_OID);
    }
}
