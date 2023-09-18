package day28_Orangehrm_control_yaml_properties.controlbase.actions;

import day28_Orangehrm_control_yaml_properties.controlbase.controls.ButtonControl;

public class ButtonActions {

    public static void click(String label){
        ButtonControl.fromLabel(label).click();
    }
}
