package gun28_files_scenario.controlbase.actions;

import gun28_files_scenario.controlbase.utils.Config;
import gun28_files_scenario.controlbase.utils.ConfigReader;
import utils.Driver;

public class ApplicationActions {

    public static void launchUrl(){
        Config config = ConfigReader.getInstance();
        Driver.getDriver(config.getBrowser()).manage().window().maximize();
        Driver.getDriver(config.getBrowser()).get(config.getUrl());
    }
}
