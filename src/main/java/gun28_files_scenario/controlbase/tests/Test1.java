package gun28_files_scenario.controlbase.tests;

import gun28_files_scenario.controlbase.utils.Config;
import gun28_files_scenario.controlbase.utils.TestConfig;

public class Test1 {



    public static void main(String[] args) {
        Config config = TestConfig.getConfig();
        System.out.println("config.getUrl() = " + config.getUrl());
    }
}
