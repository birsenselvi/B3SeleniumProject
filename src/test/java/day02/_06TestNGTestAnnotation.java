package day02;


import org.testng.annotations.Test;

public class _06TestNGTestAnnotation {

    @Test
    public void test1(){
        // tstNG testleri run edildiginde mevcut classtan bir nesne olusturur ve istenen @Test i run eder.
        /**
         * sanki new _06TestNGTestAnnotation().test1();
         */

        System.out.println("1");
//        Assert.assertEquals(actual, expected, "hata durumunda aciklama"); iki deger esit mi?
//        Assert.assertTrue(); --> boolean true olmali
//        Assert.assertFalse(); --> boolean false olmali
    }

    @Test
    public void test2(){
        System.out.println("2");
    }
}
