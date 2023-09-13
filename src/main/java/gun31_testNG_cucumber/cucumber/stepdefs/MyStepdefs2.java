package gun31_testNG_cucumber.cucumber.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.tr.Diyelimki;
import io.cucumber.java.tr.Eğerki;
import io.cucumber.java.tr.Ozaman;
import org.testng.Assert;

public class MyStepdefs2 {
    @Diyelimki("metin {string} dir")
    public void metinDir(String arg0) {
    }

    @Eğerki("metnin {int}.karakterini alirsam")
    public void metninKarakteriniAlirsam(int arg0) {
    }

    @Ozaman("sonuc {string} olmali")
    public void sonucOlmali(String arg0) {
    }
}
