package day33.listFeature;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class MyStepdefs {

    int num;

    @Given("initial value is {int}")
    public void initialValueIs(int num) {

        this.num = num;

    }

    @When("user add the following numbers")
    public void userAddTheFollowingNumbers(DataTable table) {

        List<Integer> numbers = table.asList(Integer.class);
        numbers.forEach(n -> num += n);

    }

    @Then("sum should be {int}")
    public void sumShouldBe(int sum) {

        Assert.assertEquals(num, sum);

    }
}
