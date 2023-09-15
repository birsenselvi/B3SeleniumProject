package gun34_hooks_scenarioOutline.scenarioOutline2.stepdefs;

import gun34_hooks_scenarioOutline.scenarioOutline2.pageobjects.SdPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BaseTest;

import java.util.Map;

public class SdSteps {

    SdPage page = new SdPage();

    @Given("sd user navigate to homepage")
    public void sdUserNavigateToHomepage() {
        page.gotoPage();
    }

    @When("sd user try to login with the following credentials")
    public void sdUserTryToLoginWithTheFollowingCredentials(DataTable table) {
        Map<String, String> map = table.asMap();
        String username = map.get("username");
        String password = map.get("password");
        page.login(username, password);
    }

    @Then("login should be {string}")
    public void loginShouldBe(String result) {

        if (result.equalsIgnoreCase("true")){
            page.loginSuccessful(true);
        } else {
            page.loginSuccessful(false);
        }
    }
}
