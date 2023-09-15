package gun35_runners_reports.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"aa"},
        glue = {"ggg"},
        plugin = {"pretty",
                "html:target/cucumber/cucumber.html",
                "json:target/cucumber/cucumber.json",
                "testng:target/cucumber/cucumber.xml"
        }

)
public class Runner1_systemProperty extends AbstractTestNGCucumberTests {
        {
                // System property'ye asagidaki degisken set edilirse
                // diger cucumber options'lari system property'den okunur
                // "cucumber.publish.quite"="true" olarak tanimlanmali
                System.setProperty("cucumber.publish.quite", "true");

                // cucumber.features : absolute path alir
                System.setProperty("cucumber.features", "D:\\Users\\IdeaProjects\\GuiderSoft\\e2etestautomation\\src\\main\\java\\gun35_runners_reports\\features\\Feature35.feature");

                // cucumber.glue : relative path alir
                System.setProperty("cucumber.glue", "gun35_runners_reports/stepdefs");

                System.setProperty("cucumber.filter.tags", "@regression");
                System.setProperty("cucumber.execution.dry-run", "true");
        }
}

/*
cucumber.execution.dry-run=     # true or false. default: false
cucumber.features=              # comma separated paths to feature files. example: path/to/example.feature, path/to/other.feature
cucumber.filter.name=           # regex. example: .*Hello.*
cucumber.filter.tags=           # tag expression. example: @smoke and not @slow
cucumber.glue=                  # comma separated package names. example: com.example.glue
cucumber.plugin=                # comma separated plugin strings. example: pretty, json:path/to/report.json
 */