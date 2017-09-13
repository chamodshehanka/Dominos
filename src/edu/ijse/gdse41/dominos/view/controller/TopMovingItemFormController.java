/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.view.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import edu.ijse.gdse41.dominos.DB.DBConnection;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author SHEHANKA
 */
public class TopMovingItemFormController implements Initializable {

    @FXML
    private AnchorPane rootTopMovingItem;
    
    @FXML
    private JFXButton btnMainMenu;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private Label lblItemDetails;
    
    @FXML
    private PieChart pchaPizza;

    @FXML
    private JFXDatePicker txtODate;

    private String date;

    ObservableList<PieChart.Data> pieChartData=FXCollections.observableArrayList() ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        date="2017-05-31";
        try {
            chartPizza();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        pchaPizza.setData(pieChartData);
    }  
    
    public void chartPizza() throws SQLException, ClassNotFoundException {
        pieChartData.clear();

        String  SQL="select Description, count(orderid) as no_of_orders\n" +
                "from Item i,OrderDetails od\n" +
                "where i.icode=od.icode\n" +
                "group by i.icode\n" +
                "order by 2 desc limit 10;";
        try {
            Connection c = DBConnection.getDBConnection().getConnection();
            ResultSet rs = c.createStatement().executeQuery(SQL);
            while(rs.next()){
                //adding data on piechart data
                pieChartData.add(new PieChart.Data(rs.getString(1), rs.getDouble(2)));
            }
        }catch (SQLException|ClassNotFoundException e){
            e.printStackTrace();
        }

        pchaPizza.setData(pieChartData);
        
    }
    
    @FXML
    private void btnLogOut(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/LoginForm.fxml")));
            rootTopMovingItem.getChildren().setAll(loginForm);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void btnMainMenu(ActionEvent actionEvent){
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/MainMenuAdmin.fxml")));
            rootTopMovingItem.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void itemDetailsEvent(MouseEvent event) {
        pchaPizza.getData().stream()
                .forEach(data -> {data.getNode().addEventHandler(MouseEvent.ANY,event1 -> {
                    lblItemDetails
                            .setText(
                                    data.getName()+" ("+
                                            (int)data.getPieValue()+")"+"\nPresentage : "+
                                            Double.parseDouble(String.valueOf(((
                                                    data.getPieValue()/100)*360)))+"%");
                });
        });
    }


    @FXML
    private void chartChanging(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        date= String.valueOf(txtODate.getValue());
        String SQL2="select Description, count(od.orderid) as no_of_orders\n" +
                "from Item i,OrderDetails od,orders o\n" +
                "where i.icode=od.icode && o.OrderDate='"+date+"'\n" +
                "group by i.icode\n" +
                "order by 2 desc limit 10;";
        pieChartData.clear();
        try {
            Connection c = DBConnection.getDBConnection().getConnection();
            ResultSet rs = c.createStatement().executeQuery(SQL2);
            while(rs.next()){
                pieChartData.add(new PieChart.Data(rs.getString(1), rs.getDouble(2)));
            }
        }catch (SQLException|ClassNotFoundException e){
            System.out.println(e);
        }

        pchaPizza.setData(pieChartData);
    }
    
}
