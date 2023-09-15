package gun35_runners_reports.runners;

import org.testng.TestNG;

public class TestNGRunner {

    public static void main(String[] args) {

        // TestNG nesnesi olusturuluyor
        TestNG testng = new TestNG();

        // run edilecek class'lar array olarak belirtiliyor
        testng.setTestClasses(new Class[]{Runner1_cucumberOptions.class});

        // testNG baslatiliyor
        testng.run();

    }
}
