package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //getter setter
//@NoArgsConstructor  //no parameter const
//@AllArgsConstructor // parameter const
@JsonIgnoreProperties (ignoreUnknown = true)

public class Bookingdates {

/* *******************************
         PIECE OF RESPONSE 1 helper : https://www.jsonschema2pojo.org/
**********************************
       "bookingdates" : {
        "checkin" : "2022-10-10",
        "checkout" : "2022-10-15"
    }
***************************** */

    private String checkin;
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }


    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public Bookingdates() {
    }

    public Bookingdates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }



    @Override
    public String toString() {
        return "Bookingdates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
