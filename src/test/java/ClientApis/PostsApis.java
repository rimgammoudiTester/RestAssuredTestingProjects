package ClientApis;

import Bases.ApiGenericCalls;
import Config.ConfigManger;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;

public class PostsApis extends ApiGenericCalls {

 private final String BASE_URL_PROPERTY = "baseUrl";
 private final String POSTS_PROPERTY = "communPostPath";

 private String BaseUrl;
 private String EndPoint;

 ConfigManger configFile;
    /**@author Rim Gammoudi
     *
     */

    @BeforeClass
    public void extractEndpointUrls()
    {
     configFile=new ConfigManger();
     BaseUrl=configFile.getPropertyFile(BASE_URL_PROPERTY);
     EndPoint=BaseUrl+configFile.getPropertyFile(POSTS_PROPERTY);
    }

//method usefull for getting List of posts

    public Response recuperateAListOfPosts()
    {
        HashMap<String,Object>headersOfRequest=new HashMap<>();
        headersOfRequest.put("Content-Type","application/json");
        System.out.println(EndPoint);
      return  recuperateAllObject(BaseUrl,headersOfRequest,EndPoint);

    }

}
