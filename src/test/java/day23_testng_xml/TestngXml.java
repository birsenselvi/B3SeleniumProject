package day23_testng_xml;

import org.testng.annotations.*;

public class TestngXml {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuit");
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
    public void afterSuit(){
        System.out.println("AfterSuit");
    }
    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Test
    public void test2(){
        System.out.println("test2");
    }
}
