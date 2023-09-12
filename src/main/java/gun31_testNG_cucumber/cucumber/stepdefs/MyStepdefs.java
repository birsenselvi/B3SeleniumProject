package gun31_testNG_cucumber.cucumber.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MyStepdefs {

    /*
        "^basangic sayisi (\\d+)$"
        ^ : metnin basladigini
        $ : bitisini gösterri
        (\\d+) : regExp, d:sayi, +: 1 veya daha fazla
        regExp gösterimi

     */

    int sum;
    @Then("^basangic sayisi (\\d+)$")
    public void basangicSayisi(int num) {
        sum = num;
    }

    @When("bu sayiya {int} ekledigimde")
    public void buSayiyaEkledigimde(int n) {
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

    @Given("^sonuc (ALI|VELI) olmali$")
    public void sonucOlmali(String text) {
        System.out.println(text);
    }
}
