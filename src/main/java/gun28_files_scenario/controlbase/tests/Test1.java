package gun28_files_scenario.controlbase.tests;

import gun28_files_scenario.controlbase.actions.ApplicationActions;
import gun28_files_scenario.controlbase.actions.ButtonActions;
import gun28_files_scenario.controlbase.actions.TextBoxActions;
import gun28_files_scenario.controlbase.utils.Config;
import gun28_files_scenario.controlbase.utils.ConfigReader;
import org.testng.annotations.Test;

public class Test1 {


    @Test
    public void gotoUrl() {
        Config config = ConfigReader.getInstance();
        ApplicationActions.launchUrl();
        TextBoxActions.sendkeys("Username", config.getUsername());
        TextBoxActions.sendkeys("Password", config.getPassword());
        ButtonActions.click("Login");
        ButtonActions.click("Admin");
        ButtonActions.click("Leave");
        ButtonActions.click("Admin");
        TextBoxActions.sendkeys("Username", "New User");
        ButtonActions.click("Search");
        ButtonActions.click("Reset");
    }
}
