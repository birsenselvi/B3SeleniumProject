package gun28_files_scenario.controlbase.tests;

import gun28_files_scenario.controlbase.actions.*;
import gun28_files_scenario.controlbase.utils.Config;
import gun28_files_scenario.controlbase.utils.ConfigReader;
import org.testng.annotations.Test;
import utils.Utils;

public class Test1 extends TestBase{

    Config config;

    @Test(groups = {"A"})
    public void gotoUrl() {
        config = ConfigReader.getInstance();
        ApplicationActions.launchUrl();
    }

    @Test(dependsOnMethods = "gotoUrl", groups = {"A"})
    public void login() {
        TextBoxActions.sendKeys("Username", config.getUsername());
        TextBoxActions.sendKeys("Password", config.getPassword());
        ButtonActions.click("Login");
    }

    @Test(dependsOnMethods = {"gotoUrl", "login"}, priority = 1)
    public void menu() {
        MenuActions.click("Admin");
        MenuActions.click("Leave");
    }

    @Test(dependsOnMethods = {"gotoUrl", "login"}, priority = 2)
    public void menuAdmin() {
        MenuActions.click("Admin");
        TextBoxActions.sendKeys("Username", "new User");
        ButtonActions.click("Search");
        ButtonActions.click("Reset");
    }

    @Test(dependsOnMethods = {"gotoUrl", "login"}, priority = 3, groups = {"A"})
    public void searchUser() {
        MenuActions.click("Admin");
        TextBoxActions.sendKeys("Username", "Cheeku");
        DropDownActions.select("User Role", "Admin");
        TextBoxActions.select("Employee Name", "Virat");
        DropDownActions.select("Status", "Enabled");
        ButtonActions.click("Search");
        TableActions.isExistInTable("Cheeku");

    }

    @Test(dependsOnMethods = {"gotoUrl", "login"}, priority = 4, groups = {"A", "B"})
    public void topMenuAction() {
        MenuActions.click("Admin");
        MenuActions.select("Job", "Job Titles");
        TableActions.check("Chief Executive Officer");
        TableActions.delete("Chief Executive Officer");
        DialogActions.close();
    }

    @Test(dependsOnMethods = {"gotoUrl", "login"}, priority = 5)
    public void menuHover() {
        MenuActions.hover("Admin");
        Utils.sleep(300);
        MenuActions.hover("Time");
        Utils.sleep(300);
        MenuActions.hover("My Info");
        Utils.sleep(300);
        MenuActions.click("Admin");
        MenuActions.hover("Job");
        Utils.sleep(300);
        MenuActions.hover("Nationalities");
        Utils.sleep(300);
    }
}
