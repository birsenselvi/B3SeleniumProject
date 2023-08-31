package gun24_testng_threadlocal.threadlocal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Random;

public class TestThreadLocal {

    public static int num;
    public static ThreadLocal<Integer> nums = new ThreadLocal<>();

    public static void main(String...args){

        Runnable r = new Runnable() {
            @Override
            public void run() {
                nums.set(new Random().nextInt(100));
                num = new Random().nextInt(100);
                System.out.println(nums.get());
            }
        };

        Thread t1 = new Thread(r, "T1");
        Thread t2 = new Thread(r, "T2");

        t1.start();
        t2.start();


    }
}
