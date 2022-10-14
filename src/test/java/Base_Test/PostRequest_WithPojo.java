package Base_Test;

import baseURL_Store.HerokuBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Booking;
import pojos.Bookingdates;
import pojos.Bookingid;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostRequest_WithPojo extends HerokuBaseUrl {

/* ***********************************************************
                         REQUEST BODY
**************************************************************
Method : POST --> https://restful-booker.herokuapp.com/booking
Request :
{
    "firstname" : "Alieren",
    "lastname" : "Dasdemir",
    "totalprice" : 10000,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2022-10-10",
        "checkout" : "2022-10-15"
    }
}
****************************************************************
                       RESPONSE BODY
/***************************************************************
Response :
{
    "bookingid": 3570,
    "booking": {
        "firstname": "Alieren",
        "lastname": "Dasdemir",
        "totalprice": 10000,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2022-10-10",
            "checkout": "2022-10-15"
        }
    }
}
*******************************************************************/
/*  4 MAIN CHORES :
    1. CREATE URL AND REQ BODY
    2. CREATE EXPECTED DATA
    3. SAVE RESPONSE
    4. ASSERTIONS
 */

    @Test
    public void Test001(){
        //1. CREATE URL AND REQ BODY
        specHeroku.pathParam("pp1","booking");

        Bookingdates bookingdates=new Bookingdates("2022-10-10","2022-10-15");

        Booking booking=new Booking("alieren","dasdemir",1500,true,bookingdates);
        System.out.println(booking);

        //2. SAVE RESPONSE
        Response response=given()
                .contentType(ContentType.JSON)
                .spec(specHeroku)
                .when()
                .body(booking)
                .post("{pp1}");
        response.prettyPrint();


        Bookingid responseBody=response.as(Bookingid.class);

        //4. ASSERTIONS

        assertEquals(200,response.statusCode());
        assertEquals(booking.getFirstname(),responseBody.getBooking().getFirstname());
        assertEquals(booking.getLastname(),responseBody.getBooking().getLastname());
        assertEquals(booking.getTotalprice(),responseBody.getBooking().getTotalprice());
        assertEquals(booking.isDepositpaid(),responseBody.getBooking().isDepositpaid());
        assertEquals(booking.getBookingdates().getCheckin(),responseBody.getBooking().getBookingdates().getCheckin());
        assertEquals(booking.getBookingdates().getCheckout(),responseBody.getBooking().getBookingdates().getCheckout());

    }


}
