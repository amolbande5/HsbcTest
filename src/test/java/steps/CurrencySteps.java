package steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.testng.Assert;
import utilities.APIConstant;
import utilities.RestAPIExecuter;

public class CurrencySteps {
    private ResponseOptions<Response> response;
    RestAPIExecuter method;


    @Given("^Rates API for Latest Foreign Exchange rates \"([^\"]*)\"$")
    public void ratesAPIForLatestForeignExchangeRates(String uri) throws Throwable {
        method = new RestAPIExecuter(uri, APIConstant.ApiMethods.GET);
    }

    @When("^The API is available$")
    public ResponseOptions<Response> theAPIIsAvailable() {

        response = method.getCall();
        return response;
    }


    @Then("^An automated test suite should run which will assert the success status of the response$")
    public void anAutomatedTestSuiteShouldRunWhichWillAssertTheSuccessStatusOfTheResponse() {

        Assert.assertEquals(response.getStatusCode(), 200);

    }


    @Then("^An automated test suite should run which will assert the response$")
    public void anAutomatedTestSuiteShouldRunWhichWillAssertTheResponse() {
        Assert.assertEquals(response.getBody().asString(), "Error: Requested URL /api/latest HTTP/2 not found");
    }

    @When("^An incorrect or incomplete url is provided$")
    public ResponseOptions<Response> anIncorrectOrIncompleteUrlIsProvided() {

        response = method.getCall();
        return response;
    }

    @Then("^Test case should assert the correct supplied response by the call$")
    public void testCaseShouldAssertTheCorrectSuppliedResponseByTheCall() {

        Assert.assertEquals(response.getBody().asString(), "{\"error\":\"time data 'api' does not match format '%Y-%m-%d'\"}");

    }

    @Given("^Rates API for Specific dateForeign Exchange rates \"([^\"]*)\"$")
    public void ratesAPIForSpecificDateForeignExchangeRates(String uri) throws Throwable {
        method = new RestAPIExecuter(uri, APIConstant.ApiMethods.GET);
    }

    @Then("^An automated test suite should run which will assert the response date$")
    public void anAutomatedTestSuiteShouldRunWhichWillAssertTheResponseDate() {
        JsonPath path = new JsonPath(response.getBody().asString());
        String date = path.get("date");
        System.out.println(date);
        Assert.assertEquals(date,"2010-01-12");
    }

    @Then("^An automated test suite should run which will validate that the response matches for the current date$")
    public void anAutomatedTestSuiteShouldRunWhichWillValidateThatTheResponseMatchesForTheCurrentDate() {
        JsonPath path = new JsonPath(response.getBody().asString());
        String date = path.get("date");
        System.out.println(date);
        Assert.assertEquals(date,"2010-01-13");
    }
}
