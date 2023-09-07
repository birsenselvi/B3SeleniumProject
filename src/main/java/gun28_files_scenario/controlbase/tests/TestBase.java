package gun28_files_scenario.controlbase.tests;

import gun28_files_scenario.controlbase.utils.Config;
import gun28_files_scenario.controlbase.utils.ConfigReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Driver;

public class TestBase {

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(@Optional("") String browser){
        if (browser.length()==0) {
            Config config = ConfigReader.getInstance();
            Driver.getDriver(config.getBrowser());
        }else{
            Driver.getDriver(browser);
        }
    }


    @AfterTest
    public void afterTest(){
        Driver.quit();
    }
}
