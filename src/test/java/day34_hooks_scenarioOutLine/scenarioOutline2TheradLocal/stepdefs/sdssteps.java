package day34_hooks_scenarioOutLine.scenarioOutline2TheradLocal.stepdefs;

import day34_hooks_scenarioOutLine.scenarioOutline2TheradLocal.pom.SDPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class sdssteps {
    SDPage page = new SDPage();
    @Given("sd user navigate to homepage")
    public void sdUserNavigateToHomepage() {
        page.gotoHome();
    }

    @When("sd user try to login with the following credentials")
    public void sdUserTryToLoginWithTheFollowingCredentials(DataTable tabel) {
        Map<String, String> map =tabel.asMap();
        String username = map.get("username");
        String password = map.get("password");
        page.sendKeys(page.username,username);
        page.sendKeys(page.password,password);
        page.click(page.login);
    }

    @Then("login should be {string}")
    public void loginShouldBe(String result) {
        if(result.equalsIgnoreCase("true")){
        page.waitforVisibility(page.cartContainer);
        }else{
            page.waitforVisibility(page.errorMessage);
        }
    }
}
