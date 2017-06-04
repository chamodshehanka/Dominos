package edu.ijse.gdse41.dominos.DBController;

import edu.ijse.gdse41.dominos.DB.DBConnection;
import edu.ijse.gdse41.dominos.model.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by SHEHANKA on 5/29/2017.
 */

public class OrderDetailsController {
    public static boolean addOrderDetails(ArrayList<OrderDetail> orderDetailList)throws ClassNotFoundException, SQLException {
        for(OrderDetail ob : orderDetailList){
            boolean isUpdated=OrderDetailsController.addOrderDetails(ob);
            if(!isUpdated){
                return false;
            }
        }
        return true;
    }
    public static boolean addOrderDetails(OrderDetail orderDetail)throws ClassNotFoundException, SQLException{
        Connection conn= DBConnection.getDBConnection().getConnection();
        String SQL="Insert into OrderDetails Values(?,?,?)";
        PreparedStatement stm=conn.prepareStatement(SQL);
        stm.setObject(1,orderDetail.getOrder_Id());
        stm.setObject(2,orderDetail.getItem_Code());
        stm.setObject(3,orderDetail.getItem_Qty());
        return stm.executeUpdate()>0;
    }
}
