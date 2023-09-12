package day28_Orangehrm_control.controlbase.actions;

import day28_Orangehrm_control.controlbase.controls.TextBoxControl;

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
