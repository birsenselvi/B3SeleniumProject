package day28_Orangehrm_control_yaml_properties.controlbase.actions;

import day28_Orangehrm_control_yaml_properties.controlbase.utils.Config;
import day28_Orangehrm_control_yaml_properties.controlbase.utils.ConfigReader;
import utils.Driver;

public class ApplicationActions {

    public static void launchUrl(){
        Config config = ConfigReader.getInstance();
        Driver.getDriver(config.getBrowser()).manage().window().maximize();
        Driver.getDriver(config.getBrowser()).get(config.getUrl());
    }
}
