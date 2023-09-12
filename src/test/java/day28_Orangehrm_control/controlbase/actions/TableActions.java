package day28_Orangehrm_control.controlbase.actions;

import day28_Orangehrm_control.controlbase.controls.TableControl;

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
}
