package Base_Test;
import baseURL_Store.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import testData_Store.JsonPlaceHolder_testData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class Api_Deserializastion extends JsonPlaceHolderBaseURL {

/*
base request-->
{
    "title":"API",
    "body":"Good at Api",
    "userId":10,
    "id":80
}

expected data -->
{
    "title": "API",
    "body": "Good at Api",
    "userId": 10,
    "id": 80
}
 */

    @Test
    public void Test01(){

        //PUT method
        //1-Create URL and Request Body
        //URL
        specJsonPlace.pathParams("p1","posts","p2",80);

        //Request Data
        JsonPlaceHolder_testData jsonPlaceHolderTestData=new JsonPlaceHolder_testData();
        Map<String,Object> requestBody=jsonPlaceHolderTestData.requestBodyMap();
        System.out.println(requestBody);

        //2-Expected Data
        Map<String,Object> expDataMap=jsonPlaceHolderTestData.requestBodyMap();

        //3-Response Data
        Response response=given()
                .contentType(ContentType.JSON)
                .spec(specJsonPlace)
                .when()
                .body(requestBody)
                .put("{p1}/{p2}");

        response.prettyPrint();

        //4- From JSON to Map
        Map<String,Object> resBodyMap=response.as(HashMap.class);
        System.out.println(resBodyMap);

        //5-Assertion
        assertEquals(jsonPlaceHolderTestData.statusCode,200);
        assertEquals(expDataMap.get("title"),resBodyMap.get("title"));
        assertEquals(expDataMap.get("id"),resBodyMap.get("id"));
        assertEquals(expDataMap.get("body"),resBodyMap.get("body"));
        assertEquals(expDataMap.get("userId"),resBodyMap.get("userId"));

    }
}
