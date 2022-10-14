package baseURL_Store;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuBaseUrl {
    protected RequestSpecification specHeroku;

    @Before
    public void setUp(){
        specHeroku=new RequestSpecBuilder() //It is constructor for changing Interface
                .setBaseUri("https://restful-booker.herokuapp.com")
                .build();
    }
}
