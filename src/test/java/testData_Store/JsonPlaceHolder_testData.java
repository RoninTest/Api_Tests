package testData_Store;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolder_testData {

    public int statusCode=200;


    public JSONObject expectedData(){
        //Expected
        JSONObject body=new JSONObject();
        body.put("userId",3);
        body.put("id",22);

        return body;
    }

    public Map requestBodyMap(){

        Map<String,Object> mapReqData=new HashMap<>();
        mapReqData.put("title","API");
        mapReqData.put("body","Good at API");
        mapReqData.put("userId",10.0);
        mapReqData.put("id",80.0);

        return mapReqData;
    }


}
