package gun23_testng_xml.xml3_parallel;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCount {

    /*
        BeforeTest(String testName):
            test
        Test1(int num): 0 num'a kadar for ile saysin
        Test2(int num): 0 dan num a kadar toplasin

        num xml dosyasindan gelsin
        xml icinde 3 test
            test Test1
            test Test2
            test Test1 ve Test2

            parallel calicadak

     */

    @BeforeTest
    @Parameters({"testName"})
    public void setup(@Optional("noname") String name){
        System.out.println(Thread.currentThread().getName() + " : " + name);
    }

    @Test
    @Parameters({"n"})
    public void test1(int num){
        for (int i = 0; i < num; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }

    @Test
    @Parameters({"m"})
    public void test2(int num){
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + " : " + sum);
    }

}
