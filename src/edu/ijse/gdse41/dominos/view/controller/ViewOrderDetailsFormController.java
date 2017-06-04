package edu.ijse.gdse41.dominos.view.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.gdse41.dominos.DBController.ViewOrderDetailsController;
import edu.ijse.gdse41.dominos.TableModel.ViewOrderDetailsTableModel;
import edu.ijse.gdse41.dominos.model.ViewOrderDetails;
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
public class ViewOrderDetailsFormController implements Initializable {

    @FXML
    private AnchorPane rootViewOrderDetails;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private JFXButton btnMainMenu;

    @FXML
    private TableView tblOrderDetails;

    @FXML
    private TableColumn tblItemCode;

    @FXML
    private TableColumn tblItemDescription;

    @FXML
    private TableColumn tblItemQty;

    @FXML
    private TableColumn tblItemUnitPrice;

    private final ObservableList<ViewOrderDetailsTableModel> data= FXCollections.observableArrayList();

    private String order_Id;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        order_Id="O027";
        try {
            ArrayList<ViewOrderDetails> viewOrderDetails=null;
            viewOrderDetails= ViewOrderDetailsController.getOrderDetails(order_Id);
            tblItemCode.setCellValueFactory(new PropertyValueFactory<ViewOrderDetails,String>("item_Code"));
            tblItemDescription.setCellValueFactory(new PropertyValueFactory<ViewOrderDetails,String>("item_Description"));
            tblItemQty.setCellValueFactory(new PropertyValueFactory<ViewOrderDetails,Integer>("item_Qty"));
            tblItemUnitPrice.setCellValueFactory(new PropertyValueFactory<ViewOrderDetails,Double>("unit_Price"));

            tblOrderDetails.setItems(data);

            for (ViewOrderDetails orderDetails:
                 viewOrderDetails) {
                ViewOrderDetailsTableModel vod=new ViewOrderDetailsTableModel();
                vod.setItem_Code(orderDetails.getItem_Code());
                vod.setItem_Description(orderDetails.getItem_Description());
                vod.setItem_Qty(orderDetails.getItem_Qty());
                vod.setUnit_Price(orderDetails.getUnit_Price());
                data.add(vod);
                System.out.println(orderDetails.getItem_Code());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    private void btnLogOut(ActionEvent actionEvent){
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/LoginForm.fxml")));
            rootViewOrderDetails.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void btnMainMenu(ActionEvent actionEvent){
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/MainMenu.fxml")));
            rootViewOrderDetails.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
