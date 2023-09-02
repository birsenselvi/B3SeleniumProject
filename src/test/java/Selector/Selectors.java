package Selector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Selectors extends BaseClass {
    @Test
    public void Test(){
        driver.get("http://opencart.abstracta.us/");
        By aElementCss = By.cssSelector("a");
        By aElementXpath = By.cssSelector("//a");
        System.out.println(driver.findElement(aElementCss));
        List<WebElement> elements = driver.findElements(aElementCss);
        for (WebElement elemt : elements) {
            if(elemt.getText().length()>0)
            System.out.println(elemt.getText());
        }



        driver.quit();
    }
    @Test
    public void Test1(){
        driver.get("http://opencart.abstracta.us/");
        By aElementCss = By.cssSelector("a");
        By aElementXpath = By.cssSelector("//a");
        System.out.println(driver.findElement(aElementXpath));
        List<WebElement> elements = driver.findElements(aElementXpath);
        List<WebElement> newList = elements
                .stream()
                .filter(e->e.getText().length()>0)
                .collect(Collectors.toList());
        System.out.println("Sayfadaki a elementi sayisi : " + newList.size());
        newList.forEach(e-> System.out.println(e.getText()));
        for (WebElement elemt : elements) {
            if(elemt.getText().length()>0)
                System.out.println(elemt.getText());
        }



        driver.quit();
    }
    public void Test3(){
        driver.get("http://opencart.abstracta.us/");




        driver.quit();
    }
}


