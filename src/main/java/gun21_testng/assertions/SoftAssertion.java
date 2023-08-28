package gun21_testng.assertions;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
/*
    Testlerde assertionslar hata verse de testler pass gibi görünür.
    softAssert.all(); ifadesi nerede yazilmis ise
    tüm assert sonuclari orada listelenir.

 */

public class SoftAssertion {

    SoftAssert softAssert;

    @BeforeTest
    public void beforeTest(){
        softAssert = new SoftAssert();
    }

    @AfterTest
    public void afterTest(){
        softAssert.assertAll();
    }


    @Test
    public void test1(){
        softAssert.assertEquals(1, 1);
        System.out.println("Test 1");
    }

    @Test
    public void test2(){
        softAssert.assertTrue(false, "fail ");
        System.out.println("Test 2");
    }

    @Test(dependsOnMethods = "test2")
    public void test3(){
        softAssert.assertNull(null);
        System.out.println("Test 3");
    }


    @Test
    public void test4(){
        softAssert.assertNotEquals(1, 1, "1=1 hatasi");
        System.out.println("Test 4");
    }
}
