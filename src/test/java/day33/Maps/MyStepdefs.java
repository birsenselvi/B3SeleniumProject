package day33.Maps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class MyStepdefs {

    List<String> cities;
    List<List<String>> allCities;

    int count;

    @Given("my String is as follows")
    public void myStringIsAsFollows(DataTable table) {

        cities = table.asList();

    }

    @When("my data is as follows")
    public void myDataIsAsFollows(DataTable table) {

        allCities = table.asLists();

    }

    @Then("the count of the cties are {int}")
    public void theCountOfTheCtiesAre(int sum) {

        for (String city : cities) {
            for (List<String> allCity : allCities) {
                for (String s : allCity) {
                    if (s.equalsIgnoreCase(city)) {
                        count++;
                    }
                }
            }
        }
        Assert.assertEquals(count, sum);
    }
}
