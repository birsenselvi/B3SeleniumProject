package day31_testNg_cucumber.testNgGroups;

import org.testng.annotations.Test;

public class MyTest {
    @Test
    public void test1(){
        System.out.println("Test1");
    }
    @Test(groups = "A")
    public void test2(){

        System.out.println("Test2");
    }
    @Test(groups = {"A","B"})
    public void test3(){

        System.out.println("Test3");
    }
    @Test(groups = "B")
    public void test4(){

        System.out.println("Test4");
    }
    @Test
    public void test5(){

        System.out.println("Test5");
    }

}
