package gun32_cucumber.variables;

import io.cucumber.java.en.Given;

public class GherkinSteps {
    @Given("{string}nin kilosu {int} TL")
    public void ninKilosuTL(String arg0, int arg1) {
        System.out.println("1: " + arg0 + " , " + arg1);
    }

    @Given("{string} fiyati {double} TL")
    public void fiyatiTL(String arg0, double arg1) {
        System.out.println("2: " + arg0 + " , " + arg1);
    }

    @Given("Türkiyenin baskenti ankaradir")
    public void türkiyeninBaskentiAnkaradir() {
        System.out.println("3:");
    }

    @Given("Türkiyenin baskenti {string} dir")
    public void türkiyeninBaskentidir(String arg0) {
        System.out.println("5:" + arg0);
    }

    @Given("sayilarimiz {int}, {int}, {int}, {int}, {int} olsun")
    public void sayilarimizOlsun(int arg0, int arg1, int arg2, int arg3, int arg4) {
        System.out.println("4:" + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4);
    }

}
