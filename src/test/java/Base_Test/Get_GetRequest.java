package Base_Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class Get_GetRequest {
    /*
    https://jsonplaceholder.typicode.com/posts/44
     */

    String url="https://jsonplaceholder.typicode.com/posts/44";
    JSONObject expectedBody;

    public void get_Request(){

        expectedBody=new JSONObject();
        expectedBody.put("userId",5);
        expectedBody.put("id",44);
        expectedBody.put("title","optio dolor molestias sit" );


    }
    @Test
    public void status_Code(){
        Response response=given().when().get(url);
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);
    }

    @Test
    public void response_Test(){

        get_Request();

        Response response=given().when().get(url);

        JsonPath actBody=response.jsonPath();
        Assert.assertEquals(expectedBody.get("userId"),actBody.get("userId"));
        Assert.assertEquals(expectedBody.get("title"),actBody.get("title"));
        Assert.assertEquals(expectedBody.get("id"),actBody.get("id"));

    }
}
