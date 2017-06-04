package edu.ijse.gdse41.dominos.other;

import edu.ijse.gdse41.dominos.DB.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by SHEHANKA on 5/31/2017.
 */
public class IDController {
    public static String getLastID(String tblName, String colName) throws SQLException, ClassNotFoundException{
        String SQL=String.format("SELECT %s FROM %s ORDER BY %s DESC LIMIT 1",colName,tblName,colName);
        Connection conn= DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();

        ResultSet rst=stm.executeQuery(SQL);
        if(rst.next())
            return rst.getString(1);
        return null;
    }
}
