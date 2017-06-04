

package edu.ijse.gdse41.dominos.model;

/**
 *
 * @author SHEHANKA
 */
public class Customer {
    private String customer_Id;
    private String customer_Name;
    private int customer_TpNo;
    private String customer_Address;

    public Customer() {
    }

    public Customer(String customer_Id, String customer_Name, int customer_TpNo, String customer_Address) {
        this.customer_Id = customer_Id;
        this.customer_Name = customer_Name;
        this.customer_TpNo = customer_TpNo;
        this.customer_Address = customer_Address;
    }

    /**
     * @return the customer_Id
     */
    public String getCustomer_Id() {
        return customer_Id;
    }

    /**
     * @param customer_Id the customer_Id to set
     */
    public void setCustomer_Id(String customer_Id) {
        this.customer_Id = customer_Id;
    }

    /**
     * @return the customer_Name
     */
    public String getCustomer_Name() {
        return customer_Name;
    }

    /**
     * @param customer_Name the customer_Name to set
     */
    public void setCustomer_Name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    /**
     * @return the customer_TpNo
     */
    public int getCustomer_TpNo() {
        return customer_TpNo;
    }

    /**
     * @param customer_TpNo the customer_TpNo to set
     */
    public void setCustomer_TpNo(int customer_TpNo) {
        this.customer_TpNo = customer_TpNo;
    }

    /**
     * @return the customer_Address
     */
    public String getCustomer_Address() {
        return customer_Address;
    }

    /**
     * @param customer_Address the customer_Address to set
     */
    public void setCustomer_Address(String customer_Address) {
        this.customer_Address = customer_Address;
    }
    
    
}
