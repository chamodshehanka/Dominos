package edu.ijse.gdse41.dominos.DBController;

import edu.ijse.gdse41.dominos.DB.DBConnection;
import edu.ijse.gdse41.dominos.model.Users;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by SHEHANKA on 5/29/2017.
 */
public class UserController {
    public static int addUser(Users users)throws ClassNotFoundException,SQLException{
        String SQL="INSERT INTO Login VALUES(?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, users.getUser_Name());
        stm.setObject(2, users.getUser_Password());
        stm.setObject(3, users.getUser_Type());

        return  stm.executeUpdate();
    }

    public static Users searchUser(String user_Name) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Login WHERE LName = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, user_Name);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Users u=new Users(rst.getString(1),rst.getString(2),rst.getString(3));
            return u;
        }
        return null;
    }

    public static int updateUser(Users users) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE Login SET LName= ? ,LPassword= ? ,LType= ? WHERE LName= ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, users.getUser_Name());
        stm.setObject(2, users.getUser_Password());
        stm.setObject(3, users.getUser_Type());

        return  stm.executeUpdate();
    }

    public static int deleteUser(String user_Name) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM Login WHERE LName='"+user_Name+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return  stm.executeUpdate();

    }

    public static ArrayList<Users> getAllUsers() throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select * From Login");
        ArrayList<Users>userList=new ArrayList<>();
        while(rst.next()){
            Users users;
            users = new Users(rst.getString(1),rst.getString(2),rst.getString(3));
            userList.add(users);
        }
        return userList;
    }
}
