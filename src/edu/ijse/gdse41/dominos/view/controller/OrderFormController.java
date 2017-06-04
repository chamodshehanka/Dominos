package edu.ijse.gdse41.dominos.view.controller;
import edu.ijse.gdse41.dominos.DBController.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import edu.ijse.gdse41.dominos.TableModel.OrderTableModel;
import edu.ijse.gdse41.dominos.model.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SHEHANKA
 */
public class OrderFormController implements Initializable {

    @FXML
    private JFXTextField txtCID;
    
    @FXML
    private JFXTextField txtTPNo;
    
    @FXML
    private JFXTextField txtName;
    
    @FXML
    private JFXTextField txtAddress;
    
    @FXML
    private JFXButton btnSearch;
    
    @FXML
    private JFXButton btnLogOut;
    
    @FXML
    private JFXButton btnMainMenu;
    
    @FXML
    private JFXButton btnAddCustomer;
    
    @FXML
    private JFXTextField txtICode;
    
    @FXML
    private JFXTextField txtIDescription;
    
    @FXML
    private JFXButton btnAddItem;
    
    @FXML
    private JFXTextField txtIQty;
    
    @FXML
    private JFXTextField txtIPrice;
    
    @FXML
    private JFXButton btnPayNow;
    
    @FXML
    private JFXButton btnRemoveItem;
    
    @FXML
    private JFXButton btnDeliver;
    
    @FXML
    private JFXButton btnCustomized;
    
    @FXML
    private Text lblAmount;
    
    @FXML
    private TableView tblOrder;

    @FXML
    private TableColumn tblCode;

    @FXML
    private TableColumn tblDescription;

    @FXML
    private TableColumn tblPrice;

    @FXML
    private TableColumn tblQty;

    @FXML
    private TableColumn tblAmount;
    
    @FXML
    private AnchorPane rootOrderForm;
    
    @FXML
    private Text lblTotal;
    
    @FXML
    private JFXTextField txtOID;
    
    @FXML
    private JFXDatePicker txtODate;
    
    private double total;
    
    private double amountPrice;
    
    private String customized_Amount;
    
    private final ObservableList<OrderTableModel> data = FXCollections.observableArrayList();

