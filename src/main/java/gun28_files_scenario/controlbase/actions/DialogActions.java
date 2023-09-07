package gun28_files_scenario.controlbase.actions;

import gun28_files_scenario.controlbase.controls.DialogControl;
import gun28_files_scenario.controlbase.controls.DropDownControl;

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
