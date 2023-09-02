package birsenselviCoskun.aufgabe01;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * 1.   git ->  http://uitestingplayground.com/
 * 2.  "Click"  linkine tikla
 * 3.  "Playground" yazisi altindaki butonun zemin-rengini bir "colorBeforeClick" degiskenine atayin ve consola yazdirin
 * 4.   butona tiklayin
 * 5.   butonun zemin-rengini "colorAfterClick" degiskenine atayin ve tekrar consola yazdirin
 * 6.   colorBeforeClick ve colorAfterClick degerlerinin farkli oldugunu assert edin
 */

public class _04 extends BaseClass {

    String url = "http://uitestingplayground.com/";
    By lLinkTest = By.linkText("Click");
    By lTextInput= By.cssSelector("btn btn-primary");


    @Test
    public void Testing(){

        // git ->  http://uitestingplayground.com/
        driver.manage().window().maximize();
        driver.get(url);

        // "Click"  linkine tikla
        //driver.findElement(lLinkTest).click();
        click(lLinkTest);

        // "Playground" yazisi altindaki butonun zemin-rengini bir "colorBeforeClick" degiskenine atayin ve consola yazdirin


       








        sleep(3000);
        driver.quit();

    }
}
