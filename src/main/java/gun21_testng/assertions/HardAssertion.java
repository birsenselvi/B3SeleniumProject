package gun21_testng.assertions;

/*
    Assert yapildiginda hata olursa test orada kesilir
    Assert.assertTrue(false);
 */

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {

    @Test
    public void testAssertEquals(){
        int actual = 2;
        int expected = 3;
        Assert.assertEquals(actual, expected);
        //Assert.assertEquals(actual, expected, actual + " sayisi " + expected + " sayisina esit degil");
    }

    @Test
    public void testAssertTrue(){
        int num1 = 4;
        int num2 = 3;
        // conditions'in true olmasi beklenir
        //Assert.assertTrue(num1<num2);
        Assert.assertTrue(num1<num2, num1 + ", " + num2 + " den kücük degil");
    }

    @Test
    public void testAssertFalse(){
        int num1 = 4;
        int num2 = 3;
        // conditions'in false olmasi beklenir
        Assert.assertFalse(num1<num2);
        Assert.assertFalse(num1<num2, num1 + ", " + num2 + " den büyük");
    }


    @Test
    public void testAssert3(){
        /*
        Assert.assertNotEquals(, );

        Assert.assertSame(, );
        Assert.assertNotSame(, );

        Assert.assertNull();
        Assert.assertNotNull(, );

        Assert.assertEqualsDeep(, );

        Assert.assertEqualsNoOrder();

        Assert.fail();
         */

    }
}
