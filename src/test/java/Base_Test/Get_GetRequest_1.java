package Base_Test;

import baseURL_Store.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData_Store.JsonPlaceHolder_testData;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get_GetRequest_1 extends JsonPlaceHolderBaseURL {

    /*

        "userId": 3,
        "id": 22,
        "title": "dolor sint quo a velit explicabo quia nam",
        "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"

     */
    @Test
    public void getTest00(){

        specJsonPlace.pathParams("pp1","posts","pp2",22);  //  https://jsonplaceholder.typicode.com/posts/22

        //Expected Data
        JsonPlaceHolder_testData jsonPlaceHolder=new JsonPlaceHolder_testData();
        JSONObject expBody=jsonPlaceHolder.expectedData();
        //Save Response
        Response response=given().spec(specJsonPlace).when().get("{pp1}/{pp2}");
        //writing response
        response.prettyPrint();
        //response Test
        JsonPath actBody=response.jsonPath(); //
        response.then().assertThat().contentType(ContentType.JSON);
        assertEquals(jsonPlaceHolder.statusCode,200);
        assertEquals(expBody.get("userId"),actBody.get("userId"));
        assertEquals(expBody.get("id"),actBody.get("id"));

    }
}
