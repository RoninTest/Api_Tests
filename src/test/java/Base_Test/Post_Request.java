package Base_Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Post_Request {

    @Test
    public void post01(){

        //https://jsonplaceholder.typicode.com/posts
        /*
     {
    "title": "API",
    "body": "Good at Api",
    "userId": 10,
    "id": 101  //
      }
         */
        //Create request and body

        String url="https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody=new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","Good at Api");
        reqBody.put("userId",10);

        //2- Expected Data

        JSONObject expBody=new JSONObject();
        expBody.put("title","API");
        expBody.put("body","Good at Api");
        expBody.put("userId",10);

        //3- Save Response

        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .post(url);

        JsonPath actBody=response.jsonPath();

        response.
                then().
                assertThat().
                statusCode(201);
        response.
                then().
                contentType(ContentType.JSON);

        //4 - Assertion
        Assert.assertEquals(expBody.get("title"),actBody.get("title"));
        Assert.assertEquals(expBody.get("body"),actBody.get("body"));
        Assert.assertEquals(expBody.get("userId"),actBody.get("userId"));

    }
}
