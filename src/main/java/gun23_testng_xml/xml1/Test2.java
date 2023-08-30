package gun23_testng_xml.xml1;

import org.testng.annotations.*;

public class Test2 {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite - 2");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest - 2");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest - 2");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite - 2");
    }


    @Test
    public void test1(){
        System.out.println("Test 1 - 2");
    }

    @Test
    public void test2(){
        System.out.println("Test 2 - 2");
    }

    @Test
    public void test3(){
        System.out.println("Test 3 - 2");
    }

}
