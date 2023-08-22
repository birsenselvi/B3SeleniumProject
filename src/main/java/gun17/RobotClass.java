package gun17;

import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotClass {


    // java awt'nin robot class'i
    // ekrana müdahale edebilir.
    // Klavye ve mouse islemleri yapilabilir
    // sayfadaki elementleri anlamaz
    //

    @Test
    public void robotClass1() throws AWTException {
        // Robot class tanimi
        Robot robot = new Robot();

        // asagidaki satir CTRL tusuna basar. Eger keyRelease yaplazsaniz CTRL basili kalir
        robot.keyPress(KeyEvent.VK_CONTROL);

        // CTRL release edildi.
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // robot class aktif oldugu yerde islem yapar
        robot.keyPress(KeyEvent.VK_A);

        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('x'));

        write("Guidersoft");


    }

    public void write(String str) throws AWTException {
        Robot robot = new Robot();
        for (int i = 0; i < str.length(); i++) {
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(str.charAt(i)));
        }
    }

    @Test
    public void test_char(){
        for (int i = 19; i < 5000; i++) {
            System.out.print(((char)i) +"\t");
            if (i % 10 == 0)
                System.out.println();
        }
    }
}
