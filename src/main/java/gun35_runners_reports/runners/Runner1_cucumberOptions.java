package gun35_runners_reports.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        // feature yolu content rootdan itibaren verilir
        // feature dosyalari HDD'nin herhangi vir yerinde olabilir
        // virgül ile ayrilmis sekilde array olarak belirtilir
        //features = {"src/main/java/gun35_runners_reports/features", "d:/"},
        features = {"src/main/java/gun35_runners_reports/features"},

        // stepdefs yoludur. Source root da itibaren belirtilir,
        // java class'i olduklari icin
        glue = {"gun35_runners_reports/stepdefs"},

        // scenario taglari
        //tags = "@smoke",

        // consol output'unun renkli ya da monocrom olmasi
        monochrome = false,

        // senario ismine göre run eder
        //name = {"Scenario 1"},    // Scenario adi : "Scenario 1" olan run edilecek
        //name = {"Scenario 1", "Scenario 2"},
        // ".*smoke" : smoke ile biten
        // "smoke.*" : smoke ile baslayan
        // ".*smoke.*" : smoke iceren
        name = {".*1.*", ".*2.*"},       // Scenario adi icinde 1 gecen scenariolar run edilecek

        // sadece feature da tanimli steplerin stepdefs'leri var mi onu kontrol eder
        // stepler düzenli tanimlanmis midir
        dryRun = false,

        // olusturulan rapor cucumber sitesinde 1 günlügüne ulasilabilir olarak yayinlanir
        //publish = true,

        plugin = {"pretty",
                "html:target/cucumber/cucumber.html",
                "json:target/cucumber/cucumber.json",
                "testng:target/cucumber/cucumber.xml"
        }

)
public class Runner1_cucumberOptions extends AbstractTestNGCucumberTests {
}
