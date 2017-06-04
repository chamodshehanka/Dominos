package edu.ijse.gdse41.dominos.DBController;

import edu.ijse.gdse41.dominos.DB.DBConnection;
import edu.ijse.gdse41.dominos.model.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by SHEHANKA on 5/31/2017.
 */
public class PaymentController {
    public static int addNewPayment(Payment payment)throws ClassNotFoundException,SQLException{
        Connection conn= DBConnection.getDBConnection().getConnection();
        String SQL="Insert into Payment Values(?,?,?,?)";
        PreparedStatement stm=conn.prepareStatement(SQL);
        stm.setObject(1,payment.getPayment_Id());
        stm.setObject(2,payment.getOrder_Id());
        stm.setObject(3,payment.getPayment_Price());
        stm.setObject(4,payment.getPayment_Discount());
        return stm.executeUpdate();

    }
}
