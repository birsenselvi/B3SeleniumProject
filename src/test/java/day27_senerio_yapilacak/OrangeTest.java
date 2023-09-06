package day27_senerio_yapilacak;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
 * Login olun
 * login olundugunu assert edin
 * Menüden "Admin" linkine tiklayin
 * "Add" e tiklayin
 * "Add User" formunu doldurun
 * User Role : ESS
 * Status : enabled
 * Employee Name: Lisa ile baslayan isim secilecek
 * Username: istinct oldugu assert edilecek
 * Password:
 * Confirm Password:
 * Kaydin yapildigi notofocation mesaji ile assert edilecek
 * Kaydedilen useri "Search" ile bulun
 * Eklenen user'i silin
 * Silindiginden emin olun.
 */
public class OrangeTest extends BaseTest{

    Locator locator;
    String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";


    @BeforeClass
    public void classSetup(){
      locator =   PageFactory.initElements(driver, Locator.class);
      driver.get(url);
    }
    @Test
    public void testt1(){

        sendKeys(locator.userName, "Admin");
        sendKeys(locator.password, "admin123");
        click(locator.login);
        assertVisiblity(locator.logAssert);

    }

    @Test
    public void testt2(){

        click(locator.admin);
        click(locator.add);

    }
    @Test
    public void testt3(){

        click(locator.select);
        click(locator.ess);
        sendKeys(locator.name, "Li");
        click(locator.lisa);
        click(locator.select);
        click(locator.enable);

    }
}
