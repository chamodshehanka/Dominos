package edu.ijse.gdse41.dominos.model;

/**
 * Created by SHEHANKA on 5/29/2017.
 */
public class Users {
    private String user_Name;
    private String user_Password;
    private String user_Type;

    public Users(String user_Name, String user_Password, String user_Type) {
        this.user_Name = user_Name;
        this.user_Password = user_Password;
        this.user_Type = user_Type;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getUser_Password() {
        return user_Password;
    }

    public void setUser_Password(String user_Password) {
        this.user_Password = user_Password;
    }

    public String getUser_Type() {
        return user_Type;
    }

    public void setUser_Type(String user_Type) {
        this.user_Type = user_Type;
    }
}
