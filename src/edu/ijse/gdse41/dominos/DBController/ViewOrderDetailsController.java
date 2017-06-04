package edu.ijse.gdse41.dominos.DBController;

import edu.ijse.gdse41.dominos.DB.DBConnection;
import edu.ijse.gdse41.dominos.model.ViewOrderDetails;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by SHEHANKA on 6/2/2017.
 */
public class ViewOrderDetailsController {
    public static ArrayList<ViewOrderDetails> getOrderDetails(String order_id) throws ClassNotFoundException,SQLException{
        String SQL="SELECT od.ICode,i.Description,od.QTY,i.UnitPrice\n" +
                "FROM Orders o,Item i,OrderDetails od\n" +
                "WHERE o.OrderID=od.OrderID && od.ICode=i.ICode && o.OrderID='"+order_id+"'";
        System.out.println(order_id);
        Connection conn= DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(SQL);
        ArrayList<ViewOrderDetails> viewOrderDetails=new ArrayList<>();
        while (rst.next()){
            ViewOrderDetails vod;
            vod=new ViewOrderDetails(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4));
            viewOrderDetails.add(vod);
        }
        return viewOrderDetails;
    }
}
