/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import edu.ijse.gdse41.dominos.DBController.ItemController;
import edu.ijse.gdse41.dominos.model.Item;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author SHEHANKA
 */
public class OrderCustomizedFormController implements Initializable {

    @FXML
    private JFXButton btnMainMenu1;
    
    @FXML
    private JFXButton btnAddItem;
    
    @FXML
    private JFXRadioButton rbMedium;

    @FXML
    private JFXRadioButton rbRegular;

    @FXML
    private JFXRadioButton rbLarge;
    
    @FXML
    private Text lblCustomizedPrice;
    
    @FXML
    private JFXCheckBox extraCheese;
    
    @FXML
    private JFXCheckBox blackOlives;
    
    @FXML
    private JFXCheckBox onions;
    
    @FXML
    private JFXCheckBox cripsCapsicum;

    @FXML
    private JFXCheckBox shallot;

    @FXML
    private JFXCheckBox mushroom;
    
    @FXML
    private JFXCheckBox devilsChicken;
    
    private double customizedPrice;
    
    private String txt="";
    
    private int qty=1;
    
    private String item_Code;
    
    @FXML
    private ImageView imgItem;
    
    @FXML
    private Text lblItemDescription;


    public void setTxt(String txt, String itemQty, String itemCode) {
        this.txt = txt;
        lblCustomizedPrice.setText(txt);
        
        this.qty =Integer.parseInt(itemQty);
        
        customizedPrice=Double.parseDouble(txt);
        
        this.item_Code =itemCode;
        
    }
    
    public void setItemCode(String itemCode){
        this.item_Code=itemCode;
        
        try {
            Item o=ItemController.searchItem(item_Code);
            if(o!=null){
                lblItemDescription.setText(o.getItem_Description());
                String imageSource =o.getItem_Image();
                imgItem.setImage(new Image(String.format("file:src/edu/ijse/gdse41/dominos/image/%s.jpg",imageSource)));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblCustomizedPrice.setText(txt);
        
    } 
    
    @FXML
    public void btnAddtoOrder(ActionEvent actionEvent){
        String newAmount=lblCustomizedPrice.getText();System.out.println(newAmount);
        try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/ijse/gdse41/dominos/view/fxml/OrderForm.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
        Stage stage=new Stage();
        stage.setScene(new Scene(root1));
        
        
        OrderFormController oco=fxmlLoader.getController();
        oco.setCustomizedAmount(newAmount);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        //stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void setCustomizedPrice() {
       lblCustomizedPrice.setText(customizedPrice+"");
    }
    
    @FXML
    private void sizeOfCrust(ActionEvent actionEvent){
        try{
            if(rbMedium.isSelected()){
                rbMedium.setSelected(true);
            
            }
            
            if(rbLarge.isSelected()){
                rbLarge.setSelected(true);
                rbMedium.setSelected(false);
                rbRegular.setSelected(false);
                double largeSize=700;
                customizedPrice+=largeSize;
                setCustomizedPrice();
            }
            
            if(rbRegular.isSelected()){
                rbRegular.setSelected(true);
                rbMedium.setSelected(false);
                rbLarge.setSelected(false);
                double regularSize=400;
                customizedPrice-=regularSize;
                setCustomizedPrice();
            }
        
        }catch(Exception e){
        
        }
    
    }
    
    @FXML
    private void addExtraCheese(ActionEvent actionEvent){
        try{
        if(extraCheese.isSelected()){
            double chessePrice=150*qty;
            customizedPrice+=chessePrice;
            setCustomizedPrice();
        }
        }catch(Exception e){
            System.out.println("Can't add cheese");
        }
        
    }
    
    @FXML
    private void addBlackOlives(ActionEvent actionEvent){
        try{
            //Black Olives
            if(blackOlives.isSelected()){
                double blackOlivesPrice=55*qty;
                customizedPrice+=blackOlivesPrice;
                setCustomizedPrice();
            }       
        }catch(Exception e){
        
        }
    }
    
    @FXML
    private void addOnions(ActionEvent actionEvent){
        try{
            if(onions.isSelected()){
                double onionsPrice=55*qty;
                customizedPrice+=onionsPrice;
                setCustomizedPrice();
            }
        }catch(Exception e){
        
        }
        
        
    }
    
    @FXML
    private void addCripsCapsicum(ActionEvent actionEvent){
        try{
            if(cripsCapsicum.isSelected()){
                double cripsCapsicumPrice=55*qty;
                customizedPrice+=cripsCapsicumPrice;
                setCustomizedPrice();
            }
        
        }catch(Exception e){
        
        }
        
    }
    
    @FXML
    private void addShallot(ActionEvent actionEvent){
        try{
            if(shallot.isSelected()){
                double shallotPrice=55*qty;
                customizedPrice+=shallotPrice;
                setCustomizedPrice();
            }
        
        }catch(Exception e){
        
        }
    }
    
    @FXML
    private void addMushroom(ActionEvent actionEvent){
        try{
            if(mushroom.isSelected()){
                double mushroomPrice=55*qty;
                customizedPrice+=mushroomPrice;
                setCustomizedPrice();
            }
        
        }catch(Exception e){
        
        }
    }
    
    @FXML
    private void addDevilsChicken(ActionEvent actionEvent){
        try {
            if(devilsChicken.isSelected()){
                double devilsChickenPrice=55*qty;
                customizedPrice+=devilsChickenPrice;
                setCustomizedPrice();
            }
        } catch (Exception e) {
            
        }
    
    }


    
    
    

    
}
