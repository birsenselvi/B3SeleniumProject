package day24.ThreadLocal;

import org.openqa.selenium.WebDriver;

public class ThreadDriver {
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();


}
