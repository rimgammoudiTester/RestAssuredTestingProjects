package ClientApisTests;
import Bases.ComunAsserts;
import ClientApis.TodosApis;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TodosTests extends TodosApis {
    private static final int ID = 2;
    private String id = "id";
    private String title = "title";
    private String completed = "completed";
    Response res;
    ComunAsserts Asserts;

    @BeforeMethod()
    public void intializeClasses() {
        res = recuperateAListOfTodos();
        Asserts = new ComunAsserts();
    }

    //Method to get the size of an Response objects
    public int getTheResponseObject() {
        return res.jsonPath().getList("$").size();
    }

    //Method To extract The response of a Todos by id
    public Response getToDosById() {
        return res = recuperateATodosById(ID);
    }

    @Test()
    @Description("Test useful for assuming That the Todos return 200")
    public void recuperateTheTodos() {
        Asserts.assertResponseStatus(200, res);
        System.out.println(res.body().asPrettyString());
    }

    @Test()
    @Description("Test To validate the right schema of an object")
    public void validateTheSchemaOfTodosObject() {
        res.then().assertThat().body(matchesJsonSchemaInClasspath("todos.json"));

    }

    @Test()
    @Description("Test To validate the corectness of Id's value ")
    public void validateTheValueOfId() {
        int jse2 = getTheResponseObject();
        for (int index = 0; index < jse2; index++) {
            int j;
            j = index + 1;
            Asserts.assertParameterEqualToExpectedValueByIterate(j, res, "id", index);
        }
    }

    @Test()
    @Description("Test To assume that completed parameter is either true or false")
    public void validateThatTheTypeOfTheParameterCompletedIsBoolean() {

        int jse2 = getTheResponseObject();
        for (int index = 0; index < jse2; index++) {
            boolean completedParameter = Asserts.verifyTheTypeOfParameter(res, "completed", index, "Boolean");
            Asserts.assertTheTypeParameterIstrue(completedParameter);
        }

    }


    @Test()
    @Description("validate the Response ToDosById Schema")
    public void recuperateATodosById() {
        res = getToDosById();
        res.then().assertThat().body(matchesJsonSchemaInClasspath("todos-schema-ById.json"));
        System.out.println(res.body().asPrettyString());
    }

    @Test()
    @Description("validate The parameters not null")
    public void verifyTheParameterOfTheJsonTodosIsNotNull() {
        res = getToDosById();
        Asserts.assertParameterNotNull(res.getBody().path(id));
        Asserts.assertParameterNotNull(res.getBody().path(title));
        Asserts.assertParameterNotNull(res.getBody().path(completed));
    }

    @Test()
    @Description("The Id's value should be correct")
    public void theValueOfTheIdShouldBeCorrect() {
        res = getToDosById();
        Asserts.assertParameterEqualToExpectedValue(ID, res, id);
    }


    @Test()
    @Description("The value of completed  should be false")
    public void theValueOfCompletedShouldBeFalse() {
        res = getToDosById();
        Assert.assertFalse(res.path(completed));
    }
}
