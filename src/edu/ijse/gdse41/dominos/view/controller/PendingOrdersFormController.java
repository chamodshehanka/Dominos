package edu.ijse.gdse41.dominos.view.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.gdse41.dominos.DBController.PendingOrderController;
import edu.ijse.gdse41.dominos.TableModel.PendingOrderTableModel;
import edu.ijse.gdse41.dominos.model.Order;
import edu.ijse.gdse41.dominos.model.PendingOrder;
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

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by SHEHANKA on 5/29/2017.
 */
public class PendingOrdersFormController implements Initializable {

    @FXML
    private AnchorPane rootPendingOrders;

    @FXML
    private TableView tblPendingOrders;

    @FXML
    private TableColumn tblOrderNo;

    @FXML
    private TableColumn tblCustName;

    @FXML
    private TableColumn tblOrderPrice;

    @FXML
    private JFXButton btnMarkAsPaid;

    private String order_Status;

    private String order_Id;

    private final ObservableList<PendingOrderTableModel> data= FXCollections.observableArrayList();

    ArrayList<PendingOrder> pendingOrders=new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        order_Status="Paid";
        try {
            tblOrderNo.setCellValueFactory(new PropertyValueFactory<PendingOrderTableModel,String>("order_Id"));
            tblCustName.setCellValueFactory(new PropertyValueFactory<PendingOrderTableModel,String>("customer_Name"));
            tblOrderPrice.setCellValueFactory(new PropertyValueFactory<PendingOrderTableModel,String>("order_Price"));

            tblPendingOrders.setItems(data);

            pendingOrders= PendingOrderController.getAllPendingOrders();
            for (PendingOrder pendingOrder:
                    pendingOrders) {
                PendingOrderTableModel pendingOrderTableModel=new PendingOrderTableModel();
                pendingOrderTableModel.setOrder_Id(pendingOrder.getOrder_Id());
                pendingOrderTableModel.setCustomer_Name(pendingOrder.getCustmer_Name());
                pendingOrderTableModel.setOrder_Price(pendingOrder.getOrder_Price());
                data.add(pendingOrderTableModel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @FXML
    private void btnMainMenu(ActionEvent actionEvent){
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/MainMenu.fxml")));
            rootPendingOrders.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void btnLogOut(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/LoginForm.fxml")));
            rootPendingOrders.getChildren().setAll(loginForm);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void setBtnMarkAsPaid(ActionEvent actionEvent){
        int paidIndex=tblPendingOrders.getSelectionModel().getSelectedIndex();
        tblPendingOrders.getItems().remove(paidIndex);

        order_Id=pendingOrders.get(paidIndex).getOrder_Id();

        Order o=new Order(order_Id,order_Status);
        int i= 0;
        try {
            i = PendingOrderController.markAsPaid(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i>0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            //
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(
                    getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/DialogStyle.css").toExternalForm());
            dialogPane.getStyleClass().add("myDialog");
            //
            alert.setTitle("Mark Orders as Paid");
            alert.setHeaderText("This is an infomation dialog");
            alert.setContentText("Order has being paid sucessfully!!");
            alert.showAndWait();
        }
    }
}
