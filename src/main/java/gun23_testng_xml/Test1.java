package gun23_testng_xml;

import org.testng.annotations.*;

public class Test1 {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite");
    }


    @Test
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
    }

}
