
package edu.ijse.gdse41.dominos.DBController;

import edu.ijse.gdse41.dominos.DB.DBConnection;
import edu.ijse.gdse41.dominos.model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author SHEHANKA
 */
public class OrderController {
    public static boolean addNewOrder(Order orders)throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        String SQL="Insert into Orders Values(?,?,?,?,?)";
        PreparedStatement stm=conn.prepareStatement(SQL);
        stm.setObject(1,orders.getOrder_Id());
        stm.setObject(2,orders.getOrder_Date());
        stm.setObject(3,orders.getCustomer_Id());
        stm.setObject(4,orders.getOrder_Discount());
        stm.setObject(5,orders.getOrder_Status());
        int res=stm.executeUpdate();
        if(res>0){
            boolean isAdded=OrderDetailsController.addOrderDetails(orders.getOrder_DetailList());
            if(isAdded){
                return true;
            }
        }
        return false;
    }
}
