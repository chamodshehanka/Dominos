package edu.ijse.gdse41.dominos.DBController;

import edu.ijse.gdse41.dominos.DB.DBConnection;
import edu.ijse.gdse41.dominos.model.Order;
import edu.ijse.gdse41.dominos.model.PendingOrder;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by SHEHANKA on 5/31/2017.
 */
public class PendingOrderController {
    public static ArrayList<PendingOrder> getAllPendingOrders() throws ClassNotFoundException,SQLException{
        String SQL="SELECT o.OrderID,CName \n" +
                    "FROM orders o,customer c,Item i,OrderDetails od \n" +
                    "WHERE o.CID=c.CID && o.orderId=od.orderId && o.OrderStatus='Pending' \n" +
                     "GROUP BY o.orderid";
        String SQL2="SELECT o.OrderID,CName,p.Price \n" +
                "FROM orders o,customer c,OrderDetails od,Payment p \n" +
                "WHERE o.CID=c.CID && o.OrderStatus='Pending' && o.orderId=p.orderId GROUP BY p.pID";
        Connection conn= DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(SQL2);
        ArrayList<PendingOrder> pendingOrders=new ArrayList<>();
        while (rst.next()){
            PendingOrder pendingOrder;
            pendingOrder=new PendingOrder(rst.getString(1),rst.getString(2),rst.getDouble(3));
            pendingOrders.add(pendingOrder);
        }
        return pendingOrders;
    }


    public static int markAsPaid(Order order)throws ClassNotFoundException,SQLException {
        String SQL="UPDATE Orders SET OrderStatus= ? WHERE OrderId= ? ";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(SQL);
        stm.setObject(1,order.getOrder_Id());
        stm.setObject(2,order.getOrder_Status());
        return stm.executeUpdate();
    }
}
