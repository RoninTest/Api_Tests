package baseURL_Store;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseURL {

    //RequestSpecification is an interface so when we called specJsonPlace doesn't work.
    //Interfaces have not a const also Interfaces can't create an object.
    //Then we must write some code.

   protected RequestSpecification specJsonPlace;

   @Before
    public void setUp(){

       specJsonPlace=new RequestSpecBuilder() //constructor
               .setBaseUri("https://jsonplaceholder.typicode.com")
               .build();
   }

}
