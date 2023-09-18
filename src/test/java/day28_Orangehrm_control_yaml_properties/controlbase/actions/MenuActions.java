package day28_Orangehrm_control_yaml_properties.controlbase.actions;

import day28_Orangehrm_control_yaml_properties.controlbase.controls.MenuControl;

public class MenuActions {

    public static void click(String label, CharSequence...text){
        MenuControl
                .fromLabel(label)
                .click();
    }

    public static void select(String label, String option){
        MenuControl
                .fromLabel(label)
                .select(option);
    }

    public static void hover(String label){
        MenuControl.fromLabel(label).hover();
    }
}