    public ArrayList<OrderDetail> orderDetailList=new ArrayList<>();
    
      
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idGenerator();
        idGeneratorCustomer();
        total=0;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
//        System.out.println(dateFormat.format(date));
        String todayDate=dateFormat.format(date);
        //txtODate.setValue(LocalDate.parse(todayDate));
    }
    
    public void setCustomizedAmount(String customizedAmount){
        this.customized_Amount=customizedAmount;
        lblAmount.setText(customized_Amount);
    }
    
    @FXML
    private  void customizedNow(ActionEvent actionEvent){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/OrderCustomizedForm.fxml"));
            Parent root1=(Parent) fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root1));
            String amountPrice1=lblAmount.getText();
            String itemQty=txtIQty.getText();
            String itemCode=txtICode.getText();
            
            OrderCustomizedFormController cont=fxmlLoader.getController();
            cont.setTxt(amountPrice1,itemQty,itemCode);
            
            OrderCustomizedFormController oc=fxmlLoader.getController();
            oc.setItemCode(itemCode);
           
            ((Node)(actionEvent.getSource())).getScene().getWindow();
            stage.show();
                
            
        }catch(IOException e){
            System.out.println(e);
        }
    
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
                        getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/order.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Customer Add");
                alert.setHeaderText("This is an infomation dialog");
                alert.setContentText("Customer has being added sucessfully!!");
                alert.showAndWait();
               
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/order.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Customer Add");
                alert.setHeaderText("This is an error dialog");
                alert.setContentText("OOPs there is an error adding customer ");
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
            Customer c =CustomerController.searchCustomer(customer_Id);
            if (c != null) {
                txtCID.setText(c.getCustomer_Id());
                txtName.setText(c.getCustomer_Name());
                txtTPNo.setText(c.getCustomer_TpNo() + "");
                txtAddress.setText(c.getCustomer_Address());

                txtICode.requestFocus();
                
            }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/order.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Customer Search");
                alert.setHeaderText("This is an error dialog");
                alert.setContentText("Customer Not Found \n Add him");
                alert.showAndWait();

                txtName.requestFocus();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @FXML
    private void searchItem(ActionEvent event) {
        try {
            String item_Code = txtICode.getText();
            Item o =ItemController.searchItem(item_Code);
            String size="M";
            if (o != null) {
                txtICode.setText(o.getItem_Code());
                txtIDescription.setText(o.getItem_Description()+" - "+size);
                txtIPrice.setText(o.getItem_UnitPrice() + "");
                
                txtIQty.requestFocus();
                
                if("Sides".equals(o.getItem_Type())){
                btnCustomized.setDisable(true);
                }else{
                btnCustomized.setDisable(false);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    @FXML
    private void btnLogOut(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/LoginForm.fxml")));
            rootOrderForm.getChildren().setAll(loginForm);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void btnMainMenu(ActionEvent actionEvent){
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/MainMenu.fxml")));
            rootOrderForm.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void setOrderPrice(ActionEvent actionEvent){
        try{
            
            double itemPrice=Double.parseDouble(txtIPrice.getText());
            int qty=Integer.parseInt(txtIQty.getText());
            double amount=itemPrice * qty;
        
            lblAmount.setText(""+amount);
        }
        catch(NumberFormatException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void btnAddOrder(ActionEvent actionEvent){
        try {
            tblCode.setCellValueFactory(new PropertyValueFactory<OrderTableModel,String>("item_Code"));
            tblDescription.setCellValueFactory(new PropertyValueFactory<OrderTableModel,String>("item_Description"));
            tblPrice.setCellValueFactory(new PropertyValueFactory<OrderTableModel,Double>("item_Price"));
            tblQty.setCellValueFactory(new PropertyValueFactory<OrderTableModel,Integer>("item_Qty"));
            tblAmount.setCellValueFactory(new PropertyValueFactory<OrderTableModel,Double>("amount"));
        
            tblOrder.setItems(data);
        //
            OrderTableModel otm= new OrderTableModel();
            otm.setItem_Code(txtICode.getText());
            otm.setItem_Description(txtIDescription.getText());
            otm.setItem_Price(Double.parseDouble(txtIPrice.getText()));
            otm.setItem_Qty(Integer.parseInt(txtIQty.getText()));
            otm.setAmount(Double.parseDouble(lblAmount.getText()));
            data.add(otm);

            //Order Details to Array List

            String order_Id=txtOID.getText();
            String itemCode=txtICode.getText();
            int qty= Integer.parseInt(txtIQty.getText());
            double unitPrice= Double.parseDouble(txtIPrice.getText());

            OrderDetail od=new OrderDetail(order_Id,itemCode,qty,unitPrice);
            orderDetailList.add(od);
            //
            
            amountPrice=Double.parseDouble(lblAmount.getText());
            total+=amountPrice;
            lblTotal.setText(""+total);
            
        //
            txtICode.setText(null);
            txtIDescription.setText(null);
            txtIPrice.setText(null);
            txtIQty.setText(null);
            lblAmount.setText(null);

            btnCustomized.setDisable(false);

            txtICode.requestFocus();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void btnPayment(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/PaymentForm.fxml"));
            Parent root1=(Parent) fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root1));
            

            String order_Price=lblTotal.getText();

            String order_Id=txtOID.getText();
            LocalDate date =txtODate.getValue();
            String order_Date=date.format(DateTimeFormatter.ISO_DATE);
            String customer_Id=txtCID.getText();

            
            PaymentFormController cont=fxmlLoader.getController();
            cont.setText(order_Price,order_Id,order_Date,customer_Id,orderDetailList);
            ((Node)(actionEvent.getSource())).getScene().getWindow();
            stage.show();
        } catch (Exception e) {
                e.printStackTrace();
        }

    }
    
    @FXML
    private void btnDelivery(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/DeliveryForm.fxml"));
            Parent root1=(Parent) fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root1));

            String order_Price=lblTotal.getText();

            String order_Id=txtOID.getText();
            LocalDate date =txtODate.getValue();
            String order_Date=date.format(DateTimeFormatter.ISO_DATE);
            String customer_Id=txtCID.getText();


            DeliveryFormController cont=fxmlLoader.getController();
            cont.setText(order_Price,order_Id,order_Date,customer_Id,orderDetailList);


            ((Node)(actionEvent.getSource())).getScene().getWindow();
            stage.show();
        }catch(IOException e){
            System.out.println(e);
        }
    }


    
    @FXML
    private void btnRemoveItem(ActionEvent actionEvent){
        
        int removeIndex=tblOrder.getSelectionModel().getSelectedIndex();
        tblOrder.getItems().remove(removeIndex);
        orderDetailList.remove(removeIndex);
        Double remove_UnitPrice =orderDetailList.get(removeIndex).getItem_UnitPrice();
        int remove_Qty=orderDetailList.get(removeIndex).getItem_Qty();
        Double remove_Amount=remove_UnitPrice*remove_Qty;
        total-=remove_Amount;
        if ((total ==0)) {
            lblTotal.setText(String.valueOf(total));
        } else {
            lblTotal.setText(String.valueOf(0));

        }

    }

    @FXML
    private void idGenerator(){
        try {
            txtOID.setText(edu.ijse.gdse41.dominos.other.IDGenarator.getNewID("Orders","OrderID","O"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void idGeneratorCustomer(){
        try {
            txtCID.setText(edu.ijse.gdse41.dominos.other.IDGenarator.getNewID("customer","CID","C"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
