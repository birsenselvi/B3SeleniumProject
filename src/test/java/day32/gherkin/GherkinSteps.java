package day32.gherkin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GherkinSteps {
    @Given("{string} nin kilosu {int} TL")
    public void ninKilosuTL(String arg0, int arg1) {
    }

    @Then ("{string} fiyati {double} TL")
    public void fiyatiTL(String arg0, double arg1) {
    }

    @Then("Türkiyenin baskenti ankara dir")
    public void türkiyeninBaskentiAnkaraDir() {
    }

    @Then("sayilarimiz {double}{double}{double}{double} olsun")
    public void sayilarimizOlsun(int arg0, int arg1, int arg2, int arg3, int arg4) {
    }
}
