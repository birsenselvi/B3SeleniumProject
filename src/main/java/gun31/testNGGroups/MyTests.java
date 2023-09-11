package gun31.testNGGroups;

import org.testng.annotations.Test;

public class MyTests {


    @Test
    public void test1(){
        System.out.println("Test 1");
    }

    @Test(groups = "A")
    public void test2(){
        System.out.println("Test 2");
    }


    @Test(groups = {"A", "B"})
    public void test3(){
        System.out.println("Test 3");
    }


    @Test(groups = {"B"})
    public void test4(){
        System.out.println("Test 4");
    }

    @Test
    public void test5(){
        System.out.println("Test 5");
    }

}
