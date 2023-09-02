package day17_ShadowDom;

import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotClass {
    // File upload icin kullanilabilir. ama kullanilabilmesi icin sayfanin aktif olmasi lazim

    // java awt nin robot class' i ekrana müdahale edebilir
    // sayfadaki elementleri anlamaz.
    // Klavye ve mouse islemleri yapilabilir.
    @Test
    public void robot1() throws AWTException {
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);

        robot.keyRelease(KeyEvent.VK_CONTROL);

    }
}
