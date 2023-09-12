package day31_testNg_cucumber.cucumber.stepdefs;

import io.cucumber.java.tr.Diyelimki;
import io.cucumber.java.tr.Eğerki;
import io.cucumber.java.tr.Ozaman;
import org.testng.Assert;

public class MyStepdefs1 {

    String str;
    String chr;
    @Diyelimki("metin {string} dir")
    public void metinDir(String metin) {
        System.out.println(metin + " kaydedildi");
        str = metin;
    }

    @Eğerki("metnin {int}.karakterini alirsam")
    public void metninKarakteriniAlirsam(int n) {
        System.out.println(str + "'nin "+ n + ". karakteri alindi");
        chr = str.charAt(n-1)+"";
    }

    @Ozaman("sonuc {string} olmali")
    public void sonucOlmali(String karakter) {
        System.out.println("Assert islemi yapildi");
        Assert.assertEquals(chr, karakter);
    }


}
