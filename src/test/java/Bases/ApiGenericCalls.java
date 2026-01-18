package Bases;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class ApiGenericCalls {
    Response res;

    //setUp headers of a request

    public RequestSpecification setRequest(String baseUrl, HashMap<String, Object> headers) {
      RequestSpecification  req = given().baseUri(baseUrl).headers(headers).when().contentType(ContentType.JSON);
        return req;
    }

    //Method for recuperate  list of Objects
    protected Response recuperateAllObject(String baseUrl,HashMap<String,Object>map,String getEndpoint) {
       RequestSpecification req = setRequest(baseUrl, map);
        res = req.get(getEndpoint);
        res.then().log().all();
        return res;
    }

    //Method for recuperate an object by pathParameter (By id)
    protected Response recuperateAnObjectById(String baseUrl,HashMap<String, Object> map, String getEndpoint, int id) {
       RequestSpecification req = setRequest(baseUrl, map).pathParam("id",id);
        res = req.get(getEndpoint);
        res.then().log().all();
        return res;
    }

    //Method for recuperate an object by QueryParameter (By id)
    Response recuperateObjectByParamterKey(String baseUrl, HashMap<String, Object> map, String getEndpoint, HashMap<String,Object>parameters) {
       RequestSpecification req = setRequest(baseUrl, map).queryParams(parameters);
        res = req.get(getEndpoint);
        res.then().log().all();
        return res;
    }

    //Method for creating Objects
    Response createAnObject(String baseUrl, HashMap<String, Object> map, String postEndpoint, HashMap<String, Object> payloadToSent) {
       RequestSpecification req = setRequest(baseUrl, map).body(payloadToSent);
        res = req.post(postEndpoint);
        res.then().log().all();
        return res;
    }

    //Method for creating Objects
    Response modifyAnObject(String baseUrl, HashMap<String, Object> map, String putEndpoint, HashMap<String, Object> payloadToSent) {
      RequestSpecification  req = setRequest(baseUrl, map).body(payloadToSent);
        res = req.put(putEndpoint);
        res.then().log().all();
        return res;
    }

    //Method for creating Objects
    Response patchCallApi(String baseUrl, HashMap<String, Object> map, String patchEndpoint, HashMap<String, Object> payloadToSent) {
       RequestSpecification req = setRequest(baseUrl, map).body(payloadToSent);
        res = req.patch(patchEndpoint);
        res.then().log().all();
        return res;
    }

    //Method for Deleting Objects
    Response deleteAnObject(String baseUrl, HashMap<String, Object> map, String deleteEndpoint, int id) {
      RequestSpecification  req = setRequest(baseUrl, map).pathParam("id", id);
        res = req.delete(deleteEndpoint);
        res.then().log().all();
        return res;
    }

}
