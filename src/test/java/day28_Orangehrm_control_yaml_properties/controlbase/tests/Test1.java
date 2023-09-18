package day28_Orangehrm_control_yaml_properties.controlbase.tests;

import day28_Orangehrm_control_yaml_properties.controlbase.actions.*;
import day28_Orangehrm_control_yaml_properties.controlbase.utils.Config;
import day28_Orangehrm_control_yaml_properties.controlbase.utils.ConfigReader;
import org.testng.annotations.Test;
import utils.Utils;

public class Test1 {

    Config config;

    @Test
    public void gotoUrl() {
        config = ConfigReader.getInstance();
        ApplicationActions.launchUrl();
    }

    @Test(dependsOnMethods = "gotoUrl")
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

    @Test(dependsOnMethods = {"gotoUrl", "login"}, priority = 3)
    public void searchUser() {
        MenuActions.click("Admin");
        TextBoxActions.sendKeys("Username", "Alice.Duval");
        DropDownActions.select("User Role", "ESS");
        TextBoxActions.select("Employee Name", "Alice");
        DropDownActions.select("Status", "Enabled");
        ButtonActions.click("Search");
    }

    @Test(dependsOnMethods = {"gotoUrl", "login"}, priority = 4)
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
    @Test(dependsOnMethods = {"gotoUrl", "login"}, priority = 6)
    public void checkboxAction()
    {
        MenuActions.click("Admin");
        MenuActions.select("Configuration", "Modules");
        CheckboxActions.checkbox1("Performance Module");
        Utils.sleep(1000);
        CheckboxActions.checkbox1("Directory Module");
        Utils.sleep(1000);
        CheckboxActions.checkbox1("Maintenance Module");
        Utils.sleep(1000);
        ButtonActions.click(" Save ");
        CheckboxActions.controll("Performance Module");

    }
}
