package day28_Orangehrm_control.controlbase.actions;

import day28_Orangehrm_control.controlbase.controls.DropDownControl;

public class DropDownActions {

    public static void select(String label, String option){
        DropDownControl
                .fromLabel(label)
                .select(option)
        ;
    }
}
