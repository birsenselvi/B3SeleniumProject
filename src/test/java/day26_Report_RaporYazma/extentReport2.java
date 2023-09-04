package day26_Report_RaporYazma;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class extentReport2 {

    ExtentSparkReporter html;

    ExtentReports report;

    ExtentTest test1, test2, test3;

    @BeforeSuite
    public void start(){

        html = new ExtentSparkReporter("report.html");
        report = new ExtentReports();
        report.attachReporter(html);
    }
    @Test
    public void test1(){

        test1 = report.createTest("Test1", "My First Test Report");

        test1.log(Status.INFO, "Test basladi");

       try{
           Assert.assertEquals(1,new Random().nextInt(3));
           test1.warning("!!!!!");
           test1.pass("Test basarili");
       }catch (AssertionError e){
           test1.fail("TEst Fail\n " + e.getMessage());
           Assert.fail();
       }
         test1.info("Test bitti");


    }
    @Test
    public void test2(){
        test2 = report.createTest("Test2", "My First Test Report");

        test2.log(Status.INFO, "Test basladi");

        try{
            Assert.assertEquals(1,new Random().nextInt(3));
            test2.warning("!!!!!");
            test2.pass("Test basarili");
        }catch (AssertionError e){
            test2.fail("TEst Fail\n " + e.getMessage());
            Assert.fail();
        }
        test2.info("Test bitti");


    }
    @Test
    public void test3(){

        test3 = report.createTest("Test3", "My First Test Report");

        test3.log(Status.INFO, "Test basladi");

        try{
            Assert.assertEquals(1,new Random().nextInt(3));
            test3.warning("!!!!!");
            test3.pass("Test basarili");
        }catch (AssertionError e){
            test3.fail("TEst Fail\n " + e.getMessage());
            Assert.fail();
        }
        test3.info("Test bitti");

    }


    @AfterSuite
    public void end(){

        report.setSystemInfo("Team", "QA Team");
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Directory", System.getProperty("user.dir"));
        report.setSystemInfo("Date Time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd.HH:mm:ss")));
        test1.addScreenCaptureFromPath("Screenshotsss/Resim 20230903172342.png");


        report.flush();

    }
}
