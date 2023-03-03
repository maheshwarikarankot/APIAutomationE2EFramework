package org.RestfulBooker.Framework.utils;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FillowUtils {

    static String FILEPATH = System.getProperty("user.dir") + "/src/main/resources/TestData.xlsx";


    public static String fetchDataFromXLSX(String sheetName,String id, String fieldName){
        String value = null;
        try {
            Fillo fillo = new Fillo();
            Connection connection = fillo.getConnection(FILEPATH);
            String query = "Select * from " + sheetName + "" + " where ID=" + id + "";
            Recordset recordset = connection.executeQuery(query);
            while (recordset.next()){
                value = recordset.getField(fieldName);
            }
            recordset.close();
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }
}
