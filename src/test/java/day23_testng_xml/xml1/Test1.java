package day23_testng_xml.xml1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {

    @BeforeTest
    @Parameters({"testName"})
    public void start(String testName){
        System.out.println(Thread.currentThread().getName()+ ":" +testName);
    }
    @Parameters({"count"})
    @Test
    public void count(int num){
        for (int i = 0; i < num; i++) {
            System.out.println(Thread.currentThread().getName()+ ":" +i);
        }
    }
    @Parameters({"sum"})
    @Test
    public void sum(int num) {
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + ":" + sum);
    }
}
