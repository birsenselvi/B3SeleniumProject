package gun26_testng_extentreport;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGReportListener {
    /*
        Menü -> Run -> Edit Configuration
        Sol taraftan ilgili Test classi secilir
        Sag tarafta Listener Tabi secilir
        Alttaki + ya tiklanir
        Acilan kutuda "reporter" yazilir
        Listelenen eklentilerden "eMailable reporter" secilir
        Apply -> Ok

        Sonra ilgili Test Class'i run edilir

        project root'da "test-output" klasörü altinda "emailable-report.html" olusturulur

     */

    @Test
    public void test1(){

        Assert.assertEquals(1, 1);

    }

    @Test
    public void test2(){
        Assert.assertEquals(1, 2);
    }

    @Test
    public void test3(){
        Assert.assertEquals(2, 2);
    }
}
