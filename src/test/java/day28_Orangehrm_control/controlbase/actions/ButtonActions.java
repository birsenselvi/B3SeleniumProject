package day28_Orangehrm_control.controlbase.actions;

import day28_Orangehrm_control.controlbase.controls.ButtonControl;

public class ButtonActions {

    public static void click(String label){
        ButtonControl.fromLabel(label).click();
    }
}
