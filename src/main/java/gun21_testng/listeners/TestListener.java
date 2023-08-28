package gun21_testng.listeners;

import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(MyListener.class)
public class TestListener {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest");
    }

    @Test(testName = "my test 1")
    public void test1(){
        System.out.println("Test 1");
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
    }

    @Test
    public void test3(){
        System.out.println("Test 3");
        Assert.fail();
    }

}
