package edu.ijse.gdse41.dominos.TableModel;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by SHEHANKA on 5/29/2017.
 */
public class UserTableModel {
    private SimpleStringProperty user_Name = new SimpleStringProperty("");
    private SimpleStringProperty user_Password = new SimpleStringProperty("");
    private SimpleStringProperty user_Type = new SimpleStringProperty("");

    public UserTableModel() {
        this.user_Name = user_Name;
        this.user_Password = user_Password;
        this.user_Type = user_Type;
    }

    public String getUser_Name() {
        return user_Name.get();
    }

    public SimpleStringProperty user_NameProperty() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name.set(user_Name);
    }

    public String getUser_Password() {
        return user_Password.get();
    }

    public SimpleStringProperty user_PasswordProperty() {
        return user_Password;
    }

    public void setUser_Password(String user_Password) {
        this.user_Password.set(user_Password);
    }

    public String getUser_Type() {
        return user_Type.get();
    }

    public SimpleStringProperty user_TypeProperty() {
        return user_Type;
    }

    public void setUser_Type(String user_Type) {
        this.user_Type.set(user_Type);
    }
}
