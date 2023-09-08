package gun28_files_scenario.controlbase.actions;

import gun28_files_scenario.controlbase.controls.ButtonControl;

public class ButtonActions {

    public static void click(String label){
        ButtonControl.fromLabel(label).click();
    }

    public static String getText(String label){
        return ButtonControl.fromLabel(label).getText();
    }
}
