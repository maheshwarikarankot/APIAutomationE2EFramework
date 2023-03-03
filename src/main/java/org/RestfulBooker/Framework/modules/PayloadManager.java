package org.RestfulBooker.Framework.modules;
import com.google.gson.Gson;
import org.RestfulBooker.Framework.payloads.Auth;
import org.RestfulBooker.Framework.payloads.Booking;
import org.RestfulBooker.Framework.payloads.Bookingdates;

//import static org.RestfulBooker.Framework.endpoints.APIConstants.Password;
//import static org.RestfulBooker.Framework.endpoints.APIConstants.Username;

public class PayloadManager {
    public String createPayload(){

        String bookingPayload=null;

        Booking booking = new Booking();
        booking.setFirstname("Maheshwari");
        booking.setLastname("k");
        booking.setDepositpaid(true);
        booking.setTotalprice(1259);
        booking.setAdditionalneeds("Breakfast,Lunch");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2022-02-23");
        bookingdates.setCheckout("2023-02-28");

        booking.setBookingdates(bookingdates);

        Gson gson = new Gson();
        bookingPayload = gson.toJson(booking);
        return bookingPayload;
    }

//    public String createToken(){
//
//        String authpayload;
//
//        Auth auth = new Auth();
//        auth.setUsername(Username);
//        auth.setPassword(Password);
//
//        Gson gson = new Gson();
//        authpayload = gson.toJson(auth);
//        return authpayload;
//    }

        public String updatePayload(){

            String updatedpayload;

            Booking booking = new Booking();
            booking.setFirstname("Mahi");
            booking.setLastname("D");
            booking.setTotalprice(1550);
            booking.setDepositpaid(true);
            booking.setAdditionalneeds("Breakfast,Lunch & Dinner");

            Bookingdates bookingdates = new Bookingdates();
            bookingdates.setCheckin("2023-03-10");
            bookingdates.setCheckout("2023-03-17");

            booking.setBookingdates(bookingdates);

            Gson gson = new Gson();
            updatedpayload = gson.toJson(booking);
            return updatedpayload;
        }
}
