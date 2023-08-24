package gun19;

import org.testng.annotations.*;

public class TestNG_3Base {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before Suite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after Test");
    }


    @BeforeClass
    public void beforeClass(){
        System.out.println("before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("after Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("after Method");
    }

}
