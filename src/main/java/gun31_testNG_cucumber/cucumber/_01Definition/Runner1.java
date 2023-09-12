package gun31_testNG_cucumber.cucumber._01Definition;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// Cucumber'in feature, stepdefs, plugins gibi özelliklerinin
// tanimlandigi yerdir
@CucumberOptions(
        // feature'larin yolu proje root'indan itibaren alinir
        // featureler proje icinde herhangi klasörde olabilir
        features = {"src/main/java/gun31_testNG_cucumber/cucumber/_01Definition/MyFirstFeature.feature"},

        // glue == stepdefs'lerin yolu java'dan itibaren alinir. Bunlar class'lardir ve java'nin altindadir
        glue = {"gun31_testNG_cucumber/cucumber/stepdefs"}
)
public class Runner1 extends AbstractTestNGCucumberTests {


}
