package Bases;
import io.restassured.response.Response;
import org.testng.Assert;

public class ComunAsserts {

    /**@author
     * Rim Gammoudi
     */

    //Asserts useful for api tests checkups


    //Methode useful For assert Response Status
    public void assertResponseStatus(int statusCode, Response res)
    {
        Assert.assertEquals(res.statusCode(),statusCode,"Status code doesn't match The expected one");

    }

    //Methode useful For assert Parameter equal to value expected
    public void assertParameterEqualToExpectedValue(Object expectedParameter, Response res,String path)
    {
        Assert.assertEquals(res.path(path),expectedParameter,"The value found in the response doesn't match the expected one");
    }


    //Method useful For assert Parameter equal to value expected of certain
    public void assertParameterEqualToExpectedValueByIterate(Object expectedParameter, Response res,String path,int i)
    {
        Object j=res.jsonPath().get("[" + i + "]."+ path);
        Assert.assertEquals(j,expectedParameter,"The value found in the response doesn't match the expected one");
    }

    //Methode useful For assert parameter not null
    public void assertParameterNotNull(Object expectedParameter)
    {
        Assert.assertNotNull(expectedParameter,"The parameter is Null");
    }

    //Methode useful For assert Response Status
    public void assertParameterIsNull(Object expectedParameter)
    {
        Assert.assertNull(expectedParameter,"parameter is not null");
    }





}
