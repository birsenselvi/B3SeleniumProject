package day28_Orangehrm_control.controlbase.actions;

import day28_Orangehrm_control.controlbase.controls.DialogControl;

public class DialogActions {

    public static void click(String label){
        DialogControl
                .find()
                .click(label);
    }

    public static void close(){
        DialogControl
                .find()
                .close();
    }
}
