package gun04;

import org.testng.annotations.Test;

public class _06TestNGTestAnnotation {


    @Test
    public void test1(){
        // testNG testleri run edildiginde mevcut class'dan bi nesne olusturur ve istenen @Test'i run eder
        /* sanki ->
            _06TestNGTestAnnotation testClass = new _06TestNGTestAnnotation();
            testClass.test1();

         */
        System.out.println("1");
        // Assert.assertEquals(actual, expected, "hata durumunda aciklama");  iki deger esit mi
        // Assert.assertTrue(boolean); -> boolean true olmali
        // Assert.assertFalse();       -> boolean false olmali

    }

    @Test
    public void test2(){
        System.out.println("2");
    }

}
