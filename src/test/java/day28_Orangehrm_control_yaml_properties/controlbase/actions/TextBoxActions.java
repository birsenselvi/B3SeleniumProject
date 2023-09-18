package day28_Orangehrm_control_yaml_properties.controlbase.actions;

import day28_Orangehrm_control_yaml_properties.controlbase.controls.TextBoxControl;

public class TextBoxActions {

    public static void sendKeys(String label, CharSequence...text){
        TextBoxControl
                .fromLabel(label)
                .sendKeys(text)
        ;
    }

    public static void select(String label, String option){
        TextBoxControl
                .fromLabel(label)
                .select(option)
        ;
    }
}
