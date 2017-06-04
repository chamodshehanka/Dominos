package edu.ijse.gdse41.dominos.DBController;

import edu.ijse.gdse41.dominos.DB.DBConnection;
import edu.ijse.gdse41.dominos.model.ViewAllOrder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by SHEHANKA on 6/2/2017.
 */
public class ViewAllOrderController {
    public static ArrayList<ViewAllOrder> getAllOrders() throws SQLException, ClassNotFoundException {
        String SQL="SELECT o.OrderID,o.CID,c.CName,o.OrderDate,p.Price,o.OrderStatus\n" +
                "FROM orders o,customer c,Payment p\n" +
                "WHERE o.CID=c.CID && o.OrderID=p.OrderID;";
        Connection conn= DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(SQL);
        ArrayList<ViewAllOrder> allOrders=new ArrayList<>();
        while (rst.next()){
            ViewAllOrder allOrder;
            allOrder=new ViewAllOrder(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getDouble(5),rst.getString(6));
            allOrders.add(allOrder);
        }
        return allOrders;
    }
}
