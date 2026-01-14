package ClientApisTests;

import Bases.ComunAsserts;
import ClientApis.PostsApis;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PostsTests extends PostsApis {

    /**@Author Rim Gammoudi**/


    //method useful for testing the function of api "recuperate a list of posts
   /* @Test()
    public void recuperateListOfPosts()
    {
        int LengthObjects;
        Response res=recuperateAListOfPosts();
        ComunAsserts assertClass=new ComunAsserts();
        System.out.println(res.getBody().asString());
        assertClass.assertResponseStatus(200,res);
        assertClass.assertParameterNotNull(res.getBody());
        assertClass.assertParameterNotNull(res.getBody().path("userId"));
        assertClass.assertParameterNotNull(res.getBody().path("id"));
        assertClass.assertParameterNotNull(res.getBody().path("title"));
        assertClass.assertParameterNotNull(res.getBody().path("body"));
        int  jes=res.jsonPath().getList("$").size();
        System.out.println(jes);
        for (int i=1;i<=jes;i++)
        {
            int j=i-1;
           assertClass. assertParameterEqualToExpectedValueByIterate(i,res,"id",j);
        }
        //validate schema
        res.then().assertThat().body(matchesJsonSchemaInClasspath("posts-schema.json"));

    }*/
    @Test
    @Description("Test to recuperate a list of posts and validate the response")
    public void recuperateListOfPosts() {
        Response res = recuperateAListOfPosts();
        validateResponse(res);
    }

    @Step("Validate API response and fields")
    private void validateResponse(Response res) {
        ComunAsserts assertClass = new ComunAsserts();
        System.out.println(res.getBody().asString());
        assertClass.assertResponseStatus(200, res);
        assertClass.assertParameterNotNull(res.getBody());
        assertClass.assertParameterNotNull(res.getBody().path("userId"));
        assertClass.assertParameterNotNull(res.getBody().path("id"));
        assertClass.assertParameterNotNull(res.getBody().path("title"));
        assertClass.assertParameterNotNull(res.getBody().path("body"));

        int listSize = res.jsonPath().getList("$").size();
        System.out.println(listSize);

        for (int i = 1; i <= listSize; i++) {
            int j = i - 1;
            assertClass.assertParameterEqualToExpectedValueByIterate(i, res, "id", j);
        }

        // Validate schema
        res.then().assertThat().body(matchesJsonSchemaInClasspath("posts-schema.json"));
    }

}
