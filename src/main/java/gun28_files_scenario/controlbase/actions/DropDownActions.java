package gun28_files_scenario.controlbase.actions;

import gun28_files_scenario.controlbase.controls.DropDownControl;
import gun28_files_scenario.controlbase.controls.TextBoxControl;

public class DropDownActions {

    public static void select(String label, String option){
        DropDownControl
                .fromLabel(label)
                .select(option)
        ;
    }
}
