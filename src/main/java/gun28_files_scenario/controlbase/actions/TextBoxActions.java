package gun28_files_scenario.controlbase.actions;

import gun28_files_scenario.controlbase.controls.TextBoxControl;

public class TextBoxActions {

    public static void sendkeys(String label, CharSequence...text){
        TextBoxControl
                .fromLabel(label)
                .sendkeys(text)
        ;
    }
}
