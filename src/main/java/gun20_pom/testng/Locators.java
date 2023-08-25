package gun20_pom.testng;

import org.openqa.selenium.By;

public enum Locators {

    Accept_Cookie(By.id("L2AGLb")),
    Searchbox(By.name("q")),
    SearchButton(By.name("btnK"))


    ;

    private By locator;

    Locators(By locator) {
        this.locator = locator;
    }

    public By getLocator(){
        return locator;
    }


}
