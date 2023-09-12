package day31_testNg_cucumber.cucumber.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MyStepdefs {

    int sum;
    @Given("^baslangic sayisi (\\d+)$")
    public void baslangicSayisi(int num) {

        sum = num;
    }

    @When("bu sayiya {int} eklendiginde")
    public void buSayiyaEklendiginde(int n) {

        sum += n;
    }

    @Then("sonuc {int} olmali")
    public void sonucOlmali(int total) {

        Assert.assertEquals(sum, total);
    }

    @And("sonuc uygun")
    public void sonucUygun() {

        System.out.println("metin");
    }

    @And("netice {string} olmali")
    public void neticeOlmali(String text) {

        System.out.println(text);
    }
}
