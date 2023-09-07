package gun28_files_scenario.controlbase.actions;

import gun28_files_scenario.controlbase.controls.MenuControl;
import gun28_files_scenario.controlbase.controls.TextBoxControl;

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
