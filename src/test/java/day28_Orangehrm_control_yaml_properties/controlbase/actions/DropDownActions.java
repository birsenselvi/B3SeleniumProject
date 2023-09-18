package day28_Orangehrm_control_yaml_properties.controlbase.actions;

import day28_Orangehrm_control_yaml_properties.controlbase.controls.DropDownControl;

public class DropDownActions {

    public static void select(String label, String option){
        DropDownControl
                .fromLabel(label)
                .select(option)
        ;
    }
}
