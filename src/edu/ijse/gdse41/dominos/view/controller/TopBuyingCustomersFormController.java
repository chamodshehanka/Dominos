package edu.ijse.gdse41.dominos.view.controller;

import com.jfoenix.controls.JFXDatePicker;
import edu.ijse.gdse41.dominos.DB.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by SHEHANKA on 5/29/2017.
 */
public class TopBuyingCustomersFormController implements Initializable {

    @FXML
    private AnchorPane rootTopBuyingCustomers;

    @FXML
    private BarChart barChart;

    @FXML
    private JFXDatePicker txtODate;

    private String date;

    ObservableList<BarChart.Series> barChartData= FXCollections.observableArrayList() ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        date="2017-06-03";
        try {
            topCustomers();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        barChart.setData(barChartData);
    }

    public void topCustomers()throws ClassNotFoundException,SQLException{
        barChartData.clear();
        String SQL="select CName,count(orderid) as no_of_orders\n" +
                "from orders o,Customer c\n" +
                "where o.CID=c.CID\n" +
                "group by c.CID\n" +
                "order by 2 desc limit 10;";

        try {
            Connection c = DBConnection.getDBConnection().getConnection();
            ResultSet rs = c.createStatement().executeQuery(SQL);
            while(rs.next()){
                BarChart.Series sr=new BarChart.Series<>();
                sr.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
                sr.setName(rs.getString(1));
                barChartData.add(sr);
            }
        }catch (SQLException|ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void btnLogOut(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/LoginForm.fxml")));
            rootTopBuyingCustomers.getChildren().setAll(loginForm);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void btnMainMenu(ActionEvent actionEvent){
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/MainMenuAdmin.fxml")));
            rootTopBuyingCustomers.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void setBarChart(ActionEvent actionEvent){
        date= String.valueOf(txtODate.getValue());
        String SQL2="select CName,count(orderid) as no_of_orders\n" +
                "from orders o,Customer c\n" +
                "where o.CID=c.CID && o.OrderDate='"+date+"'\n" +
                "group by c.CID\n" +
                "order by 2 desc limit 10;";
        try {
            barChartData.clear();
            Connection c = DBConnection.getDBConnection().getConnection();
            ResultSet rs = c.createStatement().executeQuery(SQL2);
            while(rs.next()){
                BarChart.Series sr=new BarChart.Series<>();
                sr.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
                sr.setName(rs.getString(1));
                barChartData.add(sr);
            }
        }catch (SQLException|ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
