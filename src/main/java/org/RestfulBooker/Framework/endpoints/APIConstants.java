package org.RestfulBooker.Framework.endpoints;

import org.RestfulBooker.Framework.utils.FillowUtils;
import org.RestfulBooker.Framework.utils.PropertyReader;
import org.RestfulBooker.Framework.utils.YamlReader;

import java.io.FileNotFoundException;

public class APIConstants {

//public static String BASE_URL  = FillowUtils.fetchDataFromXLSX("Sheet1","baseUrl","value");
//public static String Username = FillowUtils.fetchDataFromXLSX("Sheet1","username","value");
//public static String Password = FillowUtils.fetchDataFromXLSX("Sheet1","password","value");
public static String BASE_URL  = "https://restful-booker.herokuapp.com";

//    public static String BASE_URL;
//
//    static {
//        try {
////            BASE_URL = PropertyReader.readyKey("url","config_prod.properties");
//            BASE_URL = PropertyReader.readyKey("url","config_qa.properties");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    public  static String BASE_URL;
//
//    static {
//        try {
//            BASE_URL = YamlReader.readKey("url","data.yaml");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    public static String CREATE_BOOKING  = "/booking";

    public static String UPDATE_BOOKING  = "/booking/";
}
