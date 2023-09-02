package day24.ThreadLocal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;

//Thread--ayni anda yapilan islemler
public class TestThread {

    public static ThreadLocal<Integer> nums = new ThreadLocal<>();

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                nums.set(new Random().nextInt(100));
                System.out.println(nums.get());
            }
        };

        Thread t1 = new Thread(r,"T1");
        Thread t2 = new Thread(r,"T2");
        t1.start();
        t2.start();
        System.out.println(Math.random());
    }
}


