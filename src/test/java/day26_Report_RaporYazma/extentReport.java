package day26_Report_RaporYazma;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class extentReport {

    @Test
    public void test1(){

        // bu satir web sayfasi olusturmak icin kullanilir
        ExtentSparkReporter html;

        // Extent report
        ExtentReports report;

        // test olusturulur
        ExtentTest test;

        // html olusturulur
        html = new ExtentSparkReporter("report.html");

        // bir report nesnesi olusturulur
        report = new ExtentReports();

        // ExtentReport' u html'ye ekledik
        report.attachReporter(html);

        // report icin test creat edildi. name ve description
        test = report.createTest("Test1", "My First Test Report");

        // test icindeki gelismelere göre istenilen log kaydi tutulur.
        test.info("My Dirst Info Comment");
        test.log(Status.WARNING, "My log as Warning with Status");
        test.warning("My log as Warning, without Status");
        test.pass("Test is passed");

        // rapor sonuna eklenecek bilgiler
        report.setSystemInfo("Team", "QA Team");
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Directory", System.getProperty("user.dir"));
        report.setSystemInfo("Date Time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd.HH:mm:ss")));
        test.addScreenCaptureFromPath("Screenshotsss/Resim 20230903172342.png");

        // report yazilir ve kapatilir
        report.flush();


    }

    public static void main(String[] args) {

        System.getProperties().forEach((k,v)->{
            System.out.println(k + " : " + v);
        });
    }
}
