package edu.ijse.gdse41.dominos.other;

import java.sql.SQLException;

/**
 * Created by SHEHANKA on 5/31/2017.
 */
public class IDGenarator {
    public static String getNewID(String tblName, String colName, String prefix) throws SQLException, ClassNotFoundException{
        String lastId = IDController.getLastID(tblName, colName);
        String newId;
        if (lastId != null) {
            String Id="";
            char[] reg=lastId.toCharArray();
            for(int i=1;i<reg.length;i++){
                Id+=reg[i];
            }
            int r=Integer.parseInt(Id);
            if(r<9){
                newId= prefix+"00"+(r+1);
            }else if(r<99){
                newId= prefix+"0"+(r+1);
            }else
                newId= prefix+(r+1);
        }else{
            newId = prefix+"001";
        }
        return newId;
    }
}
