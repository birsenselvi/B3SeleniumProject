package gun28_files_scenario.controlbase.actions;

import gun28_files_scenario.controlbase.controls.TableControl;
import gun28_files_scenario.controlbase.controls.TextBoxControl;

public class TableActions {

    public static void check(String label){
        TableControl
                .findRowWithText(label)
                .check();
    }

    public static void delete(String label){
        TableControl
                .findRowWithText(label)
                .delete();
    }

    public static void edit(String label){
        TableControl
                .findRowWithText(label)
                .edit();
    }

    public static void isExistInTable(String label){
        TableControl
                .findRowWithText(label);
    }
}
