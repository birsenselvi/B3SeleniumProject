package gun33_cucumber_tags.tags.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/java/gun33_cucumber/tagsHooks/feature"},
        glue = {"gun33_cucumber_tags/tags/stepdefs"},
        //tags = "@smoke"
        //tags = "@smoke or @temp"
        //tags = "@smoke and @temp"
        //tags = "@smoke and not @temp"
        //tags = "@genel"
        //tags = "@genel and not @smoke"
        //tags = "@genel and @regression"
        tags = "not @genel and @regression"
)
public class Runner extends AbstractTestNGCucumberTests {
}

