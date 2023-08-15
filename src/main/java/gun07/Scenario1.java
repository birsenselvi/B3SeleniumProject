package gun07;

import gun05.BaseClass;
import org.testng.annotations.Test;

public class Scenario1 extends BaseClass {

    /*
        https://demoqa.com/
        Elements linkine tiklayin
        Text Box'a tiklayin     // https://demoqa.com/text-box
        Acilan formu doldurun
        Submit butonuna tiklayin
        Girdiginiz verilerin fomun alt kisminda ciktigini dogrulayin
     */

    @Test
    public void test1Demoqa() {

        driver.get("https://demoqa.com/text-box");

    }


    /*
        1.---
        https://demoqa.com/
        Elements linkine tiklayin
        Web Tables'a tiklayin
        Last Name'i Vega olan kaydi silin.
        Kaydin silindigini assert edin



        2.---
        https://demoqa.com/
        Elements linkine tiklayin
        Web Tables'a tiklayin
        Last Name'i Vega olan kaydi edit edin.
        Acilan dialogbox daki formu gerekli bilgiler ile doldurun
        First Name'i degistirin
        Submit butonuna basin ve kayidi gücelleyin
        Is min güncellendigini asser edin.

        3.---
        https://demoqa.com/
        Elements linkine tiklayin
        Web Tables'a tiklayin
        Add butonuna tiklayin
        Acilan dialogbox daki formu gerekli bilgiler ile doldurun
        Submit butonuna basin ve kayit yapin
        Girdiginiz kaydi, Last Name'i kullanarak liste üzerindeki search ile aratin
        Aradaginiz kaydin listelendigini assert edin
        Kaydi edit edin
        Name'i degistirin
        Submit ile güncelleyin
        Ismin güncellendigini asser edin.
        Kaydi silin
        Kaydin silindigini assert edin

     */
}
