package Bonus_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    //Protected WebDriver ve WebDriver Wait tanimlayiniz
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Constructor tanimlayiniz
     * WebDriver bir parametre alacak,
     * bu class i extend eden child class'larin elementleri bu classda initialize edilebilir.
     * Bu durumda child class'larda PageFactory.initElements(driver, this);
     * kullanmaya gerek kalmaz. tercih sizin
     * @param driver
     */
    protected BasePage(WebDriver driver){
    }

    /**
     * click methodu tanimlayiniz
     * WebElement bir parametre alacak
     * @param element
     */
    public void click(WebElement element){
    }

    /**
     * sendkeys methodu tanimlayiniz
     * WebElement ve String iki parametre alacak
     * @param element
     * @param text
     */
    public void sendkeys(WebElement element, String text){
    }

    /**
     * scrollIntoView methodu tanimlayiniz
     * WebElement bir parametre alacak
     * @param element
     */
    public void scrollIntoView(WebElement element){
    }


}

