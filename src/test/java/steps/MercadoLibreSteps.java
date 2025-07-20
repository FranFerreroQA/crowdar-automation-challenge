package steps;

import api.MercadoLibre;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.List;
import java.util.Map;

public class MercadoLibreSteps {

    private Response response;

    @When("I request the departments from Mercado Libre")
    public void iRequestTheDepartments() {
        response = MercadoLibre.getDepartments();
    }

    @Then("the response should contain a list of departments")
    public void theResponseShouldContainDepartments() {
        Assert.assertEquals("The status was not as expected", 200, response.getStatusCode());

        List<Map<String, Object>> departments = response.jsonPath().getList("departments");
        Assert.assertNotNull("Departments list should not be null", departments);
        Assert.assertTrue("There should be at least one department", departments.size() > 0);
    }

}
