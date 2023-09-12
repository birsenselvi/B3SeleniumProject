package day28_Orangehrm_control.controlbase.actions;

import day28_Orangehrm_control.controlbase.utils.Config;
import day28_Orangehrm_control.controlbase.utils.ConfigReader;
import utils.Driver;

public class ApplicationActions {

    public static void launchUrl(){
        Config config = ConfigReader.getInstance();
        Driver.getDriver(config.getBrowser()).manage().window().maximize();
        Driver.getDriver(config.getBrowser()).get(config.getUrl());
    }
}
